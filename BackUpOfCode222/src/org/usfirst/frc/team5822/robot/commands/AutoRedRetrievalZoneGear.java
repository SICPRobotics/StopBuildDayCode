package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedRetrievalZoneGear extends CommandGroup {

    public AutoRedRetrievalZoneGear()
    {
    
    	//TODO: this distance needs to be changed. Then literally call exactly what is in AutoRedBoiler
     addSequential(new DriveForward(30));
     addSequential(new TurnRightFast(59.42));
     addSequential(new TurnLeftSlow(59.42));
     addSequential(new ResetEncoder());
     addSequential(new ChangeVisionDistance(70)); 
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(95));
     addSequential(new DriveSlow(2));
     //Need the stuff that lets the human player take up gear
    }
}
