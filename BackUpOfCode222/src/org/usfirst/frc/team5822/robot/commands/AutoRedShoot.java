package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedShoot extends CommandGroup {

    public AutoRedShoot() 
    {
    	addSequential(new ShootForTime());
    	addSequential(new DriveForward(24));
    	addSequential(new TurnRightFast(75));
    	addSequential(new DriveForward(100));
    }
}
