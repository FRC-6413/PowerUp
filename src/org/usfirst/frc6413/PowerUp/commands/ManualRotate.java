package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.Command;

public class ManualRotate extends Command {
	
	RotationDirection rotationDirection;
	
	public ManualRotate(RotationDirection rotationDirection) {
		requires(Robot.driveBase);
		
		this.rotationDirection = rotationDirection;
	}
	
	protected void initialize() {
		double rotationSpeed = .5;  //TWEAK THESE VALUES
		double timeout = .5;		//TWEAK THESE VALUES
		
		setTimeout(timeout);
		
		// only rotate one side because we'll be up against the wall behind us, it won't rotate too well if we
		// try to backdrive one side.  So just spin the outside side forward
		if(rotationDirection == RotationDirection.Left) {
			Robot.driveBase.rotate(0, rotationSpeed);
		} else if(rotationDirection == RotationDirection.Right) {
			Robot.driveBase.rotate(rotationSpeed, 0);
		}
	}
	
	protected void execute() {
    	
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }
   
    protected void end() {
    	Robot.driveBase.StopAll();
    }

    protected void interrupted() {
    	end();
    }

}
