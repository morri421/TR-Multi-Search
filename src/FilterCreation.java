import java.util.ArrayList;

public class FilterCreation {
	
	public String[] returnFilterURL(ArrayList<String> filterCheckboxes) {
		
		
		String tempFilterStr = "";
		String tempAlertsStr = "";
		String tempTFSURL = "";
		
		//searches checkbox collection for filters and adds it to empty strings, string builder
		if (filterCheckboxes.contains("ACS")) {
			
			tempFilterStr = tempFilterStr + "csOutputId:acs-cs-us-en" + "|";
			tempAlertsStr = "acct_pr/acs/cs_us_en/latest/accounting-cs-workpapers-cs-alerts-and-notices.htm";
			tempTFSURL = "CSAccountingSupport";
					
			
		} if (filterCheckboxes.contains("ACSCA")){
			
			tempFilterStr = tempFilterStr + "csOutputId:acs-client-cs-us-en" + "|";
			tempAlertsStr = "acct_pr/acs/cs_us_en/latest/accounting-cs-workpapers-cs-alerts-and-notices.htm";
			tempTFSURL = "CSAccountingSupport";
			
		} if (filterCheckboxes.contains("PRA")){
			
			tempFilterStr = tempFilterStr + "csOutputId:prac-cs-us-en" + "|";
			tempAlertsStr = "practice/cs_us_en/latest/practice-cs-alerts-and-notices.htm";
			tempTFSURL = "CSPracticeSupport";
		
		} if (filterCheckboxes.contains("WEB")){
			
			tempFilterStr = tempFilterStr + "csOutputId:nc-user-cs-us-en|csOutputId:nf-admin-cs-us-en|csOutputId:ns-user-cs-us-en|csOutputId:wb-cs-us-en" + "|";
			tempAlertsStr = "netfirm/admin_cs_us_en/latest/netfirm-netstaff-web-services-alerts-and-notices.htm";
			tempTFSURL = "CSWeb_DMSSupport";
			
		} if (filterCheckboxes.contains("WORK")){
			
			tempFilterStr = tempFilterStr + "csOutputId:wpcs-cs-us-en" + "|";
			tempAlertsStr = "acct_pr/acs/cs_us_en/latest/accounting-cs-workpapers-cs-alerts-and-notices.htm";
			tempTFSURL = "CSAccountingSupport";
		
		} if (filterCheckboxes.contains("CSA")){
			
			tempFilterStr = tempFilterStr + "csOutputId:csa-cs-us-en" + "|";
			tempAlertsStr = "acct_pr/acs/cs_us_en/latest/accounting-cs-workpapers-cs-alerts-and-notices.htm";
			tempTFSURL = "CSAccountingSupport";
		
		} if (filterCheckboxes.contains("AFLO")){
			
			tempFilterStr = tempFilterStr + "csOutputId:advflw-cs-us-en" + "|";
			tempAlertsStr = "advflow/cs_us_en/latest/advanceflow-alerts-and-notices.htm";
			tempTFSURL = "CSAccountingSupport";
		
		} if (filterCheckboxes.contains("FCAB")){
			
			tempFilterStr = tempFilterStr + "csOutputId:fcs-cs-us-en" + "|";
			tempAlertsStr = "fcs/cs_us_en/latest/filecabinet-cs-alerts-and-notices.htm";
			tempTFSURL = "CSWeb_DMSSupport";
		
		} if (filterCheckboxes.contains("GOFI")){
			
			tempFilterStr = tempFilterStr + "csOutputId:gfr-cs-us-en" + "|";
			tempAlertsStr = "gfr/cs_us_en/latest/gofileroom-alerts-and-notices.htm";
			tempTFSURL = "GoFileRoom";
		
		} if (filterCheckboxes.contains("UT15")){
			
			tempFilterStr = tempFilterStr + "csOutputId:utall15" + "|";
			tempAlertsStr = "ut/2015_cs_us_en/utwapp/latest/ultratax-cs-alerts-and-notices.htm";
			tempTFSURL = "CSTaxSupport";
		
		} if (filterCheckboxes.contains("UT16")){
			
			tempFilterStr = tempFilterStr + "csOutputId:utall16" + "|";
			tempAlertsStr = "ut/2016_cs_us_en/utwapp/latest/ultratax-cs-alerts-and-notices.htm";
			tempTFSURL = "CSTaxSupport";
		
		} if (filterCheckboxes.contains("UT17")){
			
			tempFilterStr = tempFilterStr + "csOutputId:utall17" + "|";
			tempAlertsStr = "ut/2017_cs_us_en/utwapp/latest/ultratax-cs-alerts-and-notices.htm";
			tempTFSURL = "CSTaxSupport";
		
		} if (filterCheckboxes.contains("FIAS")){
			
			tempFilterStr = tempFilterStr + "csOutputId:fixed_assets" + "|";
			tempAlertsStr = "fixa/cs_us_en/latest/fixed-assets-cs-alerts-and-notices.htm";
			tempTFSURL = "CSTaxSupport";
		
		} if (filterCheckboxes.contains("PLAN")){
			
			tempFilterStr = tempFilterStr + "csOutputId:planner" + "|";
			tempAlertsStr = "planner/cs_us_en/latest/planner-cs-alerts-and-notices.htm";
			tempTFSURL = "CSTaxSupport";
		
		} 
		
		//Removing the last character from the string "|"
		if (tempFilterStr != "") {
			tempFilterStr = tempFilterStr.substring(0, tempFilterStr.length()-1);
		}
		//Returns a string with the filters for HHTC and the string with the Alerts and Notices
		String[] hhtcAlertsStrings = {tempFilterStr, tempAlertsStr, tempTFSURL};
		return hhtcAlertsStrings;
	}
}
