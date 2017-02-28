package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenterGear extends CommandGroup {

    public AutoCenterGear() {
    	 
       addSequential(new DriveForward(3)); 
    	addSequential(new GearCG());
       addSequential(new DriveForward(63));
       addSequential(new DriveSlow(2));
    }
}
