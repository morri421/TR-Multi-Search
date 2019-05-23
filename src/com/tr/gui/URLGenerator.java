package com.tr.gui;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 * Creates url and returns them in a list for easy placement in resource opener
 *
 */
public class URLGenerator {
	
	public ArrayList<String> createURLS(String textAreaPrompt, String[] filterAlertString, ArrayList<String> filterStates, String[] queryStrings, ArrayList<String> resources) {
		
		ArrayList<String> newAddresses = new ArrayList<String>();
		
		//URL parts for legibility, it stretches two far across the screen, consider using indentations instead of cutting and pasting url
		String url1 = "http://cs.thomsonreuters.com/ua/search/cs_us_en/results.htm?q=";
		
		//Adds check to see if there is quotes for TFS and Q-Logs
		Boolean isQuotes = false;
		
		if (textAreaPrompt != "") {
			if (!textAreaPrompt.isEmpty() && textAreaPrompt.charAt(0) == '"' && textAreaPrompt.charAt(textAreaPrompt.length()-1) == '"') {
				isQuotes = true;
			}
		}
		
		//Removes conjuctions from prompt that can't be searched for in TFS and Q-Logs
		//Only works if there are no quotes
		String noconTFS = textAreaPrompt;
		
		
		if (isQuotes == false) {
			ConjuctionRemover test = new ConjuctionRemover();
			noconTFS = test.checkList(textAreaPrompt);
		} 
		
		//Replaces spaces with special characters for databases
		String newBasePromptHHTC = textAreaPrompt.replace(" ", "+");
		newBasePromptHHTC = newBasePromptHHTC.replace("#", "%23");
		String newBasePromptTFS = noconTFS.replace(" ", "%20");
		newBasePromptTFS = newBasePromptTFS.replace("#", "%23");
		//noconTFS = noconTFS.replace(" ", "%20");
		
		if (isQuotes == true) {
			noconTFS = noconTFS.substring(1, noconTFS.length()-1);
			newBasePromptHHTC = newBasePromptHHTC.substring(1, newBasePromptHHTC.length()-1);
			newBasePromptTFS = newBasePromptTFS.substring(1, newBasePromptTFS.length()-1);
			newBasePromptHHTC = "%22" + newBasePromptHHTC + "%22";
			newBasePromptTFS = "%22" + newBasePromptTFS + "%22";
			noconTFS = "%22" + noconTFS + "%22";
		}
		
		
		//Need to fix the unselected filter option
		
		//Creates HHTC URL as string, compensates for no filters
		if (filterAlertString[0].equals("csOutputId")) {
			String newHHTCPrompt = "https://cs.thomsonreuters.com/ua/search/cs_us_en/results.htm?q=" + newBasePromptHHTC;
			newAddresses.add(newHHTCPrompt);
				
		} else {
			String newHHTCPrompt = url1 + newBasePromptHHTC + "&" + filterAlertString[0] + "&index=cssuite-en,cssuite-internal-en";
			newAddresses.add(newHHTCPrompt);
			
		}
		
		//Creates TFS URL as string
		StringUtils checkString = new StringUtils();
		if (checkString.isNumeric(textAreaPrompt)) {
			
			String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" + newBasePromptTFS + "&_a=edit&id=" + textAreaPrompt;
			newAddresses.add(newTFSPrompt);
			
		} else {
			
			if (filterStates.contains("PLAN") && textAreaPrompt != "") {
				
				String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" 
				+ "\"%22Area%20Path%22%3ACSTaxSupport" + "\\" + "Toolbox_PlannerCS" + "\"" + "%20" + newBasePromptTFS + "&_a=search";
				newAddresses.add(newTFSPrompt);
			
			} else if (filterStates.contains("FIAS") && textAreaPrompt != "") {
				
				String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" 
				+ "%22Area%20Path%22%3A%22CSTaxSupport" + "\\" + "Fixed Assets%22" + "%20" + newBasePromptTFS + "&_a=search";
				newAddresses.add(newTFSPrompt);
				
			} else {
				if (resources.contains("TFSQS")) { //&& queryStrings[0] != "blank") {
					String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" + queryStrings[0].toString() + "%20" + newBasePromptTFS + "&_a=search";
					newAddresses.add(newTFSPrompt);
					
				} else { //
					String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" + newBasePromptTFS + "&_a=search";
					newAddresses.add(newTFSPrompt);
					
				}
			}
		
		}
		
		newAddresses.add(noconTFS);
		
		if (resources.contains("CUSE")) {
			
			if (textAreaPrompt != "") {
				
				String newCSPrompt = "http://cs.thomsonreuters.com/ua/search/cs_us_en/results.htm?q=" + newBasePromptHHTC + "&csOutputId=cus-svc&index=cssuite-en,cssuite-internal-en";
				newAddresses.add(newCSPrompt);
				
			} 
		}
		
		
		return newAddresses;
	}
	
}