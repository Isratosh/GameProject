package project;

public class House {
	//items array index constants
	public static final int DOORMAT = 0;
	public static final int TABLE = 1;
	public static final int CHEST = 2;
	public static final int BOOK = 3;
	public static final int SILVER = 4;
	public static final int SWORD = 5;
	public static final int POISON = 6;
	public static final int GOLD = 7;
	public static int newVar1;
	public static String placeToGo = "main hall";
	
	private Item[] items;
	private boolean locked = true;
	public static boolean hasKey = false;
	static House theHouse;
	public static boolean isActive = false;
	
	private Item doorMat;
	private Item table;
	private Item chest;
	private Item silverKey;
	private Item goldKey;
	private Item doorKey;
	private Item sword;
	private Item poison;
	private Item book;
	
	/**
	 * @param args
	 */
	public static void setup() 
	{
		theHouse = new House();
		theHouse.items = new Item[8];
		theHouse.generateItems();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//house = new House();
		//house.items = new Item[4];
		//house.generateItems();
		//System.out.println(getItemShortDescs()); //temp
		//System.out.println(getItemLongDescs()); //temp
		//System.out.println(getSpecItem(2).getLongDesc()); //temp
	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : theHouse.items)
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
		for(Item item : theHouse.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsedPrint()
	{
		String Returned = "";
		for(Item item : theHouse.items) 
		{
			Returned = Returned + item.itemUsedItem();
		}
		return itemUsedPrint();
	}
	
	public static Item getSpecItem(String newVar)
	{
		switch(newVar) 
		{
		case "doormat":
			newVar1 = 0;
			break;
		case "table":
			newVar1 = 1;
			break;
		case "chest":
			newVar1 = 2;
			break;
		case "book":
			newVar1 = 3;
			break;
		case "key":
			newVar1 = 4;
			break;
		case "sword":
			newVar1 = 5;
			break;
		case "poison":
			newVar1 = 6;
			break;
		}
		return theHouse.items[newVar1];
	}
	public static Item itemUsed(int index) 
	{
		return theHouse.items[index];
	}
	
	private void generateItems()
	{
		doorMat = new Item("Doormat", "There is a doormat next to the exit.", "It is an old looking doormat with the words \"Welcome\" written on it. You don't know why it is on the inside of the door.", "look under mat", "You found the key!\n", "");
		table = new Item("Table", "There is a wooden table across from the door.", "It is a rickety old wooden table. One of the legs is shorter than the rest.", "", "", "");
		chest = new Item("Chest", "A large wooden chest sits in the corner.", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.", "unlock chest", "", "");
		goldKey = new Item("GoldKey", "A large gold key sits inside the chest.", "", "", "", "");
		silverKey = new Item("SilverKey", "A small silver key laying under the mat.", "A small key, too small for the door, but big enough for the chest.", "take key", "You found the silver key!", "");
		book = new Item("Book", "An old book sits open on top of the table, inviting you to read it.", "A dusty, old looking book with the spine falling off. You get the distinct feeling that you should read it.", "read book", "The title of the book is \"To Kill a King\" It was written by Prince Ragoolaman\nChapter 1: The Games Begin\nThe controls are simply your keyboard. What the game tells you doesn't provide rigid options. You type things that you think could work, and if they don't you will be notified.\nThe commands are as follows. To return to the main menu, simply type \"/exit\" And to get vague hints one just needs to type \"/help\"\nThe remainder of the princes novel has been ripped out, hence the broken spine.\nAll that remains past the first chapter is the final page, it has the words \"Meet me at the castle when you arrive. regards, P.R. \nP.S. I left your key under the doormat!\" scrawled into it.\n \nYou can't remember who P.R. is, but you feel like they is important, and that you should meet them with all haste!\nYou suddenly remember that you leave your house by typing \"leave (destination)\"however, you shouldn't leave here without your sword... Now where did you leave it again?\n", "");
		poison = new Item("Poison", "", "", "", "", "");
		sword = new Item("Sword", "A sharp sword in the chest.", "A beautiful sword with a slight backwards curve along the blade, It looks", "", "", "");
		items[DOORMAT] = doorMat; // 0
		items[TABLE] = table; // 1
		items[CHEST] = chest; // 2
		items[BOOK] = book; // 3
		items[SILVER] = silverKey; //4
		items[POISON] = poison; //5
		items[SWORD] = sword; // 6
		items[GOLD] = goldKey; //7
		
	}

}
