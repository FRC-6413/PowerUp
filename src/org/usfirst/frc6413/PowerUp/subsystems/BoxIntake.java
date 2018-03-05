package org.usfirst.frc6413.PowerUp.subsystems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.usfirst.frc6413.PowerUp.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class BoxIntake extends Subsystem {

	Spark intakeControllerLeft = RobotMap.IntakeControllerLeft;
	Spark intakeControllerRight = RobotMap.IntakeControllerRight;
	
	DifferentialDrive intakeDrive = RobotMap.intakeDrive;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new org.usfirst.frc6413.PowerUp.commands.IntakeBox());
	}
	
	public void IntakeBox(XboxController controller)
	{
		double intakeRotationMultipler = .75;
		
		double y = deadZoneInput(controller.getY(GenericHID.Hand.kLeft), 0.3)*-1;
		double x = deadZoneInput(controller.getX(GenericHID.Hand.kLeft), 0.3) * intakeRotationMultipler;
		
		intakeDrive.arcadeDrive(y, x);
	}
	
	
	private double deadZoneInput(double input, double deadZone) {
		if (input <= deadZone && input >= -deadZone)
			return 0;
		else if (input >= deadZone)
			input = ((input - deadZone) / (1 - deadZone));
		else if (input <= deadZone)
			input = ((-input - deadZone) / (deadZone - 1));

		return round(input, 2);
	}
	
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public void ExpelBox(double speed) {
		// MAY NEED TO MOVE THIS TO USE intakeDrive INSTEAD OF CONTROLLERS DIRECTLY!
		intakeControllerLeft.set(-speed);
		intakeControllerRight.set(-speed);		
	}
}
