package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Set180 extends Command {

	private boolean foo; 
    public Set180(boolean setTo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	foo = setTo;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	/*SmartDashboard.putBoolean("Turn 180", foo); */
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
