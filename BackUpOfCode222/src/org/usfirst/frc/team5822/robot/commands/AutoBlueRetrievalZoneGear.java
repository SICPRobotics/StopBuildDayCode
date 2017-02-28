package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueRetrievalZoneGear extends CommandGroup {

    public AutoBlueRetrievalZoneGear()
    {
    
    	//TODO: this distance needs to be changed. Then literally call exactly what is in AutoRedBoiler
     addSequential(new DriveForward(30));
     addSequential(new TurnLeftFast(-53));
     addSequential(new TurnRightSlow(-53));
     addSequential(new ResetEncoder());
     addSequential(new ChangeVisionDistance(65)); 
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(80));
     addSequential(new DriveSlow(2));
   
     //Need the stuff that lets the human player take up gear
    }
}
