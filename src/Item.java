package project;

public class Item {

	private String longDesc = "It doesn't seem to look like anything you've seen before."; // Default description.
	private String name = "You don't know what to call it."; //Default name.
	private String shortDesc = "It looks generic."; //Default short description.
	private String itemUsedPrint = "The item has no purpose.";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Item(String defName, String defShortDesc, String defLongDesc, String itemUse, String usePrint, String examPrint)
	{
		longDesc = defLongDesc;
		name = defName;
		shortDesc = defShortDesc;
		itemUsedPrint = usePrint;
	}
	
	public void changeLongDesc(String newDesc)
	{
		longDesc = newDesc;
	}
	
	public void changeShortDesc(String newDesc)
	{
		shortDesc = newDesc;
	}
	
	public void changeName(String newName)
	{
		name = newName;
	}
	
	public String getLongDesc()
	{
		return longDesc;
	}
	
	public String getShortDesc()
	{
		return shortDesc;
	}
	
	public String getName()
	{
		return name;
	}
	public String itemUsedItem() 
	{
		return itemUsedPrint;
	}
	
}
