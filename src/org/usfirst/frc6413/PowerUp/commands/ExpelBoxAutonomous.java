package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;
import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelBoxAutonomous extends Command {
	
	RotationDirection rotationDirection;
	double timeout = 1.5;
	
	public ExpelBoxAutonomous(RotationDirection direction) {
		requires(Robot.boxIntake);
		
		this.rotationDirection = direction;
	}
	
	protected void initialize() {
		setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    Robot.boxIntake.ExpelBox(1);
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

	@Override
	protected boolean isFinished() {
		if(rotationDirection == RotationDirection.Left && RobotMap.gameData.toLowerCase().charAt(0) == 'r')
    		return true;
    	
    	if(rotationDirection == RotationDirection.Right && RobotMap.gameData.toLowerCase().charAt(0) == 'l')
    		return true;
    	
    	return isTimedOut();
	}

}
