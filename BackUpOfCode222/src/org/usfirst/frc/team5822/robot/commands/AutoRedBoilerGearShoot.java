package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRedBoilerGearShoot extends CommandGroup
{
	public AutoRedBoilerGearShoot()
	{
		//TODO: test this distance
		
		addSequential(new AutoRedBoilerGear());
			
	    addSequential(new ResetEncoder());
	    addSequential(new ResetGyro()); 
		addSequential(new DriveBackward(-18));
		addSequential(new ResetGyro());
		
		//TODO: this broke here
		addSequential(new TurnRightFast(59.42)); //almost 180, turn around to the boiler
		addSequential(new TurnLeftSlow(59.42));
		addSequential(new DriveBackward(20));
		addSequential(new ResetGyro());
		addSequential(new TurnLeftFast(-74.79));
		addSequential(new TurnRightSlow(-74.79));
		addSequential(new DriveBackward(27));
		//addSequential(new LineUpBoiler());
		//addSequential(new Shoot());
	}
}
