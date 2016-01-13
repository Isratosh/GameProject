package project;


public class Dungeon {
	//items array index constants
	public static final int RAT = 0;
	public static final int DOOR = 1;
	public static final int SKULL = 2;
	public static int newVar1;
	public static String placeToGo = "house";
	
	private Item[] items;
	private boolean locked = true;
	private boolean hasKey = false;
	public static Dungeon theDungeon;
	public static boolean isActive = false;
	
	private Item rat;
	private Item door;
	private Item skull;
	private Item key;
	
	/**
	 * @param args
	 */
	public static void setup() 
	{
		theDungeon = new Dungeon();
		theDungeon.items = new Item[3];
		theDungeon.generateItems();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//theDungeon = new Dungeon();
		//theDungeon.items = new Item[3];
		//theDungeon.generateItems();
		//System.out.println(getItemShortDescs()); //temp
		//System.out.println(getItemLongDescs()); //temp
		//System.out.println(getSpecItem(2).getLongDesc()); //temp
	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : theDungeon.items)
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
		for(Item item : theDungeon.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsedPrint()
	{
		String Returned = "";
		for(Item item : theDungeon.items) 
		{
			Returned = Returned + item.itemUsedItem();
		}
		return itemUsedPrint();
	}
	
	public static Item getSpecItem(String newVar)
	{
		switch(newVar) 
		{
		case "rat":
			newVar1 = 0;
			break;
		case "door":
			newVar1 = 1;
			break;
		case "skull":
			newVar1 = 2;
			break;
		}
		return theDungeon.items[newVar1];
	}
	public static Item itemUsed(int index) 
	{
		return theDungeon.items[index];
	}
	
	private void generateItems()
	{
		rat = new Item("Rats", "Many rats squeaking in your cell.", "Huge rats lurk in the shadows, hopefully they aren't diseased.", "kick rat", "You killed it! The other rats hissed enragedly, and run away", "");
		door = new Item("Door", "A door made of iron bars", "A large door crafted of mid sized iron bars, they seem rusting and weak.", "bend bars", "You've bent the bars! Now you can leave, but better hurry! You don't want to get caught!", "");
		skull = new Item("Skulls", "Some skulls are on the floors", "The old white skulls appear to have been there for years, you shiver and wonder what killed it.", "unlock chest", "", "");
		items[RAT] = rat; // 0
		items[DOOR] = door; // 1
		items[SKULL] = skull; // 2
	}

}
