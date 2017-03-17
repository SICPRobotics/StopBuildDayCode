package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedRetrievalZoneGear extends CommandGroup {

    public AutoRedRetrievalZoneGear()
    {
    
    	//TODO: this distance needs to be changed. Then literally call exactly what is in AutoRedBoiler
     addSequential(new DriveForward(75));
     addSequential(new TurnRightFast(60));
     addSequential(new TurnLeftSlow(60));
     addSequential(new ResetEncoder());
     addSequential(new ChangeVisionDistance(36)); 
     addSequential(new GearCG());
     addSequential(new ResetGyro());
     addSequential(new DriveForward(55));
     addSequential(new DriveSlow(2));
     //Need the stuff that lets the human player take up gear
    }
}
