package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb extends Command {
	
	public Climb() 
	{	
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		/*SmartDashboard.putBoolean("Climbing", true); */
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		Robot.climber.climb();
		System.out.println("CLIMBING");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
	
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		
	}
}
