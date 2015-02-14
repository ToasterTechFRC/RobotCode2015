package org.usfirst.frc.team5332.robot.control;

import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.Joystick;

public class DoubleJoystick extends InputController{
	public final static DoubleJoystick instance=new DoubleJoystick();
	private Joystick joystick1,joystick2;
	private boolean last23,last22;
	public DoubleJoystick(){
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
	}

	@Override
	public boolean intakeDriveLeft() {
		return false;
	}

	@Override
	public boolean intakeMoveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeDriveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeMoveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeClamp() {
		// TODO Auto-generated method stub
 		return joystick1.getRawButton(1);
	}

	@Override
	public boolean intakeRelease() {
		// TODO Auto-generated method stub
		return joystick1.getRawButton(2);
	}

	@Override
	public boolean intakeDriveForward() {
		// TODO Auto-generated method stub
		return joystick2.getRawButton(1);
	}

	@Override
	public boolean intakeDriveBackward() {
		// TODO Auto-generated method stub
		return joystick2.getRawButton(2);
	}

	@Override
	public boolean liftNextLevel() {
		// TODO Auto-generated method stub
		return joystick1.getRawButton(3);
	}

	@Override
	public boolean liftLastLevel() {
		// TODO Auto-generated method stub
		return joystick2.getRawButton(3);
	}

	@Override
	public double driveLeft() {
		// TODO Auto-generated method stub
		return joystick1.getY();
	}

	@Override
	public double driveRight() {
		// TODO Auto-generated method stub
		return joystick2.getY();
	}
}
