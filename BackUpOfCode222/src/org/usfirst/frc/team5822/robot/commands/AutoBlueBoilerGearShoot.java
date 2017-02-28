package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueBoilerGearShoot extends CommandGroup {

    public AutoBlueBoilerGearShoot() 
    {
    	addSequential(new AutoBlueBoilerGear());
    	addSequential(new DriveBackward(48.5));
    	addSequential(new TurnRightFast(59.24));
    	addSequential(new TurnLeftSlow(59.24));
    	addSequential(new DriveBackward(-96.38));
    }
}
