package logtracker;
import java.io.*;

public class LogCreation {
	
	public void createLog (String searchinput) {
		
		GetSystemDateTime systemDate = new GetSystemDateTime();
		Object[] logEntryDate = systemDate.outputDate();
		ToFile temp = new ToFile();
		temp.writeToLog(logEntryDate, searchinput, getUDrive());
		
	}
	
	private String getUDrive() {
		
		String[] directory = new File("C://Users").list();
		String udrive= "";
		
		for (String file : directory) {
			if (file.startsWith("u")) {
				udrive = file;
			}
		}
		
		return udrive;
		
	}
	
}
