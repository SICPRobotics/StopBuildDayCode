package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSlow extends Command {

	Timer timer;
	int time;
    public DriveSlow(int desired) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = desired;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	timer = new Timer(); 
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("drive slow");
    	DriveTrain.drive.drive(-.1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.get() < time)
        	return false;
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
