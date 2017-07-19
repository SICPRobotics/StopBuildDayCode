package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.SICPRobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem 
{
	public static SICPRobotDrive drive;
	static double setpoint; 
	public static boolean isTurning; 
	static boolean isBackwards; 
	
	public DriveTrain()
	{
		super("DriveTrain", .02, 0.00,0);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false);
		drive = new SICPRobotDrive(0,1,2,3);
		setpoint = 0; 
		isTurning = false; 
		isBackwards = false; 
	}
	
	public static void setOuts(double left, double right)
	{
		drive.setLeftRightMotorOutputs(left, right); 
	}
		
	public static double pidAt(double set)
	{
		setpoint = set;  
		return setpoint; 
	}
	
	// returns the sensor value that is providing the feedback for the system
	protected double returnPIDInput() 
	{    	
		return Sensors.gyroAngle() - setpoint; 
    }

	public static void pidBackwards(boolean backwards)
	{
		isBackwards = backwards; 
	}
	
    protected void usePIDOutput(double output) 
    {
    	if(isBackwards)
    		drive.setLeftRightMotorOutputs(-.4 + output, -.4 - output); // this is where the computed output value fromthe PIDController is applied to the motor
    	else 
    		drive.setLeftRightMotorOutputs(.4 - output, .4 + output); //TODO: does this work? 
    }
	
    //basic driving methods for auto commands
			public static void driveForward()
			{
				drive.drive(0.15 , 0.0);
			}
			
			public static void driveBackward()
			{
				drive.drive(0.15, 0.0);
			}
			
			public static void turnLeftSlow()
			{
				drive.setLeftRightMotorOutputs(-.22, .22);
			}
			
			public static void turnLeftFast()
			{
				drive.drive(0.3, -1);
			}
			
			public static void turnRightSlow()
			{
				drive.setLeftRightMotorOutputs(0.22, -.22);
			}
			
			public static void turnRightFast()
			{
				drive.drive(0.3, 1);
			}
			
	public void changeIsTurning(boolean val)
	{
		isTurning = val; 
	}

	public void initDefaultCommand() {}

}
