package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractBoxArms extends Command {
		
		public RetractBoxArms() {
			requires(Robot.boxIntakeArms);
		}
		
		protected void initialize() {
			
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
		  	Robot.boxIntakeArms.retractArms();
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {     	
	        return true;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    	end();
	    }
}
