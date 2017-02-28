package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossBaseline extends CommandGroup {

    public AutoCrossBaseline() 
    {
    	addSequential(new DriveForward(120));
    }
}
