import java.util.ArrayList;

//This class adds or removes a checkbox reference from an ArrayList and returns it
public class ModifyCheckbox {
	
	public ArrayList<String>[] returnResource(ArrayList<String> resources, ArrayList<String> filters, int state, String name) {
		
		ArrayList<String> tempResList = resources; //Split into two arraylists and return one array
		ArrayList<String> tempFilList = filters;
		//consider turning into a for-each loop instead of copying all this code
		//Add a customer service filter
		if (name == "Q-Logs" && state == 1) {
			
			tempResList.add("Q-Logs");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Q-Logs" && state == 2){
			
			tempResList.remove("Q-Logs");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "HHTC" && state == 1) {
			
			tempResList.add("HHTC"); 
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "HHTC" && state == 2) {
			
			tempResList.remove("HHTC");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "TFS" && state == 1) {
			
			tempResList.add("TFS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "TFS" && state == 2) {
			
			tempResList.remove("TFS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Alerts and Notices" && state == 1) {
			
			tempResList.add("Alerts");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Alerts and Notices" && state == 2) {
			
			tempResList.remove("Alerts");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Tax TFS Queries" && state == 1) {
			
			tempResList.add("TFSQS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Tax TFS Queries" && state == 2) {
			
			tempResList.remove("TFSQS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Accounting CS" && state == 1) {
			
			tempFilList.add("ACS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Accounting CS" && state == 2) {
			
			tempFilList.remove("ACS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
		
		} else if (name == "Accounting CS Client Access" && state == 1) {
			
			tempFilList.add("ACSCA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Accounting CS Client Access" && state == 2) {
			
			tempFilList.remove("ACSCA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Practice" && state == 1) {
			
			tempFilList.add("PRA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Practice" && state == 2) {
			
			tempFilList.remove("PRA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Web" && state == 1) {
			
			tempFilList.add("WEB");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Web" && state == 2) {
			
			tempFilList.remove("WEB");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Creative Solutions Accounting" && state == 1) {
			
			tempFilList.add("CSA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Creative Solutions Accounting" && state == 2) {
			
			tempFilList.remove("CSA");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Workpapers" && state == 1) {
			
			tempFilList.add("WORK");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Workpapers" && state == 2) {
			
			tempFilList.remove("WORK");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Advance Flow" && state == 1) {
			
			tempFilList.add("AFLO");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Advance Flow" && state == 2) {
			
			tempFilList.remove("AFLO");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "File Cabinet" && state == 1) {
			
			tempFilList.add("FCAB");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "File Cabinet" && state == 2) {
			
			tempFilList.remove("FCAB");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "GoFileRoom" && state == 1) {
			
			tempFilList.add("GOFI");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "GoFileRoom" && state == 2) {
			
			tempFilList.remove("GOFI");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2015 UltraTax" && state == 1) {
			
			tempFilList.add("UT15");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2015 UltraTax" && state == 2) {
			
			tempFilList.remove("UT15");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2016 UltraTax" && state == 1) {
			
			tempFilList.add("UT16");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2016 UltraTax" && state == 2) {
			
			tempFilList.remove("UT16");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2017 UltraTax" && state == 1) {
			
			tempFilList.add("UT17");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "2017 UltraTax" && state == 2) {
			
			tempFilList.remove("UT17");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Fixed Assets" && state == 1) {
			
			tempFilList.add("FIAS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Fixed Assets" && state == 2) {
			
			tempFilList.remove("FIAS");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Planner" && state == 1) {
			
			tempFilList.add("PLAN");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		} else if (name == "Planner" && state == 2) {
			
			tempFilList.remove("PLAN");
			ArrayList[] returnLists = {tempResList, tempFilList};
			return returnLists;
			
		}
		
		ArrayList[] returnLists = {tempResList, tempFilList};
		return returnLists;
	}
}
