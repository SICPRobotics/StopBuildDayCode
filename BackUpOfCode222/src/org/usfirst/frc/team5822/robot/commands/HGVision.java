package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class HGVision extends Command {

		
    public HGVision() 
    {
        requires (Robot.vision); 
       
      
     }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	if (VisionPID.hGVision)
    	{
    		Robot.vision.enable();
    		System.out.println("PID enabled");
    		 
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	System.out.println("RUNNING HG VISION");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	
        if (!VisionPID.hGVision)
        {
        	Robot.vision.disable();
        	return true; 
        }
        		
        
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("END OF HG COMMAND");
    	Robot.vision.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
