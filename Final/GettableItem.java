public class GettableItem extends Item
{
	String complexDesc;

	public GettableItem(String n, String d, String c)
	{
		super.setName(n);
		super.setDesc(d);
		complexDesc = c;
	}

	public void act()
	{
		System.out.println("You grab the " + super.getName().toUpperCase() + ".");
		/*if (this.getName().equals("bat"))
			System.out.println("USE this on the FRONT DOOR to get out of your apartment!");*/
	}
}