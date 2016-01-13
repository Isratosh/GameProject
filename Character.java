package project;

public class Character {

	private String name;
	private String firstName = "John";//default
	private String lastName = "Doe";//default
	private String convText = "Hello!";//default
	private String questText = "Retrieve the pizza from Pizza Hut and return it to me. I will reward you with cookies and kisses."; //default
	private boolean offering = false;
	private boolean accepted = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	}

	public Character(String fName, String lName, String cText, String qText)
	{
		firstName = fName;
		lastName = lName;
		name = fName + " " + lName;
		questText = qText;
		convText = cText;
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
	public String getConvText()
	{
		return convText;
	}
	public void talkTo()
	{
		if(questText != null)
		{
			offering = true;
		}
	}
	public void acceptQuest()
	{
		offering = false;
		accepted = true;
	}
	public boolean isOffering()
	{
		return offering;
	}
	public boolean isAccepted()
	{
		return accepted;
	}
}
