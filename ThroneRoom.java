package project;


public class ThroneRoom {
	//items array index constants
	public static final int FOOD = 0;
	public static final int DOG = 1;
	public static final int PILLAR = 2;
	public static final int THRONEDOOR = 3;
	public static final int ISRATOSH = 0;
	
	public static int newVar1;
	
	public static Character[] characters;
	private Item[] items;
	private static ThroneRoom theThroneRoom;
	public static boolean isActive = false;
	public static String placeToGo = "main hall";
	
	private Item food;
	private Item dog;
	private Item pillar;
	
	private Character isratosh;
	/**
	 * @param args
	 */
	public static void setup() 
	{
		theThroneRoom = new ThroneRoom();
		theThroneRoom.items = new Item[3];
		theThroneRoom.characters = new Character[3];
		theThroneRoom.generateItems();
		theThroneRoom.generateCharacters();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		setup();
		System.out.println(theThroneRoom.isratosh.getFullName());
	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : theThroneRoom.items)
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
		for(Item item : theThroneRoom.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsedPrint()
	{
		String Returned = "";
		for(Item item : theThroneRoom.items) 
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
		return theThroneRoom.items[newVar1];
	}
	public static Character[] getCharacters()
	{
		return ThroneRoom.characters;
	}
	public static Character getSpecCharacter(String index)
	{
		int s;
		switch(index)
		{
		case "bob":
			s = ISRATOSH;
			break;
		default:
			s = ISRATOSH;//change this
			break;
		}
		return ThroneRoom.characters[s];
	}
	
	public static Item itemUsed(int index) 
	{
		return theThroneRoom.items[index];
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
		isratosh = new Character("King Isratosh", "The Gluttonous", "Welcome... To your DOOM (ayylmao)", "");//placeholder
		characters[ISRATOSH] = isratosh; //0
			}

}
