package pedroPathing.teleOp;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.Servo;

public class HuskyLensDetection {
    private HuskyLens huskyLens;
    private Servo alignmentServo;

    private static final int COLOR_ID_1 = 1;  // Replace with your actual first color ID
    private static final int COLOR_ID_2 = 2;  // Replace with your actual second color ID

    private static final double SERVO_HORIZONTAL = 0.0;
    private static final double SERVO_VERTICAL = 1.0;
    private static final double SERVO_DIAGONAL = 0.5;

    private Integer lockedTargetID = null;
    private boolean targetLocked = false;

    private long detectionStartTime = 0;
    private static final long STABLE_TIME = 500; // Time in milliseconds for the target to be stable

    public HuskyLensDetection(HuskyLens huskyLens, Servo alignmentServo) {
        this.huskyLens = huskyLens;
        this.alignmentServo = alignmentServo;
    }

    public void alignToTarget() {
        HuskyLens.Block[] blocks = huskyLens.blocks();

        if (blocks == null || blocks.length == 0) {
            targetLocked = false;
            lockedTargetID = null;
            return;
        }

        HuskyLens.Block bestBlock = null;
        int bestArea = 0;

        for (HuskyLens.Block block : blocks) {
            int objID = block.id;
            int width = block.width;
            int height = block.height;
            int area = width * height;

            if (objID == COLOR_ID_1 /*|| objID == COLOR_ID_2*/) {
                // Ensure the target has been stable before locking it
                if (!targetLocked || (lockedTargetID != null && objID == lockedTargetID)) {
                    if (area > bestArea) {
                        bestBlock = block;
                        bestArea = area;
                    }
                }
            }
        }

        if (bestBlock != null) {
            // Lock the target and start the detection timer if it's the first time
            if (!targetLocked) {
                lockedTargetID = bestBlock.id;
                targetLocked = true;
                detectionStartTime = System.currentTimeMillis(); // Reset detection timer
            }

            // Check if the object has been stable for a certain time before aligning
            if (System.currentTimeMillis() - detectionStartTime > STABLE_TIME) {
                double servoPosition;
                if (bestBlock.width > bestBlock.height * 1.5) {
                    servoPosition = SERVO_HORIZONTAL;
                } else if (bestBlock.height > bestBlock.width * 1.5) {
                    servoPosition = SERVO_VERTICAL;
                } else {
                    servoPosition = SERVO_DIAGONAL;
                }

                // Move the servo to the appropriate position
                alignmentServo.setPosition(servoPosition);
            }
        } else {
            targetLocked = false;
            lockedTargetID = null;
        }
    }
}
