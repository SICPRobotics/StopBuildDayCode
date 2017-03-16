package org.usfirst.frc.team5822.robot.commands;



import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Swallow extends Command {
 
    public Swallow() 
    {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.intake.takeIn();
    	System.out.println("intake");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    }

    protected void interrupted() 
    {
    }
}
