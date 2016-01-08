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
		System.out.println(getItemShortDescs()); //temp
		System.out.println(getItemLongDescs()); //temp
		System.out.println(getSpecItem(2).getLongDesc()); //temp
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
	
	public static String getItemShortDescs()
	{
		String toReturn = "";
		for(Item item : house.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	public static Item getSpecItem(int index)
	{
		return house.items[index];
	}
	
	private void generateItems()
	{
		doorMat = new Item("Doormat", "There is a doormat next to the exit.", "It is an old looking doormat with the words \"Welcome\" written on it. You don't know why it is on the inside of the door.");
		table = new Item("Table", "There is a wooden table across from the door.", "It is a rickety old wooden table. One of the legs is shorter than the rest.");
		chest = new Item("Chest", "A large wooden chest sits in the corner.", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.");
		book = new Item("Book", "An old book sits open on top of the table, inviting you to read it.", "A dusty, old looking book with the spine falling off. You get the distinct feeling that you should read it.");
		items[DOORMAT] = doorMat; // 0
		items[TABLE] = table; // 1
		items[CHEST] = chest; // 2
		items[BOOK] = book; // 3
	}

}
