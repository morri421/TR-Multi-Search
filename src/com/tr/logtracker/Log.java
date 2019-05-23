package com.tr.logtracker;

import java.io.*;

/**
 * Generates log file of what searches were done and when for analystics.
 * Deprecated.
 *
 */
public class Log {

	public void createLog(String searchinput) {

		SystemDateTime systemDate = new SystemDateTime(); // gets local system data/time
		Object[] logEntryDate = systemDate.getDateTime();
		FileLogger temp = new FileLogger();
		temp.writeToLog(logEntryDate, searchinput, getUDrive());

	}

	// Gets local path to user profile starting with u
	private String getUDrive() {

		String[] directory = new File("C://Users").list();
		String udrive = "";

		for (String file : directory) {
			if (file.startsWith("u")) {
				udrive = file;
			}
		}

		return udrive;

	}

}
