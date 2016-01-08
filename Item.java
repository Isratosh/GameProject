package project;

public class Item {

	private String longDesc = "It doesn't seem to look like anything you've seen before."; // Default description.
	private String name = "You don't know what to call it."; //Default name.
	private String shortDesc = "It looks generic."; //Default short description.
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Item(String defName, String defShortDesc, String defLongDesc)
	{
		longDesc = defLongDesc;
		name = defName;
		shortDesc = defShortDesc;
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
	
}
