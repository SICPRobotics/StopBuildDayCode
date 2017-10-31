package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeIsTurning extends Command {

    boolean isTurning; 
    
	public ChangeIsTurning(boolean val) 
    {
        isTurning = val; 
        requires (Robot.driveTrain); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.driveTrain.changeIsTurning(isTurning);
    	if(Robot.driveTrain.isTurning==false)
    		Robot.driveTrain.drive.setLeftRightMotorOutputs(0, 0);
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
