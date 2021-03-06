package project;


public class MainHall {
	//items array index constants
	public static final int FOOD = 0;
	public static final int DOG = 1;
	public static final int PILLAR = 2;
	public static final int THRONEDOOR = 3;
	public static final int BOB = 0;
	public static final int RAGOOLAMAN = 1;
	public static final int MICHEAL = 2;
	public static final int GABRIELLA = 3;
	public static final int THOMAS = 4;
	
	public static int newVar1;
	
	public static Character[] characters;
	private Item[] items;
	private static MainHall theMainHall;
	public static boolean isActive = false;
	public static String placeToGo = "house, throne room, dungeon";
	public static String peopleToTalk = "bob, ";
	
	private Item food;
	private Item dog;
	private Item pillar;
	
	private Character bob;
	private Character ragoolaman;
	private Character micheal;
	private Character gabriella;
	private Character thomas;
	/**
	 * @param args
	 */
	public static void setup() 
	{
		theMainHall = new MainHall();
		theMainHall.items = new Item[3];
		theMainHall.characters = new Character[5];
		theMainHall.generateItems();
		theMainHall.generateCharacters();
	}
	
	public static void main(String[] args) 
	{

	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : theMainHall.items)
		{
			toReturn = toReturn + item.getLongDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String getHelp() 
	{
		String help = "I see you're in a strange room? Maybe you should look around... \nMaybe you should also examine and use what you see...";
		return help;
	}
	
	public static String getItemShortDescs()
	{
		String toReturn = "";
		for(Item item : theMainHall.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsedPrint()
	{
		String Returned = "";
		for(Item item : theMainHall.items) 
		{
			Returned = Returned + item.itemUsedItem();
		}
		return itemUsedPrint();
	}
	
	public static Item getSpecItem(String i)
	{
		switch(i) 
		{
		case "food":
			newVar1 = 0;
			break;
		case "dog":
			newVar1 = 1;
			break;
		case "pillar":
			newVar1 = 2;
			break;
		}
		return theMainHall.items[newVar1];
	}
	public static Character[] getCharacters()
	{
		return MainHall.characters;
	}
	public static Character getSpecCharacter(String index)
	{
		int s;
		switch(index)
		{
		case "bob":
			s = BOB;
			break;
		case "ragoolaman":
			s = RAGOOLAMAN;
			break;
		case "micheal":
			s = MICHEAL;
			break;
		case "gabriella":
			s = GABRIELLA;
			break;
		case "thomas":
			s = THOMAS;
			break;
		default:
			s = RAGOOLAMAN;//change this
			break;
		}
		return MainHall.characters[s];
	}
	
	public static Item itemUsed(int index) 
	{
		return theMainHall.items[index];
	}
	
	private void generateItems()
	{
		food = new Item("Food", "There is random food on the table.", "Many generic foods crowd a table, you don't know what to call most of them!", "", "", "");
		dog = new Item("Dog", "There is a dog near a table.", "A dog with a golden coat. It's collar appears to say Molly on it.", "pet dog", "You pet a dog! It woofed happily", "");
		pillar = new Item("Pillar", "Many large marbly pillars support the ceiling", "", "unlock chest", "", "");
		items[FOOD] = food; // 0
		items[DOG] = dog; // 1
		items[PILLAR] = pillar; // 2
	}
	private void generateCharacters()
	{
		bob = new Character("Bob", "Steinenhoffnerlichtensteindugraffington", "Hey, you're the guy ragoolaman told me about right? I have a job for you...", "You see joe the guard over there? He took money from my shop. Get it back for me, and I'll make you a key for the castle.");//placeholder
		characters[BOB] = bob; //0
		ragoolaman = new Character("Prince Ragoolaman", "The ragoolific", "Hey, you're finally here! I was beginning to wonder if you would ever wake up! Now, to business. Among the crowds are four people: bob, micheal, gabriella, and thomas. \nThey will each help you in different ways. Talk to them, and they will give you tasks to complete in order to solicit their help. Talk to me when you have completed the quests.\n", "");
		characters[RAGOOLAMAN] = ragoolaman; //1
		micheal = new Character("Micheal", "The slow", "Oi, your that man ragoolaman spoke of eh? There is something funny aboot you indeed... I've got a job for yeh mate!", "You need to get thrown into jail... Start insulting guards, that'll do it. You need to retrieve my favourite knife from my cell. To get out you need to bend the bars. They are a very weak material.");
		characters[MICHEAL] = micheal;
		gabriella = new Character("Gabriella", "The poor", "Hullo there, the Prince spoke of yeh, I gots something yeh can do for meh.", "I am very hungry, steal me some food from that table o'er there, but hurry! Don't get caught!");
		characters[GABRIELLA] = gabriella;
		thomas = new Character("Thomas", "The back-stabber", "Eh? Who'sh o'er d'er eh? Ragoolaman'sh lad? I gotsh shome work fer yeh...", "My employer hash fired me... I want shome more ale to cope.");
		characters[THOMAS] = thomas;
	}

}
