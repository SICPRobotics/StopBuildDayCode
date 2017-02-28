package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleHG extends Command {

	boolean notDone; 
    public ToggleHG() {
       requires (Robot.vision); 
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	VisionPID.toggleHG(); 
    	System.out.println("TOGGLED HG INITIALIZED");
    	SmartDashboard.putBoolean("Toggle HG Called", true);
    	notDone = true; 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	System.out.println("TOGGLING FOR HG");    
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (notDone)
    		return true;
    	else
    		return false; 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
