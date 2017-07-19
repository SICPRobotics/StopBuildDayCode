package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem 
{

	VictorSP cacaw;
	
	public Intake()
	{
		cacaw = new VictorSP(4);
	}
	
	//different intake speeds and directions
		public void takeIn()
		{
			cacaw.set(-.85);
		}
		
		public void keepOutSlow()
		{
			cacaw.set(.4);
		}
		
		public void keepOutFast()
		{
			cacaw.set(.85);
		}
		
		public void doNothing()
		{
			cacaw.set(0);
		}

    public void initDefaultCommand() {}
}

