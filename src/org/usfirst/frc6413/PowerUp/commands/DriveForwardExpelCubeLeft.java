package org.usfirst.frc6413.PowerUp.commands;

import org.usfirst.frc6413.PowerUp.core.RotationDirection;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardExpelCubeLeft extends CommandGroup {

	public DriveForwardExpelCubeLeft() 
	{
		addSequential(new DriveForwardTimed());
		
		addSequential(new ExpelBoxAutonomous(RotationDirection.Left));
	}
}
