package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command {
	PIDController turnController;
	
	static final double kP = 0.03;
    static final double kI = 0.00;
    static final double kD = 0.00;
    static final double kF = 0.00;
	
    static final double kToleranceDegrees = 2.0f;
    
	public Rotate() {
		requires(Robot.driveBase);
		
		turnController = new PIDController(kP, kI, kD, kF, RobotMap.ahrs, new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.driveBase.rotateToDegree(d);
				System.out.println(d);
			}
		});
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);		
	}
	
	protected void initialize() {
		
		// hope this works....
		turnController.reset();
		turnController.enable();
	}
	
	protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return turnController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.StopAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
	

}
