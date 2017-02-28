package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

/**
 *
 */
public class DriveBackward extends Command 
{
	double distance;
	Timer tele;
	
	
	public DriveBackward(double encoderDistance) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensors);
		tele = new Timer();
		distance = encoderDistance;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		Sensors.resetEncoders();
		Sensors.resetGyro();
		//Robot.driveTrain.pidBackwards(true);
		//Robot.driveTrain.enable();
		tele.start();
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		System.out.println("Drive Backward");
		DriveTrain.driveBackward();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if ( Sensors.rightEncoderDistance() > distance)
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		
	}
}
