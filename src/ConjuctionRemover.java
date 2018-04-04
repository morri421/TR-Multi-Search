import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConjuctionRemover {

	private ArrayList<String> conjuctionArray = new ArrayList<String>(Arrays.asList("and", "that", "but", "or", "as", "if", 
			"when", "than", "because", "while", "where", "after", "so", "since", "before", "like", "now", "nor", "for",
			"yet", "the", "is"
			));
			
	public String checkList(String textboxPrompt) {
		
		String newTFSPrompt = "";
		ArrayList<String> tempList = new ArrayList<String>();
		//Iterate through both lists to find commonalities and then remove
		List<String> splitList = new ArrayList<String>(Arrays.asList(textboxPrompt.split(" ")));
		for (String x:splitList) {
			if (conjuctionArray.contains(x)) {
				tempList.add(x);
			}
		}
		splitList.removeAll(tempList);
		
		//Adds all remaining values into a string
		for (String z:splitList) {
			newTFSPrompt = newTFSPrompt + z + " ";
		}
		
		return newTFSPrompt;
	}
	
	
}
