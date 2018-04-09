package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardTimed extends Command {
	public DriveForwardTimed() {
		requires(Robot.driveBase);
		
		
	}
	
	protected void initialize() {
		double timeout = 1.75;		//TWEAK THESE VALUES
		
		setTimeout(timeout);
		
		
		Robot.driveBase.driveForward(-.7);
	}
	
	protected void execute() {
		Robot.driveBase.driveForward(-.7);
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
