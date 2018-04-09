package org.usfirst.frc6413.PowerUp.subsystems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.usfirst.frc6413.PowerUp.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeElevator extends Subsystem {

	WPI_TalonSRX elevatorController = RobotMap.IntakeElevatorController;
	private final DoubleSolenoid armSolenoid = RobotMap.armSolenoid;
	//Encoder elevatorEncoder = RobotMap.ElevatorEncoder;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new org.usfirst.frc6413.PowerUp.commands.MoveIntakeElevator());
	}
	
	public void MoveElevator(XboxController controller)
	{		
		double upSpeed = controller.getTriggerAxis(GenericHID.Hand.kRight);
		double downSpeed = controller.getTriggerAxis(GenericHID.Hand.kLeft);
	
		//System.out.println("up speed: " + upSpeed);
		//System.out.println("down speed: " + downSpeed);
		
		if(upSpeed > 0.0) {
			armSolenoid.set(Value.kReverse);
			elevatorController.set(upSpeed);
		}
		else if(downSpeed > 0.0) {
			armSolenoid.set(Value.kReverse);
			elevatorController.set(-downSpeed);
		}
		else {
			elevatorController.set(0.0);
		}				
	}	
}