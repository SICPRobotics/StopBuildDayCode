package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBlueBoilerGearShoot extends CommandGroup 
{
	/*didn't have time to finish incorporating vision to help us line up with the boiler 
	  or to make it fast enough to fit in auto*/
	
    public AutoBlueBoilerGearShoot() 
    {
    	addSequential(new AutoBlueBoilerGear());
    	addSequential(new DriveBackward(48.5));
    	addSequential(new TurnRightFast(59.24));
    	addSequential(new TurnLeftSlow(59.24));
    	addSequential(new DriveBackward(-96.38));
    }
}
