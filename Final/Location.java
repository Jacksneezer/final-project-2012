import java.util.*;

public class Location
{
	private String name;
	private String text;
	private ArrayList<String> valid = new ArrayList<String>();
	private ArrayList<Item> items = new ArrayList<Item>();

	public Location (String desc)
	{
		name = desc;
		if (name.equals("wake"))
		{
			text = "Your place is eerily quiet when you wake up. It's hard to place what exactly is wrong, besides that.\nThe muted sunlight filters through the blinds. "
				 +"Clothes are strewn across the floor, as usual. Ever since you got your new apartment, you haven't done any real cleaning. You should really get to cleaning that mess up."
				 +"\nOn the other hand, maybe a look out the window will clear that foreboding feeling out of your head.\nValid actions: look out the WINDOW, pick up your dirty CLOTHES";
			valid.add("window");
			valid.add("clothes");
		}
	}

	public Location (String n, String desc, ArrayList<String> v)
	{
		name = n;
		text = desc;
		for (String s: v)
		{
			valid.add(s);
		}
		//System.out.println(valid);
	}

	public Location (String n, String desc, ArrayList<String> v, ArrayList<Item> i)
	{
		name = n;
		text = desc;
		for (String s: v)
		{
			valid.add(s);
		}
		for (Item e: i)
		{
			items.add(e);
		}
	}

	public String getName()
	{
		return name;
	}

	public String deprecatedDesc()
	{
		return text;
	}

	public String getDesc()
	{
		if (items.size()!=0)
			//return text + "\nYou see here " + itemText();
			return "You see here " + itemText() + "\n" + text + "\n" + exitText();
		if (valid.size()!=0)
			return text + "\n" + exitText();
		return text;
	}

	public String itemText()
	{
		if (items.size()==1)
			return items.get(0).getDesc() + ".";
		if (items.size()==2)
			return items.get(0).getDesc() + " and " + items.get(1).getDesc() + ".";
		if (items.size()==3)
			return items.get(0).getDesc() + ", " + items.get(1).getDesc() + " and " + items.get(2).getDesc() + ".";
		if (items.size()>3)
		{
			String temp = "";
			for (int x = 0; x<items.size()-2; x++)
			{
				temp+=items.get(x).getDesc() + ", ";
			}
			temp+=(items.get(items.size()-2).getDesc() + " and " + items.get(items.size()-1).getDesc() + ".");
			return temp;
		}
		return "";
	}

	public String exitText()
	{
		String concat = "Valid exits: ";
		for (String s: valid)
		{
			concat+=s.toUpperCase()+", ";
		}
		return concat.substring(0,concat.length()-2);
	}

	public ArrayList<String> getValidComs()
	{
		return valid;
	}

	public ArrayList<Item> getItems()
	{
		return items;
	}

	public void changeLoc(String n, String t, ArrayList<String> v) //only used in the first part of the game, because it is inefficient and defeats the purpose of having a Location object in the first place
	{
		name = n;
		text = t;
		valid = v;
	}

/*	public void changeThings(String t, ArrayList<String> v)
	{
		text = t;
		for (String s: v)
		{
			valid.add(s);
		}
	}*/

	public void addExit(String s) //presumably would add an exit to the room; currently unused
	{
		valid.add(s);
	}

	public void removeItem(String l) //used when an item is added to a player's inventory and as such is removed from the room.
	{
		for (int i = 0; i<items.size(); i++)
		{
			if (l.equals(items.get(i).getName()))
				items.remove(i);
		}
	}

	public void addItem(Item i)
	{
		items.add(i);
	}
}