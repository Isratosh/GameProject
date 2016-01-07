package project;

public class House {
	
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
		System.out.println(house.getItemLongDescs()); //temp
	}
	
	private String getItemLongDescs()
	{
		String toReturn = "";
		for(Item item : house.items)
		{
			toReturn = toReturn + item.getLongDesc() + "\n";
		}
		return toReturn;
	}
	
	private String getItemShortDescs()
	{
		String toReturn = "";
		for(Item item : house.items)
		{
			toReturn = toReturn + item.getShortDesc() + "\n";
		}
		return toReturn;
	}
	
	private void generateItems()
	{
		doorMat = new Item("Doormat", "It is an old looking doormat with the words \"Welcome\" written on it. You don't know why it is on the inside of the door.");
		table = new Item("Table", "It is a rickety old wooden table. One of the legs is shorter than the rest.");
		chest = new Item("Chest", "A wooden chest covered in dust with a large iron lock on the front. You don't know what's inside of it, and you don't remember where you left the key.");
		book = new Item("Book", "A dusty, old looking book with the spine falling off. You get the distinct feeling that you should read it.");
		items[0] = doorMat;
		items[1] = table;
		items[2] = chest;
		items[3] = book;
	}

}
