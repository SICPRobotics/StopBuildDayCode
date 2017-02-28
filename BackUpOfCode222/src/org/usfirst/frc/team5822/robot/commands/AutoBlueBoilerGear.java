package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueBoilerGear extends CommandGroup {

    public AutoBlueBoilerGear()
    {
     addSequential(new DriveForward(37));
     addSequential(new TurnRightFast(55));
     addSequential(new TurnLeftSlow(55));
     addSequential(new ResetEncoder());
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(70));
     addSequential(new DriveSlow(2));
  
     //Need the stuff that lets the human player take up gear
    }
}
