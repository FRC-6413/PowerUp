package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSide extends CommandGroup {
	
	public RightSide() {
		// manual rotate
		addSequential(new ManualRotate(RotationDirection.Right));
		// navx rotate
		//addSequential(new Rotate(RotationDirection.Right));	// this still needs work....
		
		// move forward
		addSequential(new DriveToSwitch());
		
		// if we end up with the box in our grabber, expel it.  
		//addSequential(new ExpelBoxAutonomous());
	}

}
