
import java.util.ArrayList;

public class URLGenerator {
	
	public ArrayList<String> createURLS(String textAreaPrompt, String[] filterAlertString) {
		
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
		String newTFSPrompt = "http://tfstta.int.thomson.com:8080/tfs/DefaultCollection/" + filterAlertString[2] + "/_workItems?path=Search%20results&searchText=" + newBasePromptTFS + "&_a=search";
		newAddresses.add(newTFSPrompt);
		
		//Stores string without conjuctions for Q-Logs
		newAddresses.add(noconTFS);
		
		return newAddresses;
	}
	
}