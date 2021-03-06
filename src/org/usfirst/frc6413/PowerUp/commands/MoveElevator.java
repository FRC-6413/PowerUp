package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveElevator extends Command {

	public MoveElevator() {
		requires(Robot.boxElevator);
	}
	
	protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.boxElevator.MoveElevator(Robot.oi.armJoystick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.ElevatorController.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
