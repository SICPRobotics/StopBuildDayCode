package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeVisionDistance extends Command {

	int m_distance; 
    public ChangeVisionDistance(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_distance = distance; 
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.vision.visionDistance = m_distance; 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
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
