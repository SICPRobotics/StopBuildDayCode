package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitForPilot extends Command {

	Timer wait;
	
    public WaitForPilot() 
    {
    	wait = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	wait.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       if (wait.get()<4)
    	return false;
       else
    	   return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
