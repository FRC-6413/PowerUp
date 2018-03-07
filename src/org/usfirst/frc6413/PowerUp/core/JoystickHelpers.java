package org.usfirst.frc6413.PowerUp.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JoystickHelpers {
	public static double deadZoneInput(double input, double deadZone) {
		if (input <= deadZone && input >= -deadZone)
			return 0;
		else if (input >= deadZone)
			input = ((input - deadZone) / (1 - deadZone));
		else if (input <= deadZone)
			input = ((-input - deadZone) / (deadZone - 1));

		return round(input, 2);
	}
	
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
