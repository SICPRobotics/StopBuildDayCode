package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

/**
 *
 */
public class TurnLeftSlow extends Command {
	
	double turnAngle;
	
	public TurnLeftSlow(double desiredAngle) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensors);
		turnAngle = desiredAngle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		System.out.println("turning left slow ANGELA IS AWESOME");
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		DriveTrain.turnLeftSlow();
		System.out.println(Robot.sensors.gyroAngle());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{

		if (turnAngle < Robot.sensors.gyroAngle())
		{
			System.out.println("not finished");
			System.out.println(Robot.sensors.gyroAngle());
			System.out.println(turnAngle);
			return false;
		}
		else
		{
			return true;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		System.out.println("done with turn");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
}
