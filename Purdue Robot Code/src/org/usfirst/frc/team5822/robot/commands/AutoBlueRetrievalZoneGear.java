package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBlueRetrievalZoneGear extends CommandGroup 
{
	//turn angle close but not quite right
 
	public AutoBlueRetrievalZoneGear()
    {
	     addSequential(new DriveForward(60));
	     addSequential(new TurnLeftFast(-60));
	     addSequential(new TurnRightSlow(-60));
	     addSequential(new ResetEncoder());
	
	     addSequential(new ResetGyro());
	     addSequential(new DriveForward(63));
	     addSequential(new WaitForPilot());
	     addSequential(new DriveSlow(4));

	     //Need the stuff that lets the human player take up gear
    }
}
