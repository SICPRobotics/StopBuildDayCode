package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import org.usfirst.frc.team5822.robot.subsystems.*;
import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public static Preferences prefs; 
	SendableChooser<Command> chooseAutonomous; 
	Command autonomousCommand;
	
	//subsystems
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Sensors sensors;
	public static Climber climber;
	public static GearIntake gearIntake;
	
	//cameras
	UsbCamera cam0; 
	UsbCamera cam1; 

	@Override
	public void robotInit() 
	{
		chooseAutonomous = new SendableChooser(); 
		driveTrain = new DriveTrain();
		climber = new Climber();
		sensors = new Sensors();
		oi = new OI();		
		
		//adds all auto options to the sendable chooser
		chooseAutonomous.addDefault("Cross Baseline Only", new AutoCrossBaseline());
		
		chooseAutonomous.addObject("Center Gear Only", new AutoCenterGear());

		chooseAutonomous.addObject("Gear at Blue Boiler", new AutoBlueBoilerGear());
		chooseAutonomous.addObject("Gear at Blue Retrieval Zone", new AutoBlueRetrievalZoneGear());
		
		chooseAutonomous.addObject("Gear at Red Boiler", new AutoRedBoilerGear());
		chooseAutonomous.addObject("Gear at Red Retrieval Zone", new AutoRedRetrievalZoneGear());
	
		SmartDashboard.putData("Auto Mode", chooseAutonomous);
	 
		//starts cameras
		Thread t = new Thread(() -> 
		{
					/*	try {
							cam0 = new UsbCamera ("cam2", 1);
							cam0.setResolution(320,240);
							cam0.setFPS(20);
							
							cvSink = CameraServer.getInstance().getVideo(cam0);
							cvSink.setEnabled(true);
							cvSource = CameraServer.getInstance().putVideo("Current View", 320, 240);
							image = new Mat();	 
							
							
						}
						
						catch (Exception e)
						{
							System.out.println(e); 
						}*/
	
			try
			{
				
				cam1 = CameraServer.getInstance().startAutomaticCapture(0);
				cam1.setResolution(320, 240);
				
						/*	HttpCamera camIP = new HttpCamera("ip cam", "10.58.22.11"); 
							cvSink1 = CameraServer.getInstance().getVideo(camIP);
							cvSink1.setEnabled(true);
							cvSource1 = CameraServer.getInstance().putVideo("Current View 1", 320, 240);
							image1 = new Mat();*/
							
							/*cam0 = CameraServer.getInstance().startAutomaticCapture(1);
							cam0.setResolution(320, 240);
							*/
							
							/*cam1 = new UsbCamera ("cam5", 1);
							//cam1 = new UsbCamera ("USB Camera 5", 1);
							cam1.setResolution(320,240);
							cam1.setFPS(10);
							 
							cvSink1 = CameraServer.getInstance().getVideo(cam1);
							cvSink1.setEnabled(true);
							cvSource1 = CameraServer.getInstance().putVideo("Current View 1", 320, 240);
							image1 = new Mat();*/	
			}
			catch (Exception e)
			{
				System.out.println(e); 
			}
						
						/*while(!Thread.interrupted()) 
						{
							try{
								//cvSink.grabFrame(image);
								//cvSource.putFrame(image);
							
								cvSink1.grabFrame(image1);
								cvSource1.putFrame(image1);
								
							}
							catch (Exception e){
								System.out.println(e);
							}
							
							
						}*/
		}
		);
        t.start();
		
		SmartDashboard.putNumber("Encoder Value", Sensors.rightEncoderDistance()); 
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void autonomousInit() 
	{
		Sensors.resetEncoders();
		
		autonomousCommand = (Command) chooseAutonomous.getSelected();  //sets auto command to the command that was selected
		
		if (autonomousCommand != null)
		{
			autonomousCommand.start(); 
		}

	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run(); //runs selected autonomous command group
	}

	@Override
	public void teleopInit() 
	{
		if (autonomousCommand != null)
			autonomousCommand.cancel(); //cancels whatever command group was running
		 
		Robot.driveTrain.disable(); //disable any PIDs that were running
		Sensors.resetEncoders();
		Robot.driveTrain.changeIsTurning(false);

		Scheduler.getInstance().removeAll(); //removes scheduled commands
	}

	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run(); //runs all button functions from the OI
		
		if (!DriveTrain.isTurning) //if no vision is running, the joystick controls the robot
			JoystickFunctions.joystickDrive(DriveTrain.drive);
	}

	@Override
	public void testPeriodic() 
	{
		LiveWindow.run();
	}

}
