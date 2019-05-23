package com.tr.gui;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class opens the urls generated using Google Chrome
 *
 */
public class OpenResource {
	//Takes new URLs and list of resources selected
	public void createProcess(ArrayList<String> newURLS, ArrayList<String> resourceState, String[] FilterAlertString, ArrayList<String> filterStates) {
		
		String chromeProcess= "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		
		if (resourceState.contains("Q-Logs")) {
			
				try {
					
					ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Q-Logs\\Q-Logs.exe", "qlogs://search=" + newURLS.get(2));
					pb.start();
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		} if (resourceState.contains("HHTC")) {
			
				try {
					ProcessBuilder pb = new ProcessBuilder(chromeProcess, ""+newURLS.get(0)+"");
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
				
		} if (resourceState.contains("TFS")  && !filterStates.isEmpty()) {
			
				try {
					ProcessBuilder pb = new ProcessBuilder(chromeProcess, newURLS.get(1));
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		} else if (resourceState.contains("TFS") && filterStates.isEmpty()) {
			
			try {
				ProcessBuilder pb = new ProcessBuilder(chromeProcess, "http://cs.thomsonreuters.com/ua/kb_gui/inttools.htm?mybanner=1#tfs_pop");
				pb.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} if (resourceState.contains("Alerts") && !filterStates.isEmpty()) { 
			
				try {
					ProcessBuilder pb = new ProcessBuilder(chromeProcess, "http://cs.thomsonreuters.com/ua/" + FilterAlertString[1]);
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		} else if (resourceState.contains("Alerts") && filterStates.isEmpty()) {
			
			try {
				ProcessBuilder pb = new ProcessBuilder(chromeProcess, "http://cs.thomsonreuters.com/ua/kb_gui/inttools.htm?mybanner=1#alerts_and_notices");
				pb.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} if (resourceState.contains("CUSE")) { 
			
			try {
				ProcessBuilder pb = new ProcessBuilder(chromeProcess, ""+newURLS.get(3)+"");
				pb.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		
	}
}

