package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueCenterGearShoot extends CommandGroup {

    public AutoBlueCenterGearShoot() 
    {
    	addSequential(new AutoCenterGear());
    	addSequential(new DriveBackward(-40.07));
    	addSequential(new TurnLeftFast(-46.57));                      
    	addSequential(new TurnRightSlow(-46.57));
    	addSequential(new DriveForward(142.25));
    	addSequential(new Shoot());
    }
}
