package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.Command;

public class ManualRotate extends Command {
	
	RotationDirection rotationDirection;
	
	double rotationSpeed = .5;  //TWEAK THESE VALUES
	double timeout = 1.5;		//TWEAK THESE VALUES
	
	public ManualRotate(RotationDirection rotationDirection) {
		requires(Robot.driveBase);
		
		this.rotationDirection = rotationDirection;
	}
	
	protected void initialize() {
		
		
		setTimeout(timeout);
		
		// only rotate one side because we'll be up against the wall behind us, it won't rotate too well if we
		// try to backdrive one side.  So just spin the outside side forward
		/*if(rotationDirection == RotationDirection.Left) {
			Robot.driveBase.rotate(0, rotationSpeed);
		} else if(rotationDirection == RotationDirection.Right) {
			Robot.driveBase.rotate(-rotationSpeed, 0);
		}*/
	}
	
	protected void execute() {
		if(rotationDirection == RotationDirection.Left) {
			Robot.driveBase.rotate(0, rotationSpeed);
		} else if(rotationDirection == RotationDirection.Right) {
			Robot.driveBase.rotate(rotationSpeed, 0);
		}
    }

    protected boolean isFinished() {
    	// if we're lined up in front of our color, don't rotate... these should prevent us from rotating.  I hope...
    	if(rotationDirection == RotationDirection.Left && RobotMap.gameData.toLowerCase().charAt(0) == 'l')
    		return true;
    	
    	if(rotationDirection == RotationDirection.Right && RobotMap.gameData.toLowerCase().charAt(0) == 'r')
    		return true;
    	
    	return isTimedOut();
    }
   
    protected void end() {
    	Robot.driveBase.StopAll();
    }

    protected void interrupted() {
    	end();
    }

}
