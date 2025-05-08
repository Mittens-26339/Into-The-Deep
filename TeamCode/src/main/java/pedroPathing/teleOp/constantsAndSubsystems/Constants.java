package pedroPathing.teleOp.constantsAndSubsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Constants {
    //MOTOR VARIABLES
    public DcMotor motorFrontRight;
    public DcMotor motorFrontLeft;

    public DcMotor motorBackLeft;

    public DcMotor motorBackRight;
    public DcMotor motorIntake;
    public DcMotor motorLiftOne;
    public DcMotor motorLiftTwo;

    //SERVO VARIABLES
    public Servo intakeClaw;
    public Servo intakePivotOne;
    public Servo intakePivotTwo;
    public Servo intakeClawPivot1;
    public Servo intakeClawRot;
    public Servo outtakeClaw;
    public Servo outtakePivot1;
    public Servo outtakePivot2;
    public Servo outtakeClawPivot1;
    public Servo outtakeClawRot;
    public Gamepad gamepadOne = gamepad1;
    public Gamepad gamepadTwo = gamepad2;

    public Constants(){
        //MOTOR HWMAP
        //motorFrontRight = hardwareMap.get(DcMotor.class, "mfr");
        //motorFrontLeft = hardwareMap.get(DcMotor.class, "mfl");
        //motorBackLeft = hardwareMap.get(DcMotor.class, "mbl");
        //motorBackRight = hardwareMap.get(DcMotor.class, "mbr"); Using pedro pathng motors
        motorIntake = hardwareMap.get(DcMotor.class, "mi");
        motorLiftOne = hardwareMap.get(DcMotor.class, "ml1");
        motorLiftTwo = hardwareMap.get(DcMotor.class, "ml2");
        //SERVO HWMAP
        intakeClaw = hardwareMap.get(Servo.class, "ic");
        intakePivotOne = hardwareMap.get(Servo.class, "ip1");
        intakePivotTwo = hardwareMap.get(Servo.class, "ip2");
        intakeClawPivot1 = hardwareMap.get(Servo.class, "icp1");
        intakeClawRot = hardwareMap.get(Servo.class, "icr");
        outtakeClaw = hardwareMap.get(Servo.class, "oc");
        outtakePivot1 = hardwareMap.get(Servo.class, "op1");
        outtakePivot2 = hardwareMap.get(Servo.class, "op2");
        outtakeClawPivot1 = hardwareMap.get(Servo.class, "ocp1");
        outtakeClawRot = hardwareMap.get(Servo.class, "ocr");

        motorIntake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLiftOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLiftOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLiftTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLiftTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }


    //Intake subsystem
    public int motorIntakeMax = 1200;
    public int motorIntakeMin = 200;
    public int zero = 0;
    public double intakeClawOpenPos = 0.975;
    public double intakeClawClosePos = 0.875;
    public double intakeClawRotPosOne;
    public double intakeClawRotPosTwo;
    public double intakeClawPivotOneDownPos;
    public double intakeClawPivotOneUpPos;
    public double intakePivotOneDownPos;
    public double intakePivotTwoDownPos = Math.abs(intakePivotOneDownPos-1);
    public double intakePivotOneUpPos;
    public double intakePivotTwoUpPos = Math.abs(intakePivotOneUpPos - 1);






    //transfer subsystem

    public double servoTransferClawOpen = 0.4;
    public double servoTransferClawClose = 0.5;
    public double servoTransferPivotPickUpPos;
    public double servoTransferPivotSampleScorePos;
    public double servoTransferPivotSpecimenScorePos;
    public double servoTransferWristUpPose;
    public double servoTransferWristDownPose;



}
