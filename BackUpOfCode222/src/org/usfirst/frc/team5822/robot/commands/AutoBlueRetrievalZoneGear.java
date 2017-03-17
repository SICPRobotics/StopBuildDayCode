package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueRetrievalZoneGear extends CommandGroup {

    public AutoBlueRetrievalZoneGear()
    {
    
    	//TODO: this distance needs to be changed. Then literally call exactly what is in AutoRedBoiler
     addSequential(new DriveForward(76));
     addSequential(new TurnLeftFast(-60));
     addSequential(new TurnRightSlow(-60));
     addSequential(new ResetEncoder());
     addSequential(new ChangeVisionDistance(36)); 
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(47));
     addSequential(new DriveSlow(4));
   
     //Need the stuff that lets the human player take up gear
    }
}
