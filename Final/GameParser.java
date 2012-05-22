import java.util.*;

public class GameParser
{
	private boolean windowOpened = false;
	private boolean clothesDug = false;
	private boolean doorOpened = false;
	private boolean go = false;

	//This is the game runner for the first part of the game (the bedroom part). It's pretty inefficient, and doesn't really follow OOP rules.
	public GameParser()
	{
	}

	public void parse(Location c, String r, Player p)
	{
/*		if (r.equalsIgnoreCase("look"))
		{
			System.out.println(c.getDesc());
			return;
		} //place this at the end of this list at some point.*/
		if (r.equalsIgnoreCase("stats"))
		{
			System.out.println(p);
			return;
		}
		if (r.equals("41149512125"))
		{
			System.out.println("You checking out my code, or something? Congrats, you got a special response. It's not like I like you or anything, alright?");
			return;
		}
		if (r.equalsIgnoreCase("commands")||r.equalsIgnoreCase("help"))
		{
			System.out.println("Universal commands that will always work are LOOK, which refreshes the current location, and STATS.");
			return;
		}
		boolean validity = false;
		for (String s: c.getValidComs())
		{
			if (r.equalsIgnoreCase(s) || r.equalsIgnoreCase("exit") || r.equalsIgnoreCase("look"))
				validity = true;
		}
		if (validity == false)
		{
			int idle = (int)(Math.random()*5 + 1);
			if (idle == 1)
				System.out.println("You shift in place, unsure what to do.");
			if (idle == 2)
				System.out.println("You wonder what sound a potato makes.");
			if (idle == 3)
				System.out.println("If a tree falls in a forest and no one is around, does it make a sound?");
			if (idle == 4)
				System.out.println("You can't do that!");
			if (idle == 5)
				System.out.println("That's ridiculous. That's not even funny.");
			return;
		}
		if (c.getName().equals("wake"))
		{
			if (r.equalsIgnoreCase("window") && !windowOpened)
			{
				this.act("window",c);
				windowOpened = true;
				return;
			}
			if (r.equalsIgnoreCase("clothes")&&!clothesDug)
			{
				this.act("clothes",c);
				clothesDug=true;
				return;
			}

		}
		if ((c.getName().equals("window") || c.getName().equals("window2"))&&!clothesDug)
		{
			if (r.equalsIgnoreCase("look"))
			{
				this.act("window2",c);
				return;
			}
			if (r.equalsIgnoreCase("clothes")&&!clothesDug)
			{
				this.act("clothes",c);
				clothesDug=true;
				return;
			}
			if (r.equalsIgnoreCase("clothes")&&clothesDug)
			{
				this.act("clothes2",c);
				return;
			}
		}
		if ((c.getName().equals("window2")||c.getName().equals("window"))&&clothesDug)
		{
			if (r.equalsIgnoreCase("look"))
			{
				this.act("window2",c);
				return;
			}
			if (r.equalsIgnoreCase("clothes")&&!clothesDug)
			{
				this.act("clothes",c);
				clothesDug=true;
				return;
			}
			if (r.equalsIgnoreCase("clothes")&&clothesDug)
			{
				this.act("clothes2",c);
				return;
			}
			if (r.equalsIgnoreCase("door"))
			{
				//this.act("door",c);
				doorOpened = true;
				//System.out.println("You've reached the end of the first part of the game! Congrats.\nType LOOK to return to the pile of clothes, or CONTINUE to continue the game.");
				System.out.println("Once you leave your bedroom, you don't think you'll come back. You have a mystery to figure out!\nType CONTINUE to continue the game, or LOOK if you seriously want to keep looking around your room.");
				return;
			}
		}
		if (c.getName().equals("clothes") || c.getName().equals("clothes2"))
		{
			if (r.equalsIgnoreCase("window")&&!windowOpened)
			{
				this.act("window",c);
				windowOpened = true;
				return;
			}
			if (r.equalsIgnoreCase("window")&&windowOpened)
			{
				this.act("window2",c);
				return;
			}
			if (r.equalsIgnoreCase("door"))
			{
				//this.act("door",c);
				doorOpened = true;
				//System.out.println("You've reached the end of the first part of the game! Congrats.\nType LOOK to return to the pile of clothes, or CONTINUE to continue the game.");
				System.out.println("Once you leave your bedroom, you don't think you'll come back. You have a mystery to figure out!\nType CONTINUE to continue the game, or LOOK if you seriously want to keep looking around your room.");
				return;
			}
			this.act("clothes2",c);
			return;

		}


		if (r.equalsIgnoreCase("look"))
		{
			System.out.println(c.deprecatedDesc());
			return;
		}
	}

	public String infodump(String junk)
	{
		if (junk.equals("window")&&!clothesDug)
		{
			return "You look out the window.\nStreets are empty. That's great. You go to close the blinds again when your eye catches the clock sitting by your bedside table. 10:30 AM. You close the blinds.\n"
				+"Wait, what?\nThe streets are empty. At 10:30 in the morning, on a weekday.\nThe foreboding feeling gets greater.\nValid actions: pick up your dirty CLOTHES";
		}
		if (junk.equals("window")&&clothesDug)
		{
			return "You look out the window.\nStreets are empty. That's great. You go to close the blinds again when your eye catches the clock sitting by your bedside table. 10:30 AM. You close the blinds.\n"
				+"Wait, what?\nThe streets are empty. At 10:30 in the morning, on a weekday.\nThe foreboding feeling gets greater.\nValid actions: assess your dirty CLOTHES again, leave via the DOOR";
		}
		if (junk.equals("window2")&&!clothesDug)
		{
			return "You've already looked out the window. It's still empty out there. This is really weird.\nValid actions: pick up your dirty CLOTHES";
		}
		if (junk.equals("window2")&&clothesDug)
		{
			return "You've already looked out the window. It's still empty out there. This is really weird.\nValid actions: assess your dirty CLOTHES again, leave via the DOOR";
		}
		if (junk.equals("clothes"))
		{
			return "You pick up your clothes. This is pretty disgusting. You should have done this earlier; you get the feeling this isn't the best time "
				+"for cleaning, especially with that foreboding feeling still sitting in the pit of your stomach.\nThere's a soft clinking sound as your "
				+"car keys drop out of the battered jeans you just picked up.\nOh. Those could be useful.\nValid actions: look out the WINDOW, leave via the DOOR";
		}
		if (junk.equals("clothes2"))
		{
			return "You're not touching those clothes again. You haven't got the time or the patience right now.\nValid actions: look out the WINDOW, leave via the DOOR";
		}
		return "";

	}

	public ArrayList<String> infodump2(String junk)
	{
		ArrayList<String> temp = new ArrayList<String>();
		if ((junk.equals("window") || junk.equals("window2"))&& !clothesDug)
		{
			temp.add("clothes");
			return temp;
		}
		if ((junk.equals("window") || junk.equals("window2"))&&clothesDug)
		{
			temp.add("clothes");
			temp.add("door");
			return temp;
		}
		if (junk.equals("clothes")||junk.equals("clothes2"))
		{
			temp.add("window");
			temp.add("door");
			return temp;
		}
		return temp;
	}

	public void act(String loc, Location c)
	{
		c.changeLoc(loc, infodump(loc), infodump2(loc));
		System.out.println(c.deprecatedDesc());
	}

	public boolean getDoor()
	{
		return doorOpened;
	}
}