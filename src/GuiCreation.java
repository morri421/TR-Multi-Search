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

import logtracker.LogCreation;

public class GuiCreation implements ActionListener, ItemListener {

    JFrame frame;
    JTextArea textArea;
    JButton btnEnter; //Add a select all button

    public void init() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout()); Add all elements to one panel to recreate
        //frame.setLayout(new GridBagLayout());
        frame.setLayout(new MigLayout("gapx 10"));
        frame.setTitle("Thomson Reuters Internal Multi-Search Tool");
        frame.setSize(360, 525);
        
        JPanel panel = new JPanel();
       
        textArea = new JTextArea(3,22);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);
        
        //Adds an enter key listener for the "Enter" key
        textArea.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                	e.consume();
                	btnEnter.doClick();
                }
            }
        	
        	public void keyTyped(KeyEvent e) {
            }
        
        	public void keyReleased(KeyEvent e) {
            }
        });
        
      //Search Button Creation
        btnEnter = new JButton("Search");
        btnEnter.addActionListener(this);
        panel.add(btnEnter);
        
        frame.getContentPane().add(panel, "span 2");
        
        //Labels for Checkboxes  
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

        //Resource Checkboxes 
        JCheckBox qlogs = new JCheckBox("Q-Logs");
        qlogs.setSelected(false);
        qlogs.addItemListener(this);
        frame.add(qlogs, "cell 0 2");
        
        JCheckBox accountingcs = new JCheckBox("Accounting CS");
        accountingcs.setSelected(false);
        accountingcs.addItemListener(this);
        frame.add(accountingcs);
        
        JCheckBox hhtc = new JCheckBox("HHTC");
        hhtc.setSelected(false);
        hhtc.addItemListener(this);
        frame.add(hhtc, "cell 0 3");
        
        JCheckBox accountingca = new JCheckBox("Accounting CS Client Access");
        accountingca.setSelected(false);
        accountingca.addItemListener(this);
        frame.add(accountingca);
        
        JCheckBox tfs = new JCheckBox("TFS");
        tfs.setSelected(false);
        tfs.addItemListener(this);
        frame.add(tfs, "cell 0 4");
        
        JCheckBox practice = new JCheckBox("Practice");
        practice.setSelected(false);
        practice.addItemListener(this);
        frame.add(practice);
        
        JCheckBox alerts = new JCheckBox("Alerts and Notices");
        alerts.setSelected(false);
        alerts.addItemListener(this);
        frame.add(alerts, "cell 0 5");
        
        JCheckBox web = new JCheckBox("Web");
        web.setSelected(false);
        web.addItemListener(this);
        frame.add(web);
        
        JCheckBox qtoggle = new JCheckBox("Tax TFS Queries");
        qtoggle.setSelected(false);
        qtoggle.addItemListener(this);
        frame.add(qtoggle, "cell 0 6");
        
        JCheckBox csa = new JCheckBox("Creative Solutions Accounting");
        csa.setSelected(false);
        csa.addItemListener(this);
        frame.add(csa, "cell 1 6");
        
        JCheckBox workpapers = new JCheckBox("Workpapers");
        workpapers.setSelected(false);
        workpapers.addItemListener(this);
        frame.add(workpapers, "cell 1 7");
        
        JCheckBox adflow = new JCheckBox("Advance Flow");
        adflow.setSelected(false);
        adflow.addItemListener(this);
        frame.add(adflow, "cell 1 8");
        
        JLabel extraLabel = new JLabel("UltraTax TFS Query");
        Font extrafont = extraLabel.getFont();
        Map extraattributes = extrafont.getAttributes();
        extraattributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        extraLabel.setFont(extrafont.deriveFont(extraattributes));
        frame.add(extraLabel, "cell 0 9");
        
        JCheckBox fcabinet = new JCheckBox("File Cabinet");
        fcabinet.setSelected(false);
        fcabinet.addItemListener(this);
        frame.add(fcabinet);
        
        
        
        //Tax TFS 
        
        String [] tfsQStorage = {"", "", ""};
        		
        
        String[] taxStrings = {"", "1040", "1041", "1065", "1120", "2290", "5500", "706", "709", "990", "Platform", "Conversion"};
        JComboBox<String> tax = new JComboBox<String>(taxStrings);
        tax.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfsQStorage[0] = e.getItem().toString();
			}
        });
        frame.add(tax, "cell 0 10");
        
        String[] jStrings = {"","FED", "ORG", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GL", 
        		"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MI CTY", 
        		"MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OH CTY",
        		"OK", "OR", "PA", "RI", "SC", "TN", "UT", "VA", "VT", "WI", 
        		"WV"
        		};
        JComboBox<String> jurisdiction = new JComboBox<String>(jStrings);
        jurisdiction.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tfsQStorage[1] = e.getItem().toString();
			}
        });
        frame.add(jurisdiction, "cell 0 10");
        
        JLabel meLabel = new JLabel("Tax Multi-Entity TFS Query");
        Font mefont = meLabel.getFont();
        Map meattributes = mefont.getAttributes();
        meattributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        meLabel.setFont(mefont.deriveFont(meattributes));
        frame.add(meLabel, "cell 0 11");
        
        String[] meStrings = {"", "CA PPT", "DC PPT", "FL PPT", "GA PPT", "IN PPT", "KY PPT", "MBT", "MD PPT", "MI MBT", "MI PPT", 
        		"NC PPT", "NE PPT", "NV", "OH CAT", "PR PPT", "SC PPT", "TX", "TX PPT", "VA PPT", "WI PPT"
        		};
        JComboBox<String> me = new JComboBox<String>(meStrings);
        me.addItemListener(new ItemListener() {
			
        	@Override
			public void itemStateChanged(ItemEvent e) {
        		tfsQStorage[2] = e.getItem().toString();
			}
        });
        frame.add(me, "cell 0 12");
        
        
        
        
        JCheckBox gofileroom = new JCheckBox("GoFileRoom");
        gofileroom.setSelected(false);
        gofileroom.addItemListener(this);
        frame.add(gofileroom, "cell 1 10");
        
        JCheckBox ut2017 = new JCheckBox("2017 UltraTax");
        ut2017.setSelected(false);
        ut2017.addItemListener(this);
        frame.add(ut2017, "cell 1 11");
        
        JCheckBox ut2016 = new JCheckBox("2016 UltraTax");
        ut2016.setSelected(false);
        ut2016.addItemListener(this);
        frame.add(ut2016, "cell 1 12");
        
        JCheckBox ut2015 = new JCheckBox("2015 UltraTax");
        ut2015.setSelected(false);
        ut2015.addItemListener(this);
        frame.add(ut2015, "cell 1 13");
        
        JCheckBox fixedassets = new JCheckBox("Fixed Assets");
        fixedassets.setSelected(false);
        fixedassets.addItemListener(this);
        frame.add(fixedassets, "cell 1 14");
        
        JCheckBox planner = new JCheckBox("Planner");
        planner.setSelected(false);
        planner.addItemListener(this);
        frame.add(planner, "cell 1 15");
        
        frame.setVisible(true);

    }
    
    //This array holds all the checkbox reference data
    ArrayList<String> resourceStates = new ArrayList<String>();
    ArrayList<String> filterStates = new ArrayList<String>();

    public void itemStateChanged(ItemEvent checkE) {
    	//gets the state of the clicked box
    	int checkboxnewstate = checkE.getStateChange();
    	//gets the name of the clicked box
    	String  checkboxname= ((JCheckBox) checkE.getItem()).getText();
    	//adds or removes the checkbox from the list
    	ModifyCheckbox sentVars = new ModifyCheckbox();
    	ArrayList<String>[] tempArray = sentVars.returnResource(resourceStates, filterStates, checkboxnewstate, checkboxname);
    	resourceStates = tempArray[0];
    	filterStates = tempArray[1];
    }
    
    //Boolean test = true;
	@Override
	public void actionPerformed(ActionEvent actionE) {
		//Saves current text and removes it from the text area
		String tempInput = textArea.getText().trim();
		//if ((tempInput == null) || (tempInput.length() == 0)) {
        //    return;
        //} else {
		textArea.setText("");
		
		// Reads what filters are checkboxed and returns string
		FilterCreation setFilters= new FilterCreation();
		String[] filterAlertString = setFilters.returnFilterURL(filterStates);
		
		//Reads the tfs query section and returns a string
		QueryChecker querycheck = new QueryChecker();
		TFSTaxQuery createTFSURL = new TFSTaxQuery();
		
		
		//Creates URLs using the filter information
		URLGenerator urlCreator = new URLGenerator();
		ArrayList<String> formatedURLS = urlCreator.createURLS(tempInput, filterAlertString);
		
		//Opens all processes selected as resources with filtered information
		OpenResource resources = new OpenResource();
		resources.createProcess(formatedURLS, resourceStates, filterAlertString, filterStates);
		
		//Creates record of searches and dates
		LogCreation record = new LogCreation();
		record.createLog(tempInput);
		
	}
}