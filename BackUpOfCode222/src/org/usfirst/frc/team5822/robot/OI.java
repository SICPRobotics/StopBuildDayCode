package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5822.robot.commands.Climb;
import org.usfirst.frc.team5822.robot.commands.GearCG;
import org.usfirst.frc.team5822.robot.commands.GearVision;
import org.usfirst.frc.team5822.robot.commands.HGVision;
import org.usfirst.frc.team5822.robot.commands.HighGoalCG;
import org.usfirst.frc.team5822.robot.commands.InvertMotors;
import org.usfirst.frc.team5822.robot.commands.OuttakeFast;
import org.usfirst.frc.team5822.robot.commands.OuttakeSlow;
import org.usfirst.frc.team5822.robot.commands.Shoot;
import org.usfirst.frc.team5822.robot.commands.StopClimb;
import org.usfirst.frc.team5822.robot.commands.StopIntake;
import org.usfirst.frc.team5822.robot.commands.StopShooting;
import org.usfirst.frc.team5822.robot.commands.Swallow;
import org.usfirst.frc.team5822.robot.commands.ToggleGear;
import org.usfirst.frc.team5822.robot.commands.ToggleHG;
import org.usfirst.frc.team5822.robot.commands.ChangeIsTurning;
import org.usfirst.frc.team5822.robot.commands.Turn180;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick joystick = new Joystick(0);
	Joystick xboxCtr = new Joystick(1);
	
	Button j11 = new JoystickButton(joystick, 11);
	Button j12 = new JoystickButton(joystick, 12);
	Button j7 = new JoystickButton(joystick, 7);
	Button j8 = new JoystickButton(joystick, 8);
	
	
	Button buttonA = new JoystickButton(xboxCtr, 1); 
	Button buttonB = new JoystickButton(xboxCtr, 2);
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonY = new JoystickButton(xboxCtr, 4); 
	
	Button button5 = new JoystickButton(xboxCtr, 5); 
	Button button6 = new JoystickButton(xboxCtr, 6);
 

	public OI()
	{
		buttonA.whenActive(new Swallow()); 		
		buttonA.whenInactive(new StopIntake());
		
		buttonB.whenActive(new OuttakeSlow());
		buttonB.whenInactive(new StopIntake());
		
		buttonX.whenActive(new OuttakeFast());
		buttonX.whenInactive(new StopIntake());
		
		button5.whenActive(new Shoot());
		button5.whenInactive(new StopShooting());
		
		button6.whenActive(new Climb());
		button6.whenInactive(new StopClimb());
		
		j7.whenActive(new GearCG());
		j7.whenInactive(new GearCG());
		
		j8.whenActive(new HighGoalCG());
		j8.whenInactive(new HighGoalCG());		
		
		j11.whenPressed(new InvertMotors());
		j12.whenActive(new Turn180());
		j12.whenPressed(new ChangeIsTurning(true)); 
		j12.whenReleased(new ChangeIsTurning(false));
		
	}
}
