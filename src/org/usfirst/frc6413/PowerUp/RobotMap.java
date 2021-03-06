// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6413.PowerUp;

import edu.wpi.cscore.UsbCamera;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import java.util.Date;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.kauailabs.navx.frc.AHRS;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveBaseLFM;
    public static WPI_TalonSRX driveBaseLRM;
    public static WPI_TalonSRX driveBaseLMM;
    public static WPI_TalonSRX driveBaseRFM;
    public static WPI_TalonSRX driveBaseRRM;
    public static WPI_TalonSRX driveBaseRMM;
    public static DifferentialDrive driveBaseRobotDrive41;
    //public static AnalogInput driveBaseRearUltrasonic;
    public static AnalogInput driveBaseFrontUltrasonic;
    public static Compressor compressor;
    public static DoubleSolenoid shifterSolenoid;
    public static DoubleSolenoid armSolenoid;
    //
    public static SpeedController winchSpeedController1;
    
    public static boolean ArmIsUp = true;
    public static boolean JawsClosed = true;
    public static boolean ArmDownDebounce = false;
    public static boolean LeftSideStart = false;
    public static Date ArmDownTime = new Date();
    
    public static Alliance alliance;
    public static String gameData;
    
    public static WPI_TalonSRX ElevatorController;
    public static WPI_TalonSRX IntakeElevatorController;
    
    public static Spark IntakeControllerLeft;
    public static Spark IntakeControllerRight;
    
    public static VictorSP leftIntakeArm;
    public static VictorSP rightIntakeArm;
    
    public static DifferentialDrive intakeDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static AHRS ahrs;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        	
        //driveBaseRMM = new WPI_TalonSRX(3);
        driveBaseRFM = new WPI_TalonSRX(4);
        driveBaseRRM = new WPI_TalonSRX(5);
        
        
        driveBaseLFM = new WPI_TalonSRX(3);
        driveBaseLMM = new WPI_TalonSRX(0);
        //driveBaseLRM = new WPI_TalonSRX(2);
        
        
        SpeedControllerGroup left = new SpeedControllerGroup(driveBaseLFM,  driveBaseLMM);
        SpeedControllerGroup right = new SpeedControllerGroup(driveBaseRFM, driveBaseRRM);
                
        driveBaseRobotDrive41 = new DifferentialDrive(left, right);
        
        compressor = new Compressor(0);
        
        
        shifterSolenoid = new DoubleSolenoid(0, 0, 1);
        armSolenoid = new DoubleSolenoid(0, 2, 3);
        
        //elevator stuff
        ElevatorController = new WPI_TalonSRX(6);
        IntakeElevatorController = new WPI_TalonSRX(7); 
        
        // not sure if this line is needed?  may be for just testing stuff, try without this line first
        //ElevatorController.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 10, 10);
        // needed for quad encoder
        //ElevatorController.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
                
        IntakeControllerLeft = new Spark(0);
        IntakeControllerRight = new Spark(1);
        
        leftIntakeArm = new VictorSP(2);
        rightIntakeArm = new VictorSP(3);
        
        rightIntakeArm.setInverted(true);
        
        SpeedControllerGroup leftIntake = new SpeedControllerGroup(IntakeControllerLeft, leftIntakeArm);
        SpeedControllerGroup rightIntake = new SpeedControllerGroup(IntakeControllerRight, rightIntakeArm);
        
        //intakeDrive = new DifferentialDrive(IntakeControllerLeft, IntakeControllerRight);
        intakeDrive = new DifferentialDrive(leftIntake, rightIntake);
        
        new Thread(() -> {
        	CameraServer cs = CameraServer.getInstance();
        	
        	// Uncomment for each camera... we'll most likely use 2, but uncomment as needed
        	
       		UsbCamera usb1 = cs.startAutomaticCapture(0);
       		usb1.setResolution(320, 240);
       		usb1.setFPS(10);
       		
       		//UsbCamera usb2 = cs.startAutomaticCapture(1);
       		//usb2.setResolution(160, 120);
       		//usb2.setFPS(10);
        }).start();
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        ahrs = new AHRS(SPI.Port.kMXP);
        //LiveWindow.addSensor("DriveBase", "Navx", ahrs);
    }
    
}