package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBlueBoilerGear extends CommandGroup 
{
	//turn angle close but not quite right

    public AutoBlueBoilerGear()
    {
    	addSequential(new DriveForward(59)); 
    	addSequential(new TurnRightFast(60));
    	addSequential(new TurnLeftSlow(60));
    	addSequential(new ResetEncoder());
    	
    	addSequential(new DriveForward(63));
        addSequential(new WaitForPilot());
    	addSequential(new DriveSlow(2));
    }
}
