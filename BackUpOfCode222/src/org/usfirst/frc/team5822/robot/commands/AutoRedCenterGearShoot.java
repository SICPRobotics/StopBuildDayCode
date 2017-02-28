package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedCenterGearShoot extends CommandGroup {

    public AutoRedCenterGearShoot() 
    {
    	addSequential(new AutoCenterGear());
    	addSequential(new DriveBackward(-40.07));
    	addSequential(new TurnRightFast(46.57));                      
    	addSequential(new TurnLeftSlow(46.57));
    	addSequential(new DriveForward(142.25));
    	addSequential(new Shoot());
    }
}
