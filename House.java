package project;

public class House {
	//items array index constants
	public static final int DOORMAT = 0;
	public static final int TABLE = 1;
	public static final int CHEST = 2;
	public static final int BOOK = 3;
	public static final int KEY = 4;
	public static final int SWORD = 5;
	public static final int POISON = 6;	
	
	private Item[] items;
	private boolean locked = true;
	private boolean hasKey = false;
	private static House house;
	public static boolean isActive = true;
	
	private Item doorMat;
	private Item table;
	private Item chest;
	private Item key;
	private Item sword;
	private Item poison;
	private Item book;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		house = new House();
		house.items = new Item[4];
		house.generateItems();
		//System.out.println(getItemShortDescs()); //temp
		//System.out.println(getItemLongDescs()); //temp
		//System.out.println(getSpecItem(2).getLongDesc()); //temp
	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : house.items)
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
		for(Item item : house.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsePrint()
	{
		String Returned = "";
		for(Item item : house.items) 
		{
			Returned = Returned + item.itemUsedItem();
		}
		return itemUsePrint();
	}
	
	public static Item getSpecItem(int index)
	{
		return house.items[index];
	}
	public static Item itemUsed(int index) 
	{
		return house.items[index];
	}
	
	private void generateItems()
	{
		doorMat = new Item("Doormat", "There is a doormat next to the exit.", "It is an old looking doormat with the words \"Welcome\" written on it. You don't know why it is on the inside of the door.", "look under", "", "");
		table = new Item("Table", "There is a wooden table across from the door.", "It is a rickety old wooden table. One of the legs is shorter than the rest.", "", "", "");
		chest = new Item("Chest", "A large wooden chest sits in the corner.", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.", "unlock chest", "", "");
		book = new Item("Book", "An old book sits open on top of the table, inviting you to read it.", "A dusty, old looking book with the spine falling off. You get the distinct feeling that you should read it.", "read book", "The title of the book is \"To Kill a King\" It was written by Prince Ragoolaman\nChapter 1: The Games Begin\nThe controls are simply your keyboard. What the game tells you doesn't provide rigid options. You type things that you think could work, and if they don't you will be notified.\nThe commands are as follows. To return to the main menu, simply type \"/exit\" And to get vague hints one just needs to type \"/help\"\nThe remainder of the princes novel has been ripped out, hence the broken spine.\nAll that remains past the first chapter is the final page, it has the words \"Meet me at the castle when you arrive. regards, P.R. \nP.S. I left your key under the doormat!\" scrawled into it.\n \nYou can't remember who P.R. is, but you feel like they is important, and that you should meet them with all haste!\nYou suddenly remember that you leave your house by typing \"leave (destination)\"however, you shouldn't leave here without your sword... Now where did you leave it again?\n", "");
		items[DOORMAT] = doorMat; // 0
		items[TABLE] = table; // 1
		items[CHEST] = chest; // 2
		items[BOOK] = book; // 3
	}

}
