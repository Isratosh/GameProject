package project;

public class items {

	private String desc = "It doesn't seem to look like anything you've seen before."; // Default description.
	private String name = "You don't know what to call it."; //Default name.
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public items(String defName, String defDesc)
	{
		desc = defDesc;
		name = defName;
	}
	
	public void changeDesc(String newDesc)
	{
		desc = newDesc;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getName()
	{
		return name;
	}
	
}
