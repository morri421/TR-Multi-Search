
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;



public class URLGenerator {
	
	public ArrayList<String> createURLS(String textAreaPrompt, String[] filterAlertString, ArrayList<String> filterStates, String[] queryStrings, ArrayList<String> resources) {
		
		ArrayList<String> newAddresses = new ArrayList<String>();
		
		//URL parts for legibility, it stretches two far across the screen, consider using indentations instead of cutting and pasting url
		String url1 = "http://gsa.cs.thomsonreuters.com/search?site=external-ua-all|internal-ua&access=p&tlen=200&client=";
		String url2 = "&output=xml_no_dtd&proxystylesheet=";
		String url3 = "&filter=0&start=0&num=20&getfields=product-image&q=";
		
		//Removes conjuctions from prompt that can't be searched for in TFS and Q-Logs
		ConjuctionRemover test = new ConjuctionRemover();
		String noconTFS = test.checkList(textAreaPrompt);
		
		//Replaces spaces with special characters for databases
		String newBasePromptHHTC = textAreaPrompt.replace(" ", "+");
		String newBasePromptTFS = noconTFS.replace(" ", "%20");
		
		//Creates HHTC URL as string, compensates for no filters
		if (filterAlertString[0] == "") {
			String newHHTCPrompt = url1 + "default_frontend" + url2 + "default_frontend" + url3 + newBasePromptHHTC + "&partialfields=-csOutputId:ca-fr.-csOutputId:ca-en.-csOutputId:uk-en.-csOutputId:sp-ar";
			newAddresses.add(newHHTCPrompt);
				
		} else {
			String newHHTCPrompt = url1 + "hhtc_cs_us_en" + url2 + "hhtc_cs_us_en" + url3 + newBasePromptHHTC + "&partialfields=("+filterAlertString[0]+")";
			newAddresses.add(newHHTCPrompt);
		}
		
		//Creates TFS URL as string
		StringUtils checkString = new StringUtils();
		if (checkString.isNumeric(textAreaPrompt)) {
			
			String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" + newBasePromptTFS + "&_a=edit&id=" + textAreaPrompt;
			newAddresses.add(newTFSPrompt);

			
		} else {
			
			if (filterStates.contains("FIAS") && textAreaPrompt != "") {
				
				String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" 
				+ "%22Area%20Path%22%3A%22CSTaxSupport" + "\\" + "Fixed Assets%22" + "%20" + newBasePromptTFS + "&_a=search";
				newAddresses.add(newTFSPrompt);
				
			} else if (filterStates.contains("PLAN") && textAreaPrompt != "") {
				
				String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" 
				+ "\"%22Area%20Path%22%3ACSTaxSupport" + "\\" + "Toolbox_PlannerCS" + "\"" + "%20" + newBasePromptTFS + "&_a=search";
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
		//Stores string without conjuctions for Q-Logs
		newAddresses.add(noconTFS);
		return newAddresses;
	}
	
}