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
    private static String examVar;
    public boolean hasKey = false;
    public static String leaveVar;
    public static boolean questMode = false;
    public static String curQuest;
    public static String gameOver = "Congratulations on making it this far. Unfortunately, the Mad King Isratosh the Gluttonous proved to be a match for you. Play again and see how far you can get." + newline;
    public static boolean bobQuest = true;
	public static boolean initial = false;
	public static boolean bobQ = false;
	public static boolean michealQ = false;
	public static boolean gabriellaQ = false;
	public static boolean thomasQ = false;
	public static boolean raguTalk1 = false;
	public static boolean finalQA = false;
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
        	examVar = split[1];
    		switch(curRoom) 
    		{
    		case "House":
    			textArea.append(House.getSpecItem(examVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "MainHall":
    			textArea.append(MainHall.getSpecItem(examVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "ThroneRoom":
    			textArea.append(ThroneRoom.getSpecItem(examVar).getLongDesc() + newline);
    			textField.selectAll();
    			break;
    		case "Dungeon":
    			textArea.append(Dungeon.getSpecItem(examVar).getLongDesc() + newline);
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
        	textField.selectAll();
        } else
        if(text.contains("/doquest")) 
        {
        	bobQ = true;
        	michealQ = true;
        	gabriellaQ = true;
        	thomasQ = true;
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
    			switch(toTalk) 
    			{
    			case "ragoolaman":
    				if(!raguTalk1) 
    				{
    					textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    					textField.selectAll();
    					raguTalk1 = true;
    				} else
    				if(bobQ && michealQ && gabriellaQ && thomasQ) 
    				{
    					textArea.append("I see you did those jobs I asked about. Well, I have bob's key with me here. Micheal has arranged for ursurper guards to be there. Gabriella has given you the support of the people. And finally Thomas has spread discontent with the king among the remaining guards." + newline);
    					textArea.append("Take care of any remaining business you have. Come back and accept my quest when you are ready to begin." + newline);
    					textArea.append("Just remember that when you are finished my job, you will become the Feller of Kingdoms. I think the title will suit you well." + newline);
    					finalQA = true;
    				} else
    				{
    					textArea.append("You need to complete your four jobs before you can talk to Ragoolaman again!" + newline);
    				}
    				break;
    			case "bob":
    				if(!bobQ) 
    				{
    	    			textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    	    			textField.selectAll();
    				} else 
    				{
    					textArea.append("Bob has left the hall to make your key." + newline);
    					textField.selectAll();
    				}
    				break;
    			case "micheal":
    				if(!michealQ) 
    				{
    	    			textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    	    			textField.selectAll();
    				} else 
    				{
    					textArea.append("Micheal has left the hall. Perhaps to sharpen his knife." + newline);
    					textField.selectAll();
    				}
    				break;
    			case "gabriella":
    				if(!gabriellaQ) 
    				{
    	    			textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    	    			textField.selectAll();
    				} else 
    				{
    					textArea.append("Gabriella has left the hall. Perhaps she is begging food off of people." + newline);
    					textField.selectAll();
    				}
    				break;
    			case "thomas":
    				if(!thomasQ) 
    				{
    	    			textArea.append(MainHall.getSpecCharacter(toTalk).talkTo() + newline);
    	    			textField.selectAll();
    				} else
    				{
    					textArea.append("Thomas has left the hall. Maybe he is looking busy to stay alive." + newline);
    					textField.selectAll();
    				}
    				break;
    			default:
    				textArea.append("Sorry, but \"" + toTalk + "\" is not in the main hall right now.");
    				break;
    			}
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
        		textArea.append("type \"start\" to start." + newline);
        		textField.selectAll();
        		break;
        	case "micheal":
        		curQuest = "micheal";
        		questMode = true;
        		textArea.append("type \"start\" to start." + newline);
        		textField.selectAll();
        		break;
        	case "gabriella":
        		curQuest = "gabriella";
        		questMode = true;
        		textArea.append("type \"start\" to start." + newline);
        		textField.selectAll();
        		break;
        	case "thomas":
        		curQuest = "thomas";
        		questMode = true;
        		textArea.append("type \"start\" to start." + newline);
        		textField.selectAll();
        		break;
        	case "ragoolaman":
        		if(finalQA)
        		{
        		curQuest = "ragoolaman";
        		questMode = true;
        		textArea.append("type \"start\" to start" + newline);
        		textField.selectAll();
        		} else
        		{
        			textArea.append("You need to finish everything else before you can accept ragoolaman's final quest." + newline);
        		}
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
      			textArea.append("\"Cheers mate!\"says bob \" I'll get to work on that key now!\"" + newline);
      			textArea.append("Congratulations! Bob is now on your side!" + newline);
      			textField.selectAll();
      			questMode = false;
      			curQuest = null;
      			initial = false;
      			bobQ = true;
      		}
    		
    	} else
    	if(curQuest == "micheal") 
    	{
    		if(initial == false){
    		MainHall.isActive = false;
    		Dungeon.isActive = true;
    		curRoom();
    		textArea.append("You have started micheal's quest, please wait..." + newline);
    		textArea.append("You run up and kick the guard, you are thrown into the cell after being beaten. You fall asleep nearly instantly." + newline);
    		initial = true;
    		} else
    		if(text.contains("look around")) 
    		{
    			textArea.append(Dungeon.getItemShortDescs());
    			textField.selectAll();
    		} else
    	    if (text.contains("examine ")) 
    	    {
    	        	String[] split = text.split(" ");
    	        	examVar = split[1];
    	        	textField.selectAll();
    	        	textArea.append(Dungeon.getSpecItem(examVar).getLongDesc() + newline);
    	    } else
    	    if (text.contains("take knife"))     	    	 
    	    {
    	    	textArea.append(Dungeon.itemUsed(Dungeon.KNIFE).itemUsedItem());
    	    } else 
    	    if (text.contains("bend bars")){
    	    	textArea.append("You return to micheal, he says:" + newline);
    	    	textArea.append("Cheers mate, I owe you a biggie now!" + newline);
    	    	textArea.append("Micheal is on your side! Rejoice!" + newline);
    	    	textField.selectAll();
    	    	questMode = false;
    	    	curQuest = null;
    	    	initial = false;
    	    	MainHall.isActive = true;
    	    	Dungeon.isActive = false;
    	    	curRoom();
    	    	michealQ = true;
    	    }
    	}
    	if(curQuest == "gabriella") 
    	{
    		if(initial == false) 
    		{
    			textArea.append("You have started gabriella's quest, please wait..." + newline);
    			textArea.append("You see the food on the table, a guard is right beside it facing away from you, you could run, or take your time.");
    			initial = true;
    		} else 
    		{
    			if(text.contains("run")) 
    			{
    				textArea.append("Your quick approach works, you are right behind the guard.");
    				textField.selectAll();
    			} else
    			if(text.contains("slow") || text.contains("time")) 
    			{
    				textArea.append("As you slowly make your approach, the guard turns! You are caught red handed! The capture, beat, and kill you for your thievery!");
          			textField.selectAll();
    				textArea.append(gameOver);
          			MainMenu.textDemoVisible();
    			} else
    			if(text.contains("take") || text.contains("steal")) 
    			{
    				textArea.append("You take some bread, and make all haste back to gabriella." + newline);
    				textArea.append("You give the food to gabriella, and she says:" + newline);
    				textArea.append("Thank you sir! I am ever in your debt!" + newline);
    				textArea.append("Gabriella will now help you when the time is right!" + newline);
    				textField.selectAll();
    				questMode = false;
    				curQuest = null;
    				initial = false;
    				gabriellaQ = true;
    			}
    		}
    	}
    	if(curQuest == "thomas") 
    	{
    		if(initial == false) 
    		{
    			textArea.append("You have started thomas' quest, please wait..." + newline);
    			textArea.append("You see the barrel of mead. The barrel is just to your left. It is heavily guarded." + newline);
    			initial = true;
    		} else 
    		{
    			if(text.contains("approach") || text.contains("toward")) 
    			{
    				textArea.append("As you approach the barrel, a guard confronts you." + newline);
    				textArea.append("Oi, you there! Yeh think yer gonna get some ale?" + newline);
    				textArea.append("Do you: talk your way out of it, or do you rush the guard?" + newline);
    				textField.selectAll();
    			} else
    			if(text.contains("rush")) 
    			{
    				textArea.append("You rush the guard, and he quickly dispatches you with his dagger. Lifeless, you fall to the ground." + newline);
    				textArea.append(gameOver);
    				textField.selectAll();
          			MainMenu.textDemoVisible();
    			}
    			if(text.contains("talk")) 
    			{
    				textArea.append("You: I'm getting more for Sir Thomas the Back-Stabbing over there." + newline);
    				textArea.append("Guard: Very well, but you tell 'im, that he ain't be gettin' anymore t'day!" + newline);
    				textArea.append("You fill the mug and return it to thomas." + newline);
    				textArea.append("Thomas: Thanksh mate, I owe ye' for dish one..." + newline);
    				textField.selectAll();
    				questMode = false;
    				curQuest = null;
    				initial = false;
    				thomasQ = true;
    				
    			}
    		}
    	}
    	if(curQuest == "ragoolaman") 
    	{
    		if(initial == false) 
    		{
    			textArea.append("You have started ragoolaman's quest, please wait..." + newline);
    			textArea.append("As you reach the locked doors to the throne room, you take out the key bob made for you." + newline);
    			initial = true;
    		} else {
    			if(text.contains("unlock") || text.contains("open")) 
    			{
    				textArea.append("You insert the key into the lock. As you twist it around, the lock clicks several times. The door swings open suddenly. At the other end of the room, Isratosh sleeps on his throne while someone tries to teach him better english skills." + newline);
    			} else
    			if(text.contains("approach")) 
    			{
    				textArea.append("As you make your silent approach, you unsheath your sword. The noise attracts the attention of the teacher. \"AHH!\" they yell. \"huh?\" goes the King as he stirs from his fitful sleep." + newline);
    				textArea.append("The teacher slowly backs away then runs out the door you entered from. \n\"How did you get in here?\" demands the King. As he notices your drawn sword he yells\"GUARDS! TO YOUR KING!\" but no one answers." + newline);
    				textArea.append("\"You cannot count on your armies tonight Isratosh!\" You say. As you advance towards the King, he cowers on his throne. He mumbles unintelligently as his arms cover his face." + newline);
    				textArea.append("Your advance has brought you within arms reach of the King. His babbling has reached a yell. The time to end this conflict is now." + newline);
    			} else
    			if(text.contains("kill") || text.contains("sword") || text.contains("end") || text.contains("stab")) 
    			{
    				textArea.append("You swing your sword... Wit that final blow, the kings head falls lifelessly to the floor." + newline);
    				textArea.append("As the head hits the floor, the Prince walks in. He whispers \"He is finally dead... THE KING IS DEAD!\"" + newline);
    				textArea.append("You have earned your title, Feller of Kingdoms. May your sword stay sharp, and your mind stay strong." + newline);
    				textArea.append("\nCONGRATULATIONS! You have completed the game! The king Isratosh The Gluttonous has been killed! You will go down in history now!" + newline);
    				textArea.append("A message from the developers:" + newline);
    				textArea.append("Thank you for playing our first game, we hope you enjoyed it! We will be producing much better games in the future, but a humble and small beginning is somtimes the best." + newline);
    				textArea.append("-Our Deepest Thanks," + newline);
    				textArea.append("Ragoolaman + Isratosh" + newline);
    				textArea.append(newline + "When you have finished reading, type \"finished\" to return to the main menu!" + newline);
    			} else
    			if(text.contains("finished")) 
    			{
    				MainMenu.textDemoVisible();
    			} else 
    			{
    				textArea.append("That is not a recognizable response." + newline);
    			}
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

    }
}
