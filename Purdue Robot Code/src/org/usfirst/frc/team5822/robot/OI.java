package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team5822.robot.commands.*;

public class OI 
{

	Joystick joystick = new Joystick(0);
	Joystick xboxCtr = new Joystick(1);
	
	Button j7 = new JoystickButton(joystick, 7);
	Button j8 = new JoystickButton(joystick, 8);
	//9 and 10 don't work on our joystick
	Button j11 = new JoystickButton(joystick, 11);
	Button j12 = new JoystickButton(joystick, 12);

	Button buttonA = new JoystickButton(xboxCtr, 1); 
	Button buttonB = new JoystickButton(xboxCtr, 2);
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonY = new JoystickButton(xboxCtr, 4); 
	Button button5 = new JoystickButton(xboxCtr, 5); 
	Button button6 = new JoystickButton(xboxCtr, 6);
 

	public OI()
	{
		//xbox button functions
		buttonA.whenActive(new Swallow()); 		
		buttonA.whenInactive(new StopIntake());
		
		buttonB.whenActive(new OuttakeSlow());
		buttonB.whenInactive(new StopIntake());
		
		buttonX.whenActive(new OuttakeFast());
		buttonX.whenInactive(new StopIntake());
		
		button5.whenActive(new Shoot(.45)); //during teleop, shooter only gets fuel about halfway up; need to fix this
		button5.whenInactive(new StopShooting());
		
		button6.whenActive(new Climb());
		button6.whenInactive(new StopClimb());
		
		//backup climber on joystick (had trouble with xbox in a match)
		j7.whenActive(new Climb());
		j7.whenInactive(new StopClimb());
		
		j8.whenPressed(new ClearScheduler()); //backup to cancel all commands
		j11.whenPressed(new InvertMotors()); //don't have to turn around to drive forward
		
		j12.whenActive(new Turn180());
		j12.whenPressed(new ChangeIsTurning(true)); //joystick can't control robot while it is turning
		j12.whenInactive(new Set180(false));
		j12.whenReleased(new ChangeIsTurning(false));
		
	}
}
