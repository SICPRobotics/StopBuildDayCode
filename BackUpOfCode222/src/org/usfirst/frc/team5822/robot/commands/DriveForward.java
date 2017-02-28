package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

/**
 *
 */
public class DriveForward extends Command {
	
double distance;
	Timer tele;
	
	public DriveForward(double encoderDistance) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensors);
		distance = encoderDistance;
		tele = new Timer();
	
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		Sensors.resetGyro();
		Robot.vision.disable();
		DriveTrain.pidBackwards(true);
		Robot.driveTrain.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		System.out.println("Drive forward");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (!RobotState.isEnabled())
		{
			return true; 
		}
		
		if (Sensors.rightEncoderDistance() < distance)
		{
			return false;
		}
		
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		Robot.driveTrain.disable();
		DriveTrain.drive.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		
	}
}
