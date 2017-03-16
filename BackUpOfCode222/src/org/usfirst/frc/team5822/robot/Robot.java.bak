
package org.usfirst.frc.team5822.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team5822.robot.commands.*;
import org.usfirst.frc.team5822.robot.subsystems.Climber;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Intake;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	//public static final Sensors sensors = new Sensors();
	public static final Intake intake = new Intake();
	public static final Climber climber = new Climber();
	public static final Sensors sensors = new Sensors();
	//public static OI oi;
	
//	public static NetworkTable piTable;
	Command autonomousCommand;
	public static VisionPID vision;
	//public static DriveTrain driveTrain = null;
//	ITableListener_WB piListen = new ITableListener_WB();
	UsbCamera cam0; 
	UsbCamera cam1; 
	Mat image;
	Mat image1; 
	CvSink cvSink; 
	CvSource cvSource;
	CvSink cvSink1; 
	CvSource cvSource1;
	
	PWM leds3;
	public static Preferences prefs; 
	
	SendableChooser<Command> chooseAutonomous; 

	@Override
	public void robotInit() 
	{
		chooseAutonomous = new SendableChooser<Command>(); 
		
		vision = new VisionPID();
		oi = new OI();		
		
		chooseAutonomous.addDefault("Cross Baseline Only", new AutoCrossBaseline());
		chooseAutonomous.addObject("Shoot Only", new AutoShoot());
		chooseAutonomous.addObject("Center Gear Only", new AutoCenterGear());

		chooseAutonomous.addObject("Center Gear then Shoot at Blue", new AutoBlueCenterGearShoot());
		chooseAutonomous.addObject("Gear at Blue Boiler", new AutoBlueBoilerGear());
		chooseAutonomous.addObject("Gear then Shoot at Blue Boiler", new AutoBlueBoilerGearShoot());
		//chooseAutonomous.addObject("Shoot then Gear at Blue Boiler", new AutoBlueBoilerShootGear());
		chooseAutonomous.addObject("Gear at Blue Retrieval Zone", new AutoBlueRetrievalZoneGear());
		
		chooseAutonomous.addObject("Center Gear then Shoot at Red", new AutoRedCenterGearShoot());
		chooseAutonomous.addObject("Gear at Red Boiler", new AutoRedBoilerGear());
		chooseAutonomous.addObject("Gear then Shoot at Red Boiler", new AutoRedBoilerGearShoot());
		//chooseAutonomous.addObject("Shoot then Gear at Red Boiler", new AutoRedBoilerShootGear());
		chooseAutonomous.addObject("Gear at Red Retrieval Zone", new AutoRedRetrievalZoneGear());
	 		
		SmartDashboard.putData("Auto mode", chooseAutonomous);
		
		leds3 = new PWM(3); 
		 
		prefs = Preferences.getInstance(); 
		prefs.putInt("Top H Gear", 0);
		prefs.putInt("Top S Gear", 0);
		prefs.putInt("Top V Gear", 0);
		prefs.putInt("Bottom H Gear", 0);
		prefs.putInt("Bottom S Gear", 0);
		prefs.putInt("Bottom V Gear", 0);
		
		prefs.putInt("Top H HG", 0);
		prefs.putInt("Top S HG", 0);
		prefs.putInt("Top V HG", 0);
		prefs.putInt("Bottom H HG", 0);
		prefs.putInt("Bottom S HG", 0);
		prefs.putInt("Bottom V HG", 0);
		
		
		//TODO: Add to this thread all smart dashboard values you would like updated 
		/*Thread updateSmartDashBoard = new Thread(() -> { 
			while(!Thread.interrupted())
			{
				piTable.putBoolean("HGVision Enabled", VisionPID.hGVision); 
				piTable.putBoolean("Gear Vision Enabled", VisionPID.gearVision);
				piTable.putNumber("Top H HG", prefs.getInt("Top H HG", 0)); 
				piTable.putNumber("Top S HG", prefs.getInt("Top S HG", 0));
				piTable.putNumber("Top V HG", prefs.getInt("Top V HG", 0));
				piTable.putNumber("Bottom H HG", prefs.getInt("Bottom H HG", 0)); 
				piTable.putNumber("Bottom S HG", prefs.getInt("Bottom S HG", 0));
				piTable.putNumber("Bottom V HG", prefs.getInt("Bottom V HG", 0));
				
				piTable.putNumber("Top H Gear", prefs.getInt("Top H Gear", 0)); 
				piTable.putNumber("Top S Gear", prefs.getInt("Top S Gear", 0));
				piTable.putNumber("Top V Gear", prefs.getInt("Top V Gear", 0));
				piTable.putNumber("Bottom H Gear", prefs.getInt("Bottom H Gear", 0)); 
				piTable.putNumber("Bottom S Gear", prefs.getInt("Bottom S Gear", 0));
				piTable.putNumber("Bottom V Gear", prefs.getInt("Bottom V Gear", 0));
				System.out.println("Running Prefs Thread");
				System.out.println("H for Gear: " + prefs.getInt("Bottom H Gear", 0));
			}
		});
		updateSmartDashBoard.start();*/
		
		/*Thread t = new Thread(() -> {
			try {
				cam0 = new UsbCamera ("USB Camera 0", 0);
				cam0.setResolution(320,240);
				cam0.setFPS(20);
				
				cam1 = new UsbCamera ("USB Camera 1", 1);
				cam1.setResolution(320,240);
				cam1.setFPS(20);
				
				cvSink = CameraServer.getInstance().getVideo(cam0);
				cvSink.setEnabled(true);
				cvSource = CameraServer.getInstance().putVideo("Current View", 320, 240);
				image = new Mat();	 
				
				cvSink1 = CameraServer.getInstance().getVideo(cam1);
				cvSink1.setEnabled(true);
				cvSource1 = CameraServer.getInstance().putVideo("Current View 1", 320, 240);
				image1 = new Mat();	
			}
			catch (Exception e)
			{
				System.out.println(e); 
			}
			
			while(!Thread.interrupted()) 
			{
				try{
					cvSink.grabFrame(image);
					cvSource.putFrame(image);
				
					cvSink1.grabFrame(image1);
					cvSource1.putFrame(image1);
					
				}
				catch (Exception e){
					System.out.println(e);
				}
				
				
			}
		}
		);
        t.start();*/
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Sensors.resetEncoders();
		
		autonomousCommand = (Command) chooseAutonomous.getSelected();
		
		
		if (autonomousCommand != null)
		{
			System.out.println(autonomousCommand.getName());
			autonomousCommand.start(); 
			
		}
		
//		VisionPID.piTable.putBoolean("HGVision Enabled", VisionPID.hGVision); 
//		VisionPID.piTable.putBoolean("Gear Vision Enabled", VisionPID.gearVision);
//		VisionPID.piTable.putNumber("Top H HG", prefs.getInt("Top H HG", 0)); 
//		VisionPID.piTable.putNumber("Top S HG", prefs.getInt("Top S HG", 0));
//		VisionPID.piTable.putNumber("Top V HG", prefs.getInt("Top V HG", 0));
//		VisionPID.piTable.putNumber("Bottom H HG", prefs.getInt("Bottom H HG", 0)); 
//		VisionPID.piTable.putNumber("Bottom S HG", prefs.getInt("Bottom S HG", 0));
//		VisionPID.piTable.putNumber("Bottom V HG", prefs.getInt("Bottom V HG", 0));
//		
//		VisionPID.piTable.putNumber("Top H Gear", prefs.getInt("Top H Gear", 0)); 
//		VisionPID.piTable.putNumber("Top S Gear", prefs.getInt("Top S Gear", 0));
//		VisionPID.piTable.putNumber("Top V Gear", prefs.getInt("Top V Gear", 0));
//		VisionPID.piTable.putNumber("Bottom H Gear", prefs.getInt("Bottom H Gear", 0)); 
//		VisionPID.piTable.putNumber("Bottom S Gear", prefs.getInt("Bottom S Gear", 0));
//		VisionPID.piTable.putNumber("Bottom V Gear", prefs.getInt("Bottom V Gear", 0));
//		System.out.println("Running Prefs Thread");
//		System.out.println("H for Gear: " + prefs.getInt("Bottom H Gear", 0));

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		Sensors.resetEncoders();
		Robot.driveTrain.changeIsTurning(false);
		Robot.vision.changeGearDone(true);
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
				
		if (!VisionPID.gearVision&&!VisionPID.hGVision&&!DriveTrain.isTurning)
			JoystickFunctions.joystickDrive(DriveTrain.drive);

		//System.out.println("LEFT ENCODER: " + Sensors.leftEncoderDistance());
		System.out.println("RIGHT ENCODER: " + Sensors.rightEncoderDistance());
		
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
		
	}
	
//	public static NetworkTable returnTable()
//	{
//		return piTable; 
//	}
}
