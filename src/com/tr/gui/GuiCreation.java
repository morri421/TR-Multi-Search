package com.tr.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import com.tr.logtracker.Log;

/**
 * @author u6064842
 *
 */
public class GuiCreation implements ActionListener, ItemListener {

	JFrame frame;
	JTextArea textArea;
	JButton btnEnter; // Add a select all button

	public void init() {

		PropertyStorage setDefaults = new PropertyStorage();

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout("gapx 10"));
		frame.setTitle("Thomson Reuters Multi-Search");
		frame.setSize(395, 540);

		JPanel panel = new JPanel();

		textArea = new JTextArea(3, 22);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel.add(textArea);

		// Adds an enter key listener for the "Enter" key
		textArea.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					btnEnter.doClick();
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		// Search Button Creation
		btnEnter = new JButton("Search");
		btnEnter.addActionListener(this);
		panel.add(btnEnter);

		frame.getContentPane().add(panel, "span 2");

		// Labels for Checkboxes
		JLabel resourceLabel = new JLabel("Resource Selection");
		Font resourcefont = resourceLabel.getFont();
		Map attributes = resourcefont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		resourceLabel.setFont(resourcefont.deriveFont(attributes));
		frame.add(resourceLabel, "cell 0 1");

		JLabel filterLabel = new JLabel("Filter Selection");
		Font filterfont = filterLabel.getFont();
		Map filattributes = filterfont.getAttributes();
		filattributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		filterLabel.setFont(filterfont.deriveFont(filattributes));
		frame.add(filterLabel);

		// Resource Checkboxes

		JCheckBox hhtc = new JCheckBox("H&HTC");
		if (setDefaults.getProperty("H&HTC").equals("1")) {
			hhtc.setSelected(true);
		} else {
			hhtc.setSelected(false);
		}
		hhtc.addItemListener(this);
		frame.add(hhtc, "cell 0 2");

		JCheckBox accountingcs = new JCheckBox("Accounting CS");
		if (setDefaults.getProperty("Accounting CS").equals("1")) {
			accountingcs.setSelected(true);
		} else {
			accountingcs.setSelected(false);
		}
		accountingcs.addItemListener(this);
		frame.add(accountingcs);

		JCheckBox tfs = new JCheckBox("TFS");
		if (setDefaults.getProperty("TFS").equals("1")) {
			tfs.setSelected(true);
		} else {
			tfs.setSelected(false);
		}
		tfs.addItemListener(this);
		frame.add(tfs, "cell 0 3");

		JCheckBox accountingca = new JCheckBox("Accounting CS Client Access");
		if (setDefaults.getProperty("Accounting CS Client Access").equals("1")) {
			accountingca.setSelected(true);
		} else {
			accountingca.setSelected(false);
		}
		accountingca.addItemListener(this);
		frame.add(accountingca);

		JCheckBox qlogs = new JCheckBox("Q-Logs");
		if (setDefaults.getProperty("Q-Logs").equals("1")) {
			qlogs.setSelected(true);
		} else {
			qlogs.setSelected(false);
		}
		qlogs.addItemListener(this);
		frame.add(qlogs, "cell 0 4");

		JCheckBox practice = new JCheckBox("Practice CS");
		if (setDefaults.getProperty("Practice CS").equals("1")) {
			practice.setSelected(true);
		} else {
			practice.setSelected(false);
		}
		practice.addItemListener(this);
		frame.add(practice);

		JCheckBox alerts = new JCheckBox("Alerts and Notices");
		if (setDefaults.getProperty("Alerts and Notices").equals("1")) {
			alerts.setSelected(true);
		} else {
			alerts.setSelected(false);
		}
		alerts.addItemListener(this);
		frame.add(alerts, "cell 0 5");

		JCheckBox web = new JCheckBox("Web Services");
		if (setDefaults.getProperty("Web Services").equals("1")) {
			web.setSelected(true);
		} else {
			web.setSelected(false);
		}
		web.addItemListener(this);
		frame.add(web);

		JCheckBox custservice = new JCheckBox("Customer Service");
		if (setDefaults.getProperty("Customer Service").equals("1")) {
			custservice.setSelected(true);
		} else {
			custservice.setSelected(false);
		}
		custservice.addItemListener(this);
		frame.add(custservice, "cell 0 6");

		JCheckBox qtoggle = new JCheckBox("Toggle TFS Queries");
		qtoggle.setSelected(false);
		qtoggle.addItemListener(this);
		frame.add(qtoggle, "cell 0 8");

		JCheckBox csa = new JCheckBox("Creative Solutions Accounting");
		if (setDefaults.getProperty("Creative Solutions Accounting").equals("1")) {
			csa.setSelected(true);
		} else {
			csa.setSelected(false);
		}
		csa.addItemListener(this);
		frame.add(csa, "cell 1 6");

		JCheckBox workpapers = new JCheckBox("Workpapers");
		if (setDefaults.getProperty("Workpapers").equals("1")) {
			workpapers.setSelected(true);
		} else {
			workpapers.setSelected(false);
		}
		workpapers.addItemListener(this);
		frame.add(workpapers, "cell 1 7");

		JCheckBox adflow = new JCheckBox("AdvanceFlow");
		if (setDefaults.getProperty("AdvanceFlow").equals("1")) {
			adflow.setSelected(true);
		} else {
			adflow.setSelected(false);
		}
		adflow.addItemListener(this);
		frame.add(adflow, "cell 1 8");

		JLabel extraLabel = new JLabel("UltraTax TFS Query");
		Font extrafont = extraLabel.getFont();
		Map extraattributes = extrafont.getAttributes();
		extraattributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		extraLabel.setFont(extrafont.deriveFont(extraattributes));
		frame.add(extraLabel, "cell 0 9");

		JCheckBox fcabinet = new JCheckBox("FileCabinet");
		if (setDefaults.getProperty("FileCabinet").equals("1")) {
			fcabinet.setSelected(true);
		} else {
			fcabinet.setSelected(false);
		}
		fcabinet.addItemListener(this);
		frame.add(fcabinet);

		// Tax TFS Queries, allows user to select filters to narrow down search in TFS
		String[] taxStrings = { "1040", "1041", "1065", "1120", "2290", "5500", "706", "709", "990", "Platform",
				"Conversion" };
		JComboBox<String> tax = new JComboBox<String>(taxStrings);
		tax.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfsQStorage[0] = e.getItem().toString();
			}
		});
		frame.add(tax, "cell 0 10");

		String[] jStrings = { "", "FED", "ORG", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GL", "GA",
				"HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MI CTY", "MN", "MO", "MS",
				"MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OH CTY", "OK", "OR", "PA", "RI", "SC",
				"TN", "UT", "VA", "VT", "WI", "WV" };
		JComboBox<String> jurisdiction = new JComboBox<String>(jStrings);
		jurisdiction.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfsQStorage[1] = e.getItem().toString();
			}
		});
		frame.add(jurisdiction, "cell 0 10");

		// JLabel meLabel = new JLabel("Tax Multi-Entity TFS Query");
		// Font mefont = meLabel.getFont();
		// Map meattributes = mefont.getAttributes();
		// meattributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		/// meLabel.setFont(mefont.deriveFont(meattributes));
		// frame.add(meLabel, "cell 0 11");

		// String[] meStrings = {"", "CA PPT", "DC PPT", "FL PPT", "GA PPT", "IN PPT",
		// "KY PPT", "MBT", "MD PPT", "MI MBT", "MI PPT",
		// "NC PPT", "NE PPT", "NV", "OH CAT", "PR PPT", "SC PPT", "TX", "TX PPT", "VA
		// PPT", "WI PPT"
		// };
		// JComboBox<String> me = new JComboBox<String>(meStrings);
		// me.addItemListener(new ItemListener() {

		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// tfsQStorage[2] = e.getItem().toString();
		// }
		// });
		// frame.add(me, "cell 0 12");

		// More Resource Checkboxes
		JCheckBox gofileroom = new JCheckBox("GoFileRoom");
		if (setDefaults.getProperty("GoFileRoom").equals("1")) {
			gofileroom.setSelected(true);
		} else {
			gofileroom.setSelected(false);
		}
		gofileroom.addItemListener(this);
		frame.add(gofileroom, "cell 1 10");

		JCheckBox ut2018 = new JCheckBox("2018 UltraTax");
		if (setDefaults.getProperty("2018 UltraTax").equals("1")) {
			ut2018.setSelected(true);
		} else {
			ut2018.setSelected(false);
		}
		ut2018.addItemListener(this);
		frame.add(ut2018, "cell 1 11");

		JCheckBox ut2017 = new JCheckBox("2017 UltraTax");
		if (setDefaults.getProperty("2017 UltraTax").equals("1")) {
			ut2017.setSelected(true);
		} else {
			ut2017.setSelected(false);
		}
		ut2017.addItemListener(this);
		frame.add(ut2017, "cell 1 12");

		JCheckBox ut2016 = new JCheckBox("2016 UltraTax");
		if (setDefaults.getProperty("2016 UltraTax").equals("1")) {
			ut2016.setSelected(true);
		} else {
			ut2016.setSelected(false);
		}
		ut2016.addItemListener(this);
		frame.add(ut2016, "cell 1 13");

		JCheckBox ut2015 = new JCheckBox("2015 UltraTax");
		if (setDefaults.getProperty("2015 UltraTax").equals("1")) {
			ut2015.setSelected(true);
		} else {
			ut2015.setSelected(false);
		}
		ut2015.addItemListener(this);
		frame.add(ut2015, "cell 1 14");

		JCheckBox fixedassets = new JCheckBox("Fixed Assets");
		if (setDefaults.getProperty("Fixed Assets").equals("1")) {
			fixedassets.setSelected(true);
		} else {
			fixedassets.setSelected(false);
		}
		fixedassets.addItemListener(this);
		frame.add(fixedassets, "cell 1 15");

		JCheckBox planner = new JCheckBox("Planner");
		if (setDefaults.getProperty("Planner").equals("1")) {
			planner.setSelected(true);
		} else {
			planner.setSelected(false);
		}
		planner.addItemListener(this);
		frame.add(planner, "cell 1 16");

		frame.setVisible(true);

	}

	// These arrays holds all the checkbox reference data and the starting ComboxBox
	// items
	ArrayList<String> resourceStates = new ArrayList<String>();
	ArrayList<String> filterStates = new ArrayList<String>();
	String[] tfsQStorage = { "1040", "", "" };
	String[] temp = { "", "" };

	public void itemStateChanged(ItemEvent checkE) {
		// gets the state of the clicked box
		int checkboxnewstate = checkE.getStateChange();
		// gets the name of the clicked box
		String checkboxname = ((JCheckBox) checkE.getItem()).getText();
		// adds or removes the checkbox from the list
		CheckboxModifier sentVars = new CheckboxModifier();
		ArrayList<String>[] tempArray = sentVars.returnResource(resourceStates, filterStates, checkboxnewstate,
				checkboxname);
		resourceStates = tempArray[0];
		filterStates = tempArray[1];
		PropertyStorage SendtoStorage = new PropertyStorage();
		SendtoStorage.setNewProperty(checkboxname, checkboxnewstate);
	}

	// Boolean test = true;
	@Override
	public void actionPerformed(ActionEvent actionE) {
		// Saves current text and removes it from the text area
		String tempInput = textArea.getText().trim();
		textArea.setText("");

		// Reads what filters are checkboxed and returns string
		FilterCreator setFilters = new FilterCreator();
		String[] filterAlertString = setFilters.returnFilterURL(filterStates);

		// Reads the tfs query section and returns a string
		if (resourceStates.contains("TFSQS")) {
			TFSTaxQuery createTFSURL = new TFSTaxQuery();
			temp = createTFSURL.returnTFSAdditionalText(tfsQStorage);
		}

		// Creates URLs using the filter information
		URLGenerator urlCreator = new URLGenerator();
		ArrayList<String> formatedURLS = urlCreator.createURLS(tempInput, filterAlertString, filterStates, temp,
				resourceStates);

		// Opens all processes selected as resources with filtered information
		OpenResource resources = new OpenResource();
		resources.createProcess(formatedURLS, resourceStates, filterAlertString, filterStates);

		// Creates record of searches and dates,
		// LogCreation record = new LogCreation();
		// record.createLog(tempInput);

	}
}