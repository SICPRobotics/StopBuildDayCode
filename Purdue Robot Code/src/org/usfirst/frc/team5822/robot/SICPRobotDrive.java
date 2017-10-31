package org.usfirst.frc.team5822.robot;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class SICPRobotDrive extends RobotDrive implements MotorSafety
{	
	//written so we can use RobotDrive with VictorSPs when testing with our 2016 robot
	//uses the CANTalons as of 2.10.17
	static CANTalon leftFront, leftRear, rightFront, rightRear; 
	
  public SICPRobotDrive(final int leftMotorChannel, final int rightMotorChannel) 
  {
	  super(new CANTalon (leftMotorChannel), new CANTalon (rightMotorChannel));
	  leftFront = new CANTalon (leftMotorChannel); 
	  rightFront = new CANTalon (rightMotorChannel);
  }

  public SICPRobotDrive(final int frontLeftMotor, final int rearLeftMotor, final int frontRightMotor, final int rearRightMotor) 
  {
      super(new CANTalon (frontLeftMotor), new CANTalon (rearLeftMotor), new CANTalon (frontRightMotor), new CANTalon (rearRightMotor)); 
      leftFront = new CANTalon (frontLeftMotor);
      rightFront = new CANTalon (frontRightMotor);
      leftRear = new CANTalon (rearLeftMotor);
      rightRear = new CANTalon (rearRightMotor);
      setUpMotors(); 
  }
  
  public void setUpMotors()
  {
	  leftFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	  rightFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	  leftRear.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	  rightRear.setFeedbackDevice(FeedbackDevice.QuadEncoder);
  }
  
}