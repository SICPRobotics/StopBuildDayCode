package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	VictorSP climbMotor; 
	
	public Climber()
	{
		climbMotor = new VictorSP(5);
	}
	
	
	public void climb()
	{
		climbMotor.set(1);
	}

	public void stopClimb()
	{
		climbMotor.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

