package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

/**
 *
 */
public class TurnRightSlow extends Command {
	
	double turnAngle;

	
	public TurnRightSlow (double desiredAngle) 
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
		System.out.println("WE ARE TURNING RIGHT SLOWLY");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		DriveTrain.turnRightSlow();
		System.out.println(Sensors.gyroAngle());
		System.out.println("WE ARE TURNING RIGHT SLOWLY");		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{

		if (turnAngle > Sensors.gyroAngle())
		{
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
