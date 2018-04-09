package org.usfirst.frc6413.PowerUp.subsystems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.JoystickHelpers;

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
		
		double y = JoystickHelpers.deadZoneInput(controller.getY(GenericHID.Hand.kLeft), 0.3)*-1;
		double x = JoystickHelpers.deadZoneInput(controller.getX(GenericHID.Hand.kLeft), 0.3) * intakeRotationMultipler;
		
		intakeDrive.arcadeDrive(y, x);
	}
	
	public void ExpelBox(double speed) {
		// MAY NEED TO MOVE THIS TO USE intakeDrive INSTEAD OF CONTROLLERS DIRECTLY!
		
		// so something like this?
		//intakeDrive.tankDrive(-speed, -speed);
		
		intakeControllerLeft.set(speed);
		intakeControllerRight.set(-speed);		
	}
}
