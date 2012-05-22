public abstract class InteractItem extends Item
{
	boolean state = true;
	String togDesc = "";
	String actionText = "";
	String actionText2 = "";

	public void toggle()
	{
		if (state)
		{
			state = false;
			System.out.println(actionText);
		}
		else
		{
			state = true;
			System.out.println(actionText2);
		}
	}
}