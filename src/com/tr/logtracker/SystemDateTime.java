package com.tr.logtracker;

import java.time.*;

/**
 * Gets System data and time and returns for logging
 *
 */
public class SystemDateTime {

	public Object[] getDateTime() {

		LocalDate inputDate = LocalDate.now();
		LocalTime inputTime = LocalTime.now();
		Object[] datetime = { inputDate, inputTime };
		return datetime;

	}

}
