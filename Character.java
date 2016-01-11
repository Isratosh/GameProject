package project;

public class Character {

	private String name;
	private String firstName = "John";//default
	private String lastName = "Doe";//default
	private String questText = "Retrieve the pizza from Pizza Hut and return it to me. I will reward you with cookies and kisses."; //default
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character memeLord = new Character("Meme", "Lord", "Give me the dankest of memes.");
		System.out.println(memeLord.getFullName());
		System.out.println(memeLord.getQuestText());
		
	}

	public Character(String fName, String lName, String qText)
	{
		firstName = fName;
		lastName = lName;
		name = fName + " " + lName;
		questText = qText;
	}
	
	public Character(String fName, String lName)
	{
		firstName = fName;
		lastName = lName;
		name = fName + " " + lName;
	}
	
	public String getFullName()
	{
		return name;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getQuestText()
	{
		return questText;
	}
}
