package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedBoilerGear extends CommandGroup {

    public AutoRedBoilerGear()
    {
     addSequential(new DriveForward(59)); //we like the 59
     addSequential(new TurnLeftFast(-60));
     addSequential(new TurnRightSlow(-60));
     addSequential(new ResetEncoder());
    // addSequential(new ChangeVisionDistance(36)); 
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(63));
     addSequential(new DriveSlow(4));
     //Need the stuff that lets the human player take up gear
    }
}
