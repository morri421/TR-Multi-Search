package logtracker;

public class LogCreation {
	
	public void createLog (String searchinput) {
		
		GetSystemTime systemDate = new GetSystemTime();
		Object[] logEntryDate = systemDate.outputDate();
		System.out.println(logEntryDate);
		ToFile temp = new ToFile();
		temp.writeToLog(logEntryDate, searchinput);
		
	}
	
}
