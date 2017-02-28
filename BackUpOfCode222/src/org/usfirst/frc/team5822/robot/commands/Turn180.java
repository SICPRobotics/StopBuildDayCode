package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Turn180 extends CommandGroup {

    public Turn180() 
    {
    	addSequential(new TurnRightFast(180));
    	addSequential(new TurnLeftSlow(180));
    }
}
