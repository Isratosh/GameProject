package project;

/* TextDemo.java requires no other files. */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class KFTextBox extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int order = 0;
    protected JTextField textField;
    protected static JTextArea textArea;
    private final static String newline = "\n";
    public static String curRoom;
    private static String newVar;
    public boolean hasKey = false;
    public static String leaveVar;
    public static boolean questMode = false;
    public static String curQuest;
    public static String gameOver = "Congradulations on making it ths far. Unfortunately, the Mad King Isratosh the Gluttonous proved to be a match for you. Play again and see how far you can get." + newline;
    public static boolean bobQuest = true;
   

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
        if(questMode == false){
        //look around
        if (text.contains("look around")) {
    		switch(curRoom) 
    		{
    		case "House":
    			textArea.append(House.getItemShortDescs());
    			textField.selectAll();
    			break;
    		case "MainHall":
    			textArea.append(MainHall.getItemShortDescs());
    			textField.selectAll();
    			break;
    		case "ThroneRoom":
    			textArea.append(ThroneRoom.getItemShortDescs());
    			textField.selectAll();
    			break;
    		case "Dungeon":
    			textArea.append(Dungeon.getItemShortDescs());
    			textField.selectAll();
    			break;
    		default:
    			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
    			break;
    		}
        	textField.selectAll();
        	//Make sure the new text is visible, even if there
        	//was a selection in the text area.
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        } else 
//examine
        if (text.contains("examine ")) 
        {
        	String[] split = text.split(" ");
        	newVar = split[1];
    		switch(curRoom) 
    		{
    		case "House":
    			textArea.append(House.getSpecItem(newVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "MainHall":
    			textArea.append(MainHall.getSpecItem(newVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "ThroneRoom":
    			textArea.append(ThroneRoom.getSpecItem(newVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "Dungeon":
    			textArea.append(Dungeon.getSpecItem(newVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		default:
    			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART. IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
    			break;
    		}
    		
        	} else
//Actions two words with expression
        	if(text.contains("read ") || text.contains("unlock ") || text.contains("open ") || text.contains("take ") && !text.contains("key")) 
        	{
        		String[] split = text.split(" ");
        		String commVar = split[1];
        		switch(curRoom) 
        		{
        		case "House":
        			if(House.commActions.contains(commVar)) 
        			{
        				switch(commVar) 
        				{
        				case "book":
        					textArea.append(House.itemUsed(House.BOOK).itemUsedItem());
        					break;
        				case "chest":
        					if(House.hasKey = true) 
        					{
        					textArea.append(House.itemUsed(House.CHEST).itemUsedItem());
        					House.openedChest = true;
        					} else 
        					{
        						textArea.append("You need the key to open the chest.");
        					}
        					break;
        				case "sword":
        					textArea.append(House.itemUsed(House.SWORD).itemUsedItem());
        					break;
        				case "poison":
        					textArea.append(House.itemUsed(House.POISON).itemUsedItem());
        					break;
        				case "key":
        					textArea.append(House.itemUsed(House.SILVER).itemUsedItem());
        					break;      					
        				}
        				textField.selectAll();
        			}
        			break;
        		case "MainHall":
        			break;
        		case "Dungeon":
        			break;
        		case "ThroneRoom":
        			break;
        		default:
        			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART. IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
        			break;
        		}
        		//textArea.append(House.getSpecItem(0).getLongDesc() + newline);
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        }else 
//Actions three words with expression
        if(text.contains("look under ")) 
        {
        	String[] split = text.split(" ");
        	String commVar = split[2];
        	switch(curRoom) 
        	{
        	case "House":
        		switch(commVar) 
        		{
        		case "doormat":
					textArea.append(House.itemUsed(House.DOORMAT).itemUsedItem());
					House.underMat = true;
					break;
        		}
        		break;
        	}
        	textField.selectAll();
        } else
        if( text.contains("take") && text.contains("key"))
        {
        	String[] split = text.split(" ");
        	String commVar = split[1] +" "+ split[2];
        	switch(curRoom) 
    		{
    		case "House":
    				switch(commVar) 
    				{
    				case "silver key":
    					if(House.underMat == true) {
    					textArea.append(House.itemUsed(House.SILVER).itemUsedItem());
    					House.hasKey = true;
    					} else
    					{
    						textArea.append("You need to have seen the key to take it." + newline);
    					}
    					textField.selectAll();
    					break;
    				case "gold key":
    					if(House.openedChest == true) {
    					textArea.append(House.itemUsed(House.GOLD).itemUsedItem());
    					House.hasGold = true;
    					} else 
    					{
    						textArea.append("");
    					}
    					textField.selectAll();
    					break;
    				}
    			break;
    		case "MainHall":
    			
    			break;
    		case "ThroneRoom":
    			
    			break;
    		case "Dungeon":
    			
    			break;
    		default:
    			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART. IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
    			break;
    		}
        } else
//exit command
        if(text.contains("/exit")) 
        {
        	MainMenu.textDemoVisible();
        	textField.selectAll();
        } else
//help command
        if(text.contains("/help")) 
        {
        	textArea.append(House.getHelp() + newline);
        	textField.selectAll();
        } else
//debug give key command
        if(text.contains("/givekey")) 
        {
        	House.hasKey = true;
        	textField.selectAll();
        } else
//go command
        if(text.contains("/go")) 
        {
        	String[] split = text.split(" ");
        	leaveVar = split[1];
        	textField.selectAll();
        	if(House.hasKey == true) 
        	{
	        	switch(curRoom) 
	        	{
	        	case "House":
	        		if(House.placeToGo.contains(leaveVar)) 
	        		{
	        			goTo(leaveVar);
	        		} else 
	        		{
	        			textArea.append("You can go to: " + House.placeToGo + "from here!" + newline);
	        		}
	        		break;
	        	case "MainHall":
	        		if(MainHall.placeToGo.contains(leaveVar)) 
	        		{
	        			goTo(leaveVar);
	        		} else 
	        		{
	        			textArea.append("You can go to: " + MainHall.placeToGo + "from here!" + newline);
	        		}
	        		break;
	        	case "ThroneRoom":
	        		if(ThroneRoom.placeToGo.contains(leaveVar)) 
	        		{
	        			goTo(leaveVar);
	        		} else 
	        		{
	        			textArea.append("You can go to: " + ThroneRoom.placeToGo + "from here!" + newline);
	        		}
	        		break;
	        	case "Dungeon":
	        		if(Dungeon.placeToGo.contains(leaveVar)) 
	        		{
	        			goTo(leaveVar);
	        		} else 
	        		{
	        			textArea.append("You can go to: " + Dungeon.placeToGo + "from here!" + newline);
	        		}
	        		break;
        		default:
        			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
        			break;
	        	}
        	} else 
        	{
        		textArea.append("Sorry, but you need the door key to leave, maybe it is in your chest..." + newline);
        	} 
        } else
//debug getcurrent room command
        if (text.contains("/getcuroom")) 
        {
        	curRoom();
        	System.out.println(curRoom); //DEBUG
        	textField.selectAll();
        } else
//talk to char
        if (text.contains("talk to ")) {
        	String[] split = text.split(" ");
        	String toTalk = split[2];
        
        	textField.selectAll();
    		switch(curRoom) 
    		{
    		case "House":
    			textField.selectAll();
    			break;
    		case "MainHall":
    			textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    			textField.selectAll();
    			break;
    		case "ThroneRoom":
    			textArea.append(ThroneRoom.getSpecCharacter(toTalk).talkTo());
    			textField.selectAll();
    			break;
    		case "Dungeon":
    			textField.selectAll();
    			break;
    		default:
    			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
    			break;
    		}
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        } else 
//ask name of char
        if (text.contains("ask name")) {
            	String[] split = text.split(" ");
            	String toTalk = split[2];
            	textField.selectAll();
        		switch(curRoom) 
        		{
        		case "House":
        			textField.selectAll();
        			break;
        		case "MainHall":
        			textArea.append(MainHall.getSpecCharacter(toTalk).getFullName() + newline);
        			textField.selectAll();
        			break;
        		case "ThroneRoom":
        			textField.selectAll();
        			break;
        		case "Dungeon":
        			textField.selectAll();
        			break;
        		default:
        			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
        			break;
        		}
            	textField.selectAll();
            	textArea.setCaretPosition(textArea.getDocument().getLength());
        } else
//quest accepting
        if(text.contains("accept ")) 
        {
        	String[] split = text.split(" ");
        	String accepted = split[1];
        	textField.selectAll();
        	textArea.append(MainHall.getSpecCharacter(accepted).getQuestText() + newline);
        	switch(accepted) 
        	{
        	case "bob":
        		curQuest = "bob";
        		questMode = true;
        		System.out.println(questMode);
        		break;
        	case "micheal":
        		curQuest = "micheal";
        		questMode = true;

        		break;
        	case "gabriella":
        		curQuest = "gabriella";
        		questMode = true;

        		break;
        	case "thomas":
        		curQuest = "thomas";
        		questMode = true;

        		break;
        	}
        } else
        {
        	textArea.append("Sorry, but that is not a valid response.\n");
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        }
        
    } else 
    {
    	boolean initial = false;
    	int order = 0;
    	System.out.println("quest mode engage ayy lmao!");
    	if(curQuest == "bob") 
    	{
    		if(initial == false) {
    		textArea.append("You have started bob's quest please wait..." + newline);
    		textArea.append("The guard is patrolling the far wall." + newline);
    		initial = true;
    		} else
    		if(order ==  0 && text.contains("move")) 
    		{
    			textField.selectAll();
    			textArea.append("You move closer to the guard. You see his money pouch, now how to get at it. Maybe you should wait for him to turn... or steal it now..." + newline);
    			order = 1;
      		} else
      		if(order == 1 && text.contains("wait")) 
      		{
      			textArea.append("As you slowly make your approach, the guard turns away... The time for action is now." + newline);
      			textField.selectAll();
      			order = 2;
      		} else
      		if(order == 1 && text.contains("now")) 
      		{
      			textArea.append("As you reach for the pouch of coins, another guard kicks you from behind. You are captured, and killed for thievery." + newline);
      			textArea.append(gameOver);
      			textField.selectAll();
      			MainMenu.textDemoVisible();
      		} else
      		if(order == 2 && text.contains("take"))
      		{
      			textArea.append("You carefully steal the money. The guard doesn't notice! you move with all haste back to bob the locksmith!" + newline);
      			textArea.append("\"Cheers mate!\"says bob \" I'll get to work on that key now!\"");
      			textArea.append("Congratulations! Bob is now on your side!");
      			
      		}
    	}
    }
    }
    public static void goTo(String i) 
    {
    	switch(curRoom) 
    	{
    	case "House":
			switch(leaveVar) 
    		{
			case "main":
				House.isActive = false;
	    		MainHall.isActive = true;
	    		curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
				break;
    		}
    		break;
    	case "MainHall":
    		switch(leaveVar) 
    		{
			case "house":
				MainHall.isActive = false;
	    		House.isActive = true;
	    		curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
				break;
			case "dungeon":
				MainHall.isActive = false;
				Dungeon.isActive = true;
				curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
					break;
			case "throne":
				MainHall.isActive = false;
				ThroneRoom.isActive = true;
				curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
				break;
    		}
    		break;
    	case "ThroneRoom":
    		switch(leaveVar) 
    		{
			case "main":
				ThroneRoom.isActive = false;
	    		MainHall.isActive = true;
	    		curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
				break;
    		}
    		break;
    	case "Dungeon":
    		switch(leaveVar) 
    		{
			case "house":
				Dungeon.isActive = false;
	    		House.isActive = true;
	    		curRoom();
	        	textArea.append("You are now in the " + curRoom + " room!" + newline);
	        	Dungeon.setup();
				break;
    		}
    		break;
		default:
			textArea.append("FATAL ERROR: YOU ARE NOT IN ANY DEFINED ROOM, PLEASE RESTART IF THIS IS NOT THE FIRST TIME YOU ARE READING THIS MESSAGE THEN REDOWNLOAD .JAR FROM: github.com/Isratosh/GameProject/releases");
			break;
    	}
    }
    static void createAndShowGUI() {
        //Create and set up the window.
    	//House.setup();
    	if(MainMenu.isActive == false) {
        JFrame frame = new JFrame("Kingdom Feller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new KFTextBox());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        MainMenu.isActive = true;
        House.setup();
        MainHall.setup();
        ThroneRoom.setup();
        Dungeon.setup();
        House.isActive = true;
        curRoom();
    	}
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */

    

    public static void main(String[] args) {
    	 System.out.println(curRoom);
		// TODO Auto-generated method stub
    	/*REMOVE THE FOLLOWING LINES AFTER DEVELOPMENT!!!!!*/
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
