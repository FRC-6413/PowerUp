package org.usfirst.frc6413.PowerUp.subsystems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.JoystickHelpers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class BoxIntakeArms extends Subsystem {
	 
	 private final DoubleSolenoid armSolenoid = RobotMap.armSolenoid;
	
	
	protected void initDefaultCommand() {
		
	}
	

	public void retractArms() {
		//Low Gear
		armSolenoid.set(Value.kReverse);
		System.out.println("Retract arms");
	}
	
	public void extendArms() {
		//Low Gear
		armSolenoid.set(Value.kForward);
		System.out.println("Extend arms");
	}
	

}
