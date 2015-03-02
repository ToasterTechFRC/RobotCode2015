package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.control.Deadband;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.Gamepad;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.control.InputScaling;
import org.usfirst.frc.team5332.robot.control.InputScalingFactor;
import org.usfirst.frc.team5332.robot.control.LinearScaling;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends DriveBehavior{
	protected InputController controller;
	protected double 		leftSpeed,	rightSpeed;
	protected InputScalingFactor scaling;
	protected Joystick 		joystick;
	public DriveTeleopBehavior(){
		super();
		joystick=IO.joystick1;
		scaling=new InputScalingFactor(1);
	}
	public DriveTeleopBehavior(DriveLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO	
		controller=DoubleJoystick.instance;

	}
	public void run(){
		leftSpeed=joystick.getRawAxis(1);
		rightSpeed=joystick.getRawAxis(5);
		double leftSign=(leftSpeed>0.00)?1.0:-1.0;
		double rightSign=(rightSpeed>0.0)?1.0:-1.0;
		logic.driveMotors(leftSign*leftSpeed*leftSpeed, rightSign*rightSpeed*rightSpeed);
	}
}
