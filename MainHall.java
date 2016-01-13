package project;


public class MainHall {
	//items array index constants
	public static final int FOOD = 0;
	public static final int DOG = 1;
	public static final int PILLAR = 2;
	public static final int THRONEDOOR = 3;
	public static final int BOB = 0;
	
	public static int newVar1;
	
	public static Character[] characters;
	private Item[] items;
	private static MainHall theMainHall;
	public static boolean isActive = false;
	public static String placeToGo = "house, throne room, dungeon";
	
	private Item food;
	private Item dog;
	private Item pillar;
	
	private Character bob;
	
	/**
	 * @param args
	 */
	public static void setup() 
	{
		theMainHall = new MainHall();
		theMainHall.items = new Item[3];
		theMainHall.characters = new Character[3];
		theMainHall.generateItems();
		theMainHall.generateCharacters();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		setup();
		System.out.println(theMainHall.bob.getFullName());
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
	public static Character getSpecCharacter(int index)
	{
		return MainHall.characters[index];
	}
	
	public static Item itemUsed(int index) 
	{
		return theMainHall.items[index];
	}
	
	private void generateItems()
	{
		food = new Item("Food", "There is random food on the table.", "Many generic foods crowd a table, you don't know what to call most of them!", "", "", "");
		dog = new Item("Dog", "There is a dog near a table.", "A dog with a golden coat. It's collar appears to say Molly on it.", "pet dog", "You pet a dog! It woofed happily", "");
		pillar = new Item("Pillar", "A large wooden chest sits in the corner.", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.", "unlock chest", "", "");
		items[FOOD] = food; // 0
		items[DOG] = dog; // 1
		items[PILLAR] = pillar; // 2
	}
	private void generateCharacters()
	{
		bob = new Character("Bob", "Steinenhoffnerlichtensteindugraffington the Third", "Welcome to Castle Isratosh, I'll be your host for tonight. Would you like a table?", "Ah, perfect. Just follow me over here and I'll find one for you!");//placeholder
		characters[BOB] = bob; //0
	}

}
