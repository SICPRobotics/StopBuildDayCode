package org.usfirst.frc.team5822.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterGear extends CommandGroup {

    public AutoCenterGear() 
    {
       /*tried using vision processing, but dead reckoning was accurate enough, 
       and we didn't have time to fix a few errors that came up with vision*/
       addSequential(new DriveForward(64)); 
       addSequential(new WaitForPilot());
       addSequential(new DriveSlow(6));
    }
}
