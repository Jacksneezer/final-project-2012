import java.util.*;

public class Inventory
{
	public ArrayList<GettableItem> invItems = new ArrayList<GettableItem>();

	public Inventory()
	{
	}

	public void addItem(GettableItem a)
	{
		invItems.add(a);
	}

	public void removeItem(String s)
	{
		for (int i=0;i<invItems.size();i++)
			if (s.equalsIgnoreCase(invItems.get(i).getName()))
				invItems.remove(i);
	}

	public String toString()
	{
		String temp = "";
		if (invItems.size() == 0)
			return "You are currently holding:\nAbsolutely nothing!";
		/*for (GettableItem i: invItems)
		{
			temp+= i.getName();
		}
		return "You are currently holding:\n" + temp;*/
		if (invItems.size()==1)
			temp = invItems.get(0).getName().toUpperCase() + ".";
		if (invItems.size()==2)
			temp = invItems.get(0).getName().toUpperCase() + " and " + invItems.get(1).getName().toUpperCase() + ".";
		if (invItems.size()==3)
			temp = invItems.get(0).getName().toUpperCase() + ", " + invItems.get(1).getName().toUpperCase() + " and " + invItems.get(2).getName().toUpperCase() + ".";
		if (invItems.size()>3)
		{
			for (int x = 0; x<invItems.size()-2; x++)
			{
				temp+=invItems.get(x).getName().toUpperCase() + ", ";
			}
			temp+=(invItems.get(invItems.size()-2).getName().toUpperCase() + " and " + invItems.get(invItems.size()-1).getName().toUpperCase() + ".");
			//return "You are currently holding:\n" + temp;
		}
		return "You are currently holding:\n" + temp;
	}
}