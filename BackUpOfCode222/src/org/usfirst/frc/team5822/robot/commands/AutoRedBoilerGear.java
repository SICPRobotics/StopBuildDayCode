package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedBoilerGear extends CommandGroup {

    public AutoRedBoilerGear()
    {
     addSequential(new DriveForward(40));
     addSequential(new TurnLeftFast(-55));
     addSequential(new TurnRightSlow(-55));
     addSequential(new ResetEncoder());
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(63));
     addSequential(new DriveSlow(2));
     //Need the stuff that lets the human player take up gear
    }
}
