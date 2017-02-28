package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCG extends CommandGroup {

    public GearCG() {
    	addSequential(new ToggleGear()); 
    	addSequential(new GearVision()); 
    }
}
