import java.util.*;

public class ContainerItem extends InteractItem
{
	/*boolean state = true;
	String togDesc = "";
	String actionText = "";
	String actionText2 = "";*/
	ArrayList<Item> items = new ArrayList<Item>();
	boolean toggle;
//	Location loc;

	public ContainerItem(String n, String d, String a, ArrayList<Item> i)
	{
		super.setName(n);
		super.setDesc(d);
		actionText = a;
		actionText2 = a;
		for (Item totem: i)
			items.add(totem);
		toggle = false;
	//	loc = c;
	}

	public ContainerItem(String n, String d, String d2, String a, String a2, ArrayList<Item> i)
	{
		super.setName(n);
		super.setDesc(d);
		togDesc = d2;
		actionText = a;
		actionText2 = a2;
		for (Item totem: i)
			items.add(totem);
		toggle = true;
	//	loc = c;
	}

	public void act()
	{
		if (toggle)
		{
			if (state)
			{
				state = false;
				System.out.println(actionText);
				this.check();
			}
			else
			{
				state = true;
				System.out.println(actionText2);
			}
		}
		else
		{
			System.out.println(actionText);
			this.check();
		}
	}

	public void check()
	{
		String temp = "";
			if (items.size()==1)
				temp = items.get(0).getDesc() + ".";
			if (items.size()==2)
				temp = items.get(0).getName().toUpperCase() + " and " + items.get(1).getName().toUpperCase() + ".";
			if (items.size()==3)
				temp = items.get(0).getName().toUpperCase() + ", " + items.get(1).getName().toUpperCase() + " and " + items.get(2).getName().toUpperCase() + ".";
			if (items.size()>3)
			{
				for (int x = 0; x<items.size()-2; x++)
				{
					temp+=items.get(x).getName().toUpperCase() + ", ";
				}
				temp+=(items.get(items.size()-2).getName().toUpperCase() + " and " + items.get(items.size()-1).getName().toUpperCase() + ".");
			}
			if (items.size() == 0)
				System.out.println("Nothing in there.");
			else
				System.out.println("You see " + temp);
	}

	public String getDesc()
	{
		if (toggle)
		{
			if (state)
				return super.getDesc();
			else
				return togDesc;
		}
		else
			return super.getDesc();
	}

	public GettableItem getItem(String i)
	{
		GettableItem item = null;
		for (int x = 0; x<items.size(); x++)
		{
			if (items.get(x).getName().equalsIgnoreCase(i))
			{
				item = (GettableItem)items.get(x);
				items.remove(x);
				return item;
			}
		}
		return null;
	}


}