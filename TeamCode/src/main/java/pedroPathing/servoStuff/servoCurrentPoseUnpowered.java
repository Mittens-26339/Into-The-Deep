package pedroPathing.servoStuff;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;



@TeleOp(name="servo Pos", group="TeleOp")
public class servoCurrentPoseUnpowered extends LinearOpMode {


    private Servo servo;

    @Override
    public void runOpMode() {
        // Initialize hardware
        servo = hardwareMap.get(Servo.class, "servo");
        double servoPose = 0.5;


        // Wait for start
        waitForStart();
        servo.setPosition(0.5);
        while (opModeIsActive()) {

            if(gamepad1.a){
                servoPose += 0.0001;
            }
            if(gamepad1.b){
                servoPose -= 0.0001;
            }
            servo.setPosition(servoPose);
            telemetry.addData("servoPos: ", servo.getPosition());
            telemetry.update();
        }
    }
}