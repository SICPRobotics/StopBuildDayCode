package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenterGear extends CommandGroup {

    public AutoCenterGear() {
    	 
       addSequential(new DriveForward(64)); 
       addSequential(new WaitForPilot());
       addSequential(new DriveSlow(6));
       //addSequential(new GearCG());
       //addSequential(new DriveForward(63));
       //addSequential(new DriveSlow(2));
    }
}
