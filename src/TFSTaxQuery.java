
public class TFSTaxQuery {
	
	public String[] returnTFSAddition(String[] tfsQueryStates) {
		
		System.out.println(tfsQueryStates[0]);
		System.out.println(tfsQueryStates[1]);
		
		String[] temp;
		temp = new String[2];
		
		if (tfsQueryStates[1].toString() == "FED") {
			
			temp[0] = "%22Area%20Path%22%3ACSTaxSupport" + "\\" + tfsQueryStates[0].toString() + "\\" + "Federal";
		
		} else if (tfsQueryStates[1].toString() == "ORG") {
			
			temp[0] = "%22Area%20Path%22%3ACSTaxSupport" + "\\" + tfsQueryStates[0].toString() + "\\" + "Organizer";
			
		} else if (tfsQueryStates[1].toString() != "ORG" && tfsQueryStates[1].toString() != "FED" && tfsQueryStates[1].toString() != "") {
			
			temp[0] = "%22Area%20Path%22%3ACSTaxSupport" + "\\" + tfsQueryStates[0].toString() + "\\" + "States" + "\\" + tfsQueryStates[1].toString();
		
		} else if (tfsQueryStates[0].toString() != "" && tfsQueryStates[1].toString() == "") {
			
			temp[0] = "%22Area%20Path%22%3ACSTaxSupport" + "\\" + tfsQueryStates[0].toString();
			
		} //put in logic to handle blank fields
		
		//else if (tfsQueryStates[1].toString() != "" && tfsQueryStates[0].toString() == "") {
		
			//temp[0] = "blank";
			
		//}
		//temp[1] = "%22Area%20Path%22%3ACSTaxSupport" + "\\" + "Multi-Entity" + "\\" + tfsQueryStates[2].toString() + "\"";
		return temp;
	}
	
}
