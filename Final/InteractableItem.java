public class InteractableItem extends InteractItem
{
	/*boolean state = true;
	String togDesc;
	String actionText;
	String actionText2;*/

	public InteractableItem (String n, String d, String d2, String a, String a2)
	{
		super.setName(n);
		super.setDesc(d);
		togDesc = d2;
		actionText = a;
		actionText2 = a2;
	}

	public void act()
	{
		toggle();
	}

	public String getDesc()
	{
		if (state)
			return super.getDesc();
		else
			return togDesc;
	}
}