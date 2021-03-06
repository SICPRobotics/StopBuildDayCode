package org.usfirst.frc.team5822.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

	static CANTalon shootMotor;
	static Timer tele;
	static boolean flag;
	static VictorSP indexer;
	
    public Shooter()
    {
		shootMotor = new CANTalon(4); 
		shootMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
		shootMotor.setPID(0, 0, 0, 0.0249755, 0, 0, 0);
	    //shootMotor.setF(0.04282);
        //shootMotor.setP(0.4872);
        //.06097
        //_talon.setI(.06097); 
		shootMotor.reverseSensor(true); 
		tele = new Timer();
		indexer = new VictorSP(7);
    }
    
    public static void init()
    {
    	shootMotor.changeControlMode(TalonControlMode.PercentVbus);
		tele.start(); //timer to know when to start indexer
    }
    
    //starts indexer to feed balls into shooter 
    public static void index()
    {
    	indexer.set(-.25);
    }
    
    public static void shoot(double speed)
	{
		/*attempted using a PID to control shooter motor, but had trouble stopping it
    	found setting a consistent speed worked well enough, didn't have trouble with motor slowing down like we thought*/
		    	
    			/*if (tele.get()<2)
					shootMotor.set(.5);
				else 
					flag = true; 
				
				if (flag)
				{
					shootMotor.changeControlMode(TalonControlMode.Speed);
					shootMotor.set(6000); 
					shootMotor.enableControl(); //Enable PID control on the talon
					flag = false;
					//shootMotor.set(.7);
					SmartDashboard.putNumber("Speed", shootMotor.getSpeed());
				}*/
    	
    	shootMotor.set(speed);
    	
    	SmartDashboard.putNumber("VBus" , shootMotor.getOutputVoltage()); 
		if(tele.get()>1.5) //gives shooter time to get up to speed
		{
			index();
		}

	}
    
    public static void stopShooting()
    {
    	//TODO: Having trouble getting shooter to actually stop
    		//shootMotor.disable();
    	shootMotor.set(0);
    	indexer.set(0);
    }
	
    public void initDefaultCommand() {}
}

