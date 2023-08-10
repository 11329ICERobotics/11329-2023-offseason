package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Drivetrain;

@TeleOp(name="Allen Test Drive", group="Allen op mode")
public class Teleop extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    Drivetrain drivetrain;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        drivetrain = new Drivetrain(hardwareMap);
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            drivetrain.driveSpeed = DriveSpeedEnum.Fast;
        } else {
            drivetrain.driveSpeed = DriveSpeedEnum.Slow;
        }
        drivetrain.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }

    @Override
    public void stop() {
        drivetrain.stopDrive();
    }
}
