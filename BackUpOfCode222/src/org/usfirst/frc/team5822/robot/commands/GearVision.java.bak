package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearVision extends Command {
	
	

    public GearVision() 
    {
    	requires (Robot.vision);
    	
     
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	if (VisionPID.gearVision)
    	{
    		Robot.vision.enable(); 
    		Robot.vision.setSetpoint(0);
    	
    	}
    	
    	VisionPID.changeGearDone(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    
    	System.out.println("Gear Vision - CENTER VALUE: " + VisionPID.piTable.getNumber("Center G", 0));
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	
    	if (!VisionPID.gearVision)
    	{
    		
    		Robot.vision.disable();
    		return true; 
    	   
    	}
    	
    	else if (VisionPID.gearDone)
    		return true; 
    		
    	return false; 
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.vision.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
