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
		shootMotor.setPID(1.3, .001, 35, 0.001, 0, 0, 0);
		shootMotor.reverseSensor(true); 
		tele = new Timer();
		indexer = new VictorSP(7);
		//shootMotor = new VictorSP(5);
    }

    public static void init()
    {
    	shootMotor.changeControlMode(TalonControlMode.PercentVbus);
		tele.start();
    }
    
    public static void index()
    {
    	indexer.set(-.3);
    }
    
    public static void shoot()
	{
		if (tele.get()<2)
			shootMotor.set(.5);
		else 
			flag = true; 
		
		if (flag)
		{
			shootMotor.changeControlMode(TalonControlMode.Speed);
			shootMotor.set(8850); 
			shootMotor.enableControl(); //Enable PID control on the talon
			flag = false;
			//shootMotor.set(.7);
			SmartDashboard.putNumber("Speed", shootMotor.getSpeed());
		}
		if(tele.get()>3)
		{
			index();
		}
			
		//write the code to run the shooter here
	}
    
    public void stopShooting()
    {
    	//TODO: Having trouble getting shooter to actually stop
    	//shootMotor.disable();
    	shootMotor.set(0);
    	indexer.set(0);
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

