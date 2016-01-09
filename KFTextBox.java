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
    public void curRoom() 
    {
    	if(House.isActive == true) 
    	{
    		curRoom = "House";
    	} else if(Dungeon.isActive == true) 
    	{
    		curRoom = "Dungeon";
    	} else if(MainHall.isActive == true)
    	{
    		curRoom = "MainHall";
    	} else if(ThroneRoom.isActive == true) 
    	{
    		curRoom = "ThroneRoom";
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
        	String newVar = split[1];
        	switch(newVar) 
        	{
        	case "doormat":
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
        	}} else
        	if(text.contains("read book")) {
        		textArea.append("The title of the book is \"To Kill a King\" It was written by Prince Ragoolaman" + newline);
        		textArea.append("Chapter 1: The Games Begin" + newline);
        		textArea.append("The controls are simply your keyboard. What the game tells you doesn't provide rigid options. You type things that you think could work, and if they don't you will be notified." + newline);
        		textArea.append("The commands are as follows. To return to the main menu, simply type \"/exit\" And to get vague hints one just needs to type \"/help\"" + newline);
        		textArea.append("The remainder of the princes novel has been ripped out, hence the broken spine." + newline);
        		textArea.append("All that remains past the first chapter is the final page, it has the words \"Meet me at the castle when you arrive. regards, P.R. \nP.S. I left your key under the doormat!\" scrawled into it." + newline + newline);
        		textArea.append("You can't remember who P.R. is, but you feel like they is important, and that you should meet them with all haste!" + newline);
        		textArea.append("You suddenly remember that you leave your house by typing \"leave (destination)\"however, you shouldn't leave here without your sword... Now where did you leave it again?");
        	//textArea.append(House.getSpecItem(0).getLongDesc() + newline);
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
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
    	 House.main(args);
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
