package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.RobotMap;
import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSide extends CommandGroup {
	
	public LeftSide() {
		/*String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        
    	System.out.println("FMS: " + gameData);*/
		//addSequential(new DriveToSwitch());
		
		// turn if needed		
		// manual rotate
		addSequential(new ManualRotate(RotationDirection.Left));
		// navx rotate
		//addSequential(new Rotate(RotationDirection.Left));	// this still needs work....
		
		// move forward
		addSequential(new DriveToSwitch());
		
		// if we end up with the box in our grabber, expel it.  
		//addSequential(new ExpelBoxAutonomous());
		//RobotMap.LeftSideStart = true;		
	}

}
