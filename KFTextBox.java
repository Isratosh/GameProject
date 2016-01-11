package project;

/* TextDemo.java requires no other files. */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KFTextBox extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int order = 0;
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
    public static String curRoom;
    private static String newVar;
    
   

    public KFTextBox() {
        super(new GridBagLayout());

        textField = new JTextField(20);
        textField.addActionListener(this);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0; 
        c.weighty = 1.0;
        add(scrollPane, c);
        startUp();
    }
    private void startUp() 
    {
    	textArea.append("You find yourself in a room, you don't know how or why you got there." + newline);
    }
    public static void curRoom() 
    {
    	if(House.isActive == true) 
    	{
    		curRoom = "House";
    		Dungeon.isActive = false;
    		MainHall.isActive = false;
    		ThroneRoom.isActive = false;
    	} else if(Dungeon.isActive == true) 
    	{
    		curRoom = "Dungeon";
    		House.isActive = false;
    		MainHall.isActive = false;
    		ThroneRoom.isActive = false;
    	} else if(MainHall.isActive == true)
    	{
    		curRoom = "MainHall";
    		Dungeon.isActive = false;
    		House.isActive = false;
    		ThroneRoom.isActive = false;
    	} else if(ThroneRoom.isActive == true) 
    	{
    		curRoom = "ThroneRoom";
    		Dungeon.isActive = false;
    		MainHall.isActive = false;
    		House.isActive = false;
    	} else 
    	{
    		System.out.println("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM");
    	}
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText().toLowerCase();
        if (text.contains("look around")) {
        	textArea.append(House.getItemShortDescs());
        	textField.selectAll();
        	//Make sure the new text is visible, even if there
        	//was a selection in the text area.
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        } else 
        if (text.contains("examine ")) 
        {
        	String[] split = text.split(" ");
        	newVar = split[1];
    		switch(curRoom) 
    		{
    		case "House":
    			textArea.append(House.getSpecItem(newVar).getLongDesc() + newline);
    			break;
    		case "MainHall":
    			break;
    		case "ThroneRoom":
    			break;
    		case "Dungeon":
    			break;
    		}
    		
        	/*switch(newVar) 
        	{
        	case newVar:
        		textArea.append(House.getSpecItem(House.DOORMAT).getLongDesc() + newline);
        		break;
        	case "table":
        		textArea.append(House.getSpecItem(House.TABLE).getLongDesc() + newline);
        		break;
        	case "book":
        		textArea.append(House.getSpecItem(House.BOOK).getLongDesc() + newline);
        		break;
        	case "chest":
        		textArea.append(House.getSpecItem(House.CHEST).getLongDesc() + newline);
        		break;
        	default:
        		textArea.append("I can't see a \"" + newVar + "\" in this room." + newline);
        		break;
        	}*/} else
        	if(text.contains("read book")) {
        		textArea.append(House.itemUsed(House.BOOK).itemUsedItem());
        		//textArea.append(House.getSpecItem(0).getLongDesc() + newline);
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        } else 
        if(text.contains("look under mat")) 
        {
        	textArea.append(House.itemUsed(House.DOORMAT).itemUsedItem());
        } else
        if(text.contains("/exit")) 
        {
        	MainMenu.textDemoVisible();
        	textField.selectAll();
        } else
        if(text.contains("/help")) 
        {
        	textArea.append(House.getHelp() + newline);
        	textField.selectAll();
        } else
        {
        	textArea.append("Sorry, but that is not a valid response.\n");
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        } 
    }
    static void createAndShowGUI() {
        //Create and set up the window.
    	if(MainMenu.isActive == false) {
        JFrame frame = new JFrame("Kingdom Feller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new KFTextBox());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        MainMenu.isActive = true;
    	}
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */

    

    public static void main(String[] args) {
    	 House.setup();
    	 House.isActive = true;
    	 curRoom();
    	 System.out.println(curRoom);
		// TODO Auto-generated method stub
    	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
       	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
       	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
       	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
       	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
       	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });
	}
}
