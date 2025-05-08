package pedroPathing.teleOp.constantsAndSubsystems;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;

import pedroPathing.teleOp.constantsAndSubsystems.Constants;
public class Intake {
    Constants constant = new Constants();
    Timer intakeTimer = new Timer();
    Timer intakeRotation = new Timer();
    public Intake(){
        constant.motorIntake = hardwareMap.get(DcMotor.class, "mi");
    }
    public void IntakeDrive(){
        if (constant.gamepadTwo.a){
            if(constant.motorIntake.getCurrentPosition() < 500 && intakeTimer.getElapsedTimeSeconds() > 1.5) {
                constant.motorIntake.setTargetPosition(constant.motorIntakeMax);
            } else if (constant.motorIntake.getCurrentPosition() > 500 && intakeTimer.getElapsedTimeSeconds() > 1.5){
                constant.motorIntake.setTargetPosition(constant.motorIntakeMin);
            }
        }
        if (constant.motorIntake.getCurrentPosition()>1100){
            constant.intakePivotOne.setPosition(constant.intakeClawPivotOneDownPos);
        } else {
            constant.intakePivotOne.setPosition(constant.intakeClawPivotOneUpPos);
        }

        if (constant.motorIntake.getCurrentPosition()<1100){
            constant.intakePivotOne.setPosition(constant.intakePivotOneUpPos);
            constant.intakePivotTwo.setPosition(constant.intakePivotTwoUpPos);
        } else if(constant.motorIntake.getCurrentPosition()>1100 && constant.gamepadTwo.right_bumper) {
            constant.intakePivotOne.setPosition(constant.intakePivotOneDownPos);
            constant.intakePivotTwo.setPosition(constant.intakePivotTwoDownPos);
        }



    }

}
