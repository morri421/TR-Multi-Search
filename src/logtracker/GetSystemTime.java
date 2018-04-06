package logtracker;
import java.time.*;


public class GetSystemTime {
	
	public Object[] outputDate() {
	
		LocalDate inputDate = LocalDate.now();
		LocalTime inputTime = LocalTime.now();
		System.out.println(inputDate);
		System.out.println(inputTime);
		Object [] datetime = {inputDate, inputTime};
		return datetime;
		
	}
	
}
