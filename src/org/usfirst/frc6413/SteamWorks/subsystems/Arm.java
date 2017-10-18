// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6413.SteamWorks.subsystems;

import org.usfirst.frc6413.SteamWorks.Robot;
import org.usfirst.frc6413.SteamWorks.RobotMap;
import org.usfirst.frc6413.SteamWorks.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Arm extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Compressor compressor = RobotMap.armCompressor;
    private final DoubleSolenoid upDown = RobotMap.armUpDown;
    private final DoubleSolenoid openClose = RobotMap.armOpenClose;
    private final DigitalInput gearTrigger = RobotMap.armGearTrigger;
    //private final XboxController driveController = Robot.oi.driveJoystick;
    //private final XboxController armController = Robot.oi.armJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeArm() {
    	openClose.set(Value.kForward);
    	
    	//armController.setRumble(RumbleType.kLeftRumble, 1);
    }
    
    public void openArm() {
    	openClose.set(Value.kReverse);
    }
    
    public void lowerArm() {
    	upDown.set(Value.kReverse);
    }
    
    public void raiseArm() {
    	upDown.set(Value.kForward);
    }
}

