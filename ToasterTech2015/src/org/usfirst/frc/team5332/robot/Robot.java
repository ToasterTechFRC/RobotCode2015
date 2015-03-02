
package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.Drive;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;
import org.usfirst.frc.team5332.robot.drive.DriveSelector;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveAutoBehavior;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveIntakeToteAuto;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveTeleopBehavior;
import org.usfirst.frc.team5332.robot.drive.system.DriveReal;
import org.usfirst.frc.team5332.robot.intake.Intake;
import org.usfirst.frc.team5332.robot.intake.behavior.IntakeIntakeToteAuto;
import org.usfirst.frc.team5332.robot.intake.behavior.IntakeTeleopBehavior;
import org.usfirst.frc.team5332.robot.intake.systems.IntakeReal;
import org.usfirst.frc.team5332.robot.lift.Lift;
import org.usfirst.frc.team5332.robot.lift.behavior.LiftTeleopBehavior;
import org.usfirst.frc.team5332.robot.lift.behavior.LiftTestBehavior;
import org.usfirst.frc.team5332.robot.lift.system.LiftReal;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Drive drive;
	Intake intake;
	Lift lift;
	Camera camera;
    public void robotInit() {
    	drive=DriveSelector.get(DriveSelector.DriveMode.real);
    	intake=new Intake(new IntakeReal());
    	lift=new Lift(new LiftReal());
    	camera=new Camera("cam0");
    	camera.init();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit(){
    	//DrivePushToteAuto dauto=new DrivePushToteAuto();
    	DriveAutoBehavior dauto=new DriveAutoBehavior();
    	//DriveIntakeToteAuto dauto=new DriveIntakeToteAuto();
    	//IntakeIntakeToteAuto iauto = new IntakeIntakeToteAuto();
    	dauto.init();
    	drive.setBehavior(dauto);
    	//intake.setBehavior(iauto);
    }
    public void autonomousPeriodic() {
    	drive.run();
    	//intake.run();
    }
    public void teleopInit(){
    	drive.setBehavior(new DriveTeleopBehavior());
    	intake.setBehavior(new IntakeTeleopBehavior());
    	lift.setBehavior(new LiftTeleopBehavior());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.run();
        intake.run();
        lift.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
