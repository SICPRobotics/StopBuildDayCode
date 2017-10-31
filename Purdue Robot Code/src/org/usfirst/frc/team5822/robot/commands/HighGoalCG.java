package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HighGoalCG extends CommandGroup {

    public HighGoalCG() {
    	addSequential(new ToggleHG()); 
    	addSequential(new HGVision()); 
    }
}
