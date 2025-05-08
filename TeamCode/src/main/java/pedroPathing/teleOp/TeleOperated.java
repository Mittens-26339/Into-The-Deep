package pedroPathing.teleOp;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import pedroPathing.teleOp.constantsAndSubsystems.Constants;
import pedroPathing.teleOp.constantsAndSubsystems.DriveTrain;
import pedroPathing.teleOp.constantsAndSubsystems.Intake;

@TeleOp(name = "TeleOp", group = "TeleOp")
public class TeleOperated extends LinearOpMode {




    @Override
    public void runOpMode() {

        Constants Constant = new Constants();
        DriveTrain driveTrain = new DriveTrain();
        Intake intake = new Intake();
        telemetry.addData("Status", "Ready to Start");
        telemetry.update();

        waitForStart();
        driveTrain.DrivetrainStart();

        while (opModeIsActive()) {
        driveTrain.DrivetrainLoop();
        intake.IntakeDrive();


        }
    }
}
