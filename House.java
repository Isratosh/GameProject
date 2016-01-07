package project;

public class House {
	
	private items[] items;
	private boolean locked;
	private boolean hasKey;
	protected static House house;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		house = new House();
		house.items = {
				new items("doorMat", "It's a doormat.")
		}
		System.out.println(house.getItemDescs());
	}
	
	private String getItemDescs()
	{
		String toReturn = "";
		for(items item : house.items)
		{
			toReturn = toReturn + item.getDesc() + " ";
		}
		return toReturn;
	}

}
