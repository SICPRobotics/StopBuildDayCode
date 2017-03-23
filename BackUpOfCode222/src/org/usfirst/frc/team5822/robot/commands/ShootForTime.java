package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootForTime extends Command {

	Timer wait; 
    public ShootForTime() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	wait = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	Shooter.init();
    	wait.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Shooter.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (wait.get()>11)
    		return true; 
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.shooter.stopShooting();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
