package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem 
{
	static ADXRS450_Gyro gyro;
	static Encoder leftEncoder; 
	static Encoder rightEncoder; 
//	static AnalogInput ultra; //fill in based on which port it is plugged in
	
	public Sensors()
	{
		if (gyro == null) gyro = new ADXRS450_Gyro();
//		ultra = new AnalogInput(1);
		leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(5);
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(7);
		
		rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k2X);
		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(.0532);
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(7);
	}
	
//	public static double sonarDistance()
//	{
//		double voltage = ultra.getAverageVoltage(); // reads the range on the ultrasonic sensor
//		double sensitivity = 10;
//		double range = voltage * sensitivity * 4.1898; //4.1898 from excel equation
//		System.out.println(range);
//		return range;
//	}
	
	public static void resetEncoders()
	{
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public static double leftEncoderDistance()
	{
		return leftEncoder.getDistance(); 
		
	}
	
	public static double rightEncoderDistance()
	{
		return rightEncoder.getDistance();
	}
	
	public static void resetGyro()
	{
		gyro.reset();
	}
	
	public static double gyroAngle()
	{
		return gyro.getAngle();
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

