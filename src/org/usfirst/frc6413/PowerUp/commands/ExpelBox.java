package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelBox extends Command {

	public ExpelBox() {
		requires(Robot.boxIntake);
	}
	
	protected void initialize() {
		setTimeout(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveBase.arcadeDriveMethod(Robot.oi.driveJoystick);
    	Robot.boxIntake.ExpelBox(0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boxIntake.ExpelBox(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
