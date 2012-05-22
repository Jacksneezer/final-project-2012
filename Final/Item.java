public abstract class Item
{
	private String name;
	private String desc;

	public String getName()
	{
		return name;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setDesc(String d)
	{
		desc = d;
	}

	public abstract void act();
}