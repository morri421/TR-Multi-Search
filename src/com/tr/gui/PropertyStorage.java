package com.tr.gui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * A class that stores properties so opening and closing 
 *
 */
public class PropertyStorage {
	
	//looks for properties xml
	public void checkforDirectory() {
		File dir = new File("TRMS");
		if (!dir.exists()) { //if it doesn't exist, create and set them as empty
			dir.mkdir();
			setInitialProperty();
		}
	}
	
	//Sets initial properties for a new user
	public void setInitialProperty() {
		
		Properties defaultProperties=new Properties();
		
		defaultProperties.setProperty("H&HTC","0");
		defaultProperties.setProperty("TFS","0");
		defaultProperties.setProperty("Q-Logs","0");
		defaultProperties.setProperty("Alerts and Notices","0");
		defaultProperties.setProperty("Customer Service","0");
		defaultProperties.setProperty("Accounting CS","0");
		defaultProperties.setProperty("Accounting CS Client Access","0");
		defaultProperties.setProperty("Practice CS","0");
		defaultProperties.setProperty("Web Services","0");
		defaultProperties.setProperty("Creative Solutions Accounting","0");
		defaultProperties.setProperty("Workpapers","0");
		defaultProperties.setProperty("AdvanceFlow","0");
		defaultProperties.setProperty("FileCabinet","0");
		defaultProperties.setProperty("GoFileRoom","0");
		defaultProperties.setProperty("2018 UltraTax","0");
		defaultProperties.setProperty("2017 UltraTax","0");
		defaultProperties.setProperty("2016 UltraTax","0");
		defaultProperties.setProperty("2015 UltraTax","0");
		defaultProperties.setProperty("Fixed Assets","0");
		defaultProperties.setProperty("Planner","0");
		
		try(OutputStream out = Files.newOutputStream(Paths.get("TRMS\\test.xml"))) { //creates the xml
			defaultProperties.storeToXML(out, "Checkbox States");
		
		} catch (IOException e) {
			System.out.println(e);
		}
	
	}
	
	//Method takes a clicked checkbox value and sends property to log 
	public void setNewProperty(String checkboxname, int checkboxnumber) { 
		
		Properties loadedProperties=new Properties();
		
		try(InputStream in = Files.newInputStream(Paths.get("TRMS\\test.xml"))) {
			loadedProperties.loadFromXML(in);
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		if (checkboxnumber == 1) {
			loadedProperties.setProperty(checkboxname, "1");
		} else {
			loadedProperties.setProperty(checkboxname, "0");
		}
		
		try(OutputStream out = Files.newOutputStream(Paths.get("TRMS\\test.xml"))) {
			
			loadedProperties.storeToXML(out, "Checkbox States");
		
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//Method gets the property and will apply it to checkbox in GUI
	public String getProperty(String property) { 
		
		Properties loadedBoxProperties=new Properties();
		
		try(InputStream in = Files.newInputStream(Paths.get("TRMS\\test.xml"))) {
			loadedBoxProperties.loadFromXML(in);
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return loadedBoxProperties.getProperty(property);
	}

}
