package project;


public class MainHall {
	//items array index constants
	public static final int FOOD = 0;
	public static final int DOG = 1;
	public static final int PILLAR = 2;
	public static final int THRONEDOOR = 3;
	public static int newVar1;
	
	private Item[] items;
	private static MainHall MainHall;
	public static boolean isActive = true;
	
	private Item food;
	private Item dog;
	private Item pillar;
	
	/**
	 * @param args
	 */
	public static void setup() 
	{
		MainHall = new MainHall();
		MainHall.items = new Item[3];
		MainHall.generateItems();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainHall = new MainHall();
		MainHall.items = new Item[4];
		MainHall.generateItems();
		System.out.println(getItemShortDescs()); //temp
		System.out.println(getItemLongDescs()); //temp
		//System.out.println(getSpecItem(dog).getLongDesc()); //temp
	}
	
	public static String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : MainHall.items)
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
		for(Item item : MainHall.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static String itemUsedPrint()
	{
		String Returned = "";
		for(Item item : MainHall.items) 
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
		return MainHall.items[newVar1];
	}
	public static Item itemUsed(int index) 
	{
		return MainHall.items[index];
	}
	
	private void generateItems()
	{
		food = new Item("Food", "There is random food on the table.", "Many generic foods crowd a table, you don't know what to call most of them!", "pet dog", "You pet a dog! It woofed happily", "");
		dog = new Item("Dog", "There is a dog near a table.", "A dog with a golden coat. It's collar appears to say Molly on it.", "", "", "");
		pillar = new Item("Pillar", "A large wooden chest sits in the corner.", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.", "unlock chest", "", "");
		items[FOOD] = food; // 0
		items[DOG] = dog; // 1
		items[PILLAR] = pillar; // 2
	}

}
