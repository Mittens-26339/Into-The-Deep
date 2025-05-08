package pedroPathing.servoStuff;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;



@TeleOp(name="servo 0.5", group="Autonomous")
public class servopointfive extends LinearOpMode {


    private Servo servo;

    @Override
    public void runOpMode() {
        // Initialize hardware
        servo = hardwareMap.get(Servo.class, "servoIntakeWrist");



        // Wait for start
        waitForStart();

        while (opModeIsActive()) {
            servo.setPosition(0.5);
        }
    }
}