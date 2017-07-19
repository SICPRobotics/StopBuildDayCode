package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueShoot extends CommandGroup {

    public AutoBlueShoot() 
    {
    	addSequential(new ShootForTime(.45)); 
    	addSequential(new DriveForward(100)); //need to fix this code, only in here for the SC
    }
}
