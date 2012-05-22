import java.util.*;

public class GameRunner
{
	private ArrayList<Location> locs = new ArrayList<Location>();
	private Player mainCharacter;
	//private Reaction reaction = new Reaction();

	//This is the game runner for the rest of the game. Hopefully it's more efficient/elegant.
	public GameRunner (Player p)
	{
		mainCharacter = p;
	}

	//generates all the locations in the game
	public void genLocations()
	{
		ArrayList<String> exits = new ArrayList<String>();
		ArrayList<Item> things = new ArrayList<Item>();
		ArrayList<Item> inthings = new ArrayList<Item>();
		exits.add("hallway");
		//locs.add(new Location("bedroom", "This is the door to your bedroom. Honestly, there's no point going back in there.\nRooms nearby: HALLWAY", exits));
		locs.add(new Location("bedroom", "This is the door to your bedroom. Honestly, there's no point going back in there.", exits));
		inthings.add(new GettableItem("key", "a KEY", "This is the storage room key. What was it doing in the toilet?"));
		things.add(new ContainerItem("toilet", "the TOILET lid, which is down", "the TOILET lid, which is up", "You slam the toilet lid up. In the process, you glance in the toilet.", "You slam the toilet lid down.", inthings));
		inthings.remove(0);
		inthings.add(new GettableItem("towel", "a striped TOWEL", "This is a towel, with red and white stripes. It's quite fuzzy."));
		things.add(new ContainerItem("bin", "a BIN", "You glance in the bin.", inthings));
		//locs.add(new Location("bathroom", "The bathroom is as clean as it always is. Seriously, all your cleaning skills go into this one room.\nRooms nearby: HALLWAY", exits, things));
		locs.add(new Location("bathroom", "The bathroom is as clean as it always is. Seriously, all your cleaning skills go into this one room.", exits, things));
		//locs.get(2).addItem()
		inthings = new ArrayList<Item>();
		things = new ArrayList<Item>();

		things.add(new InteractableItem("door", "the locked DOOR", "the locked DOOR", "The door's locked. You rattle the doorknob, but nothing happens.", "You rattle the doorknob again. The door's still locked."));

		//locs.add(new Location("storage", "This is the door to the storage room. It seems locked. Where'd you put that key?\nRooms nearby: HALLWAY", exits, things));
		locs.add(new Location("storage door", "Inside this door is the storage room, where you keep all your stuff.", exits, things));

		things = new ArrayList<Item>();
		exits = new ArrayList<String>();
		exits.add("storage door");
		things.add(new GettableItem("bat", "your trusty baseball BAT", "This is your trusty baseball bat. Just holding it gives the unmistakable whiff of nostalgic childhood."));
		locs.add(new Location("storage", "You're inside the storage room now. There's a ton of junk lying around here. Most of it isn't useful.", exits, things));
		things = new ArrayList<Item>();
		exits = new ArrayList<String>();
		exits.add("hallway");

		exits.add("kitchen");
		//locs.add(new Location("dining", "This is your dining room. It consists of an empty wooden table and a chair.\nRooms nearby: HALLWAY, KITCHEN", exits));
		locs.add(new Location("dining", "This is your dining room. It consists of an empty wooden table and a chair.", exits));
		exits.remove(1);
		exits.add("dining");
		//ArrayList<Item> things = new ArrayList<Item>();
		things.add(new InteractableItem("blender", "a simple BLENDER on the counter which seems to be empty", "a simple BLENDER on the floor", "You knock the blender onto the floor. Good job, "+mainCharacter.getFirst()+".", "You"
			+ " set the blender back up. You'll probably end up knocking it over again."));
		//things.add(new GettableItem("item", "a bland ITEM", "This item doesn't seem to have any notable attributes, and doesn't at all look useful. In fact, it could just be a placeholder."));
		//things.add(new GettableItem("invitem", "a bland INVITEM", "This item doesn't seem to have any notable attributes, and doesn't at all look useful. In fact, it could just be a placeholder."));
		//things.add(new GettableItem("gahitem", "a bland GAHITEM", "This item doesn't seem to have any notable attributes, and doesn't at all look useful. In fact, it could just be a placeholder."));
		exits.add("pantry");
/*		things.add(new GettableItem("yeast", "a box of YEAST", "This is a box of yeast that you use for cooking. It's alive! IT'S ALIIIIIVE!"));
		things.add(new GettableItem("sugar", "a bag of SUGAR", "This is a bag of sugar that you use for cooking. You have a bad habit for using too much of this in your cookies."));
		things.add(new GettableItem("flour", "a plastic container of FLOUR", "This is a container of flour that you use for cooking. You would give multiple of these to your significant other, but that's too punny for you."));
		things.add(new GettableItem("glass bowl", "a empty GLASS BOWL", "This is a empty glass bowl that you could probably use for mixing things."));*/
		things.add(new InteractableItem("sink", "a SINK which has both hot and cold taps", "a SINK which has both hot and cold taps", "You turn on the water, using the cold tap. Strangely, the water is "
			+ "warm. Rotten housing accommodations.", "You turn on the water, using the hot tap this time. The water is still warm. Rotten housing accommodations."));
		things.add(new InteractableItem("oven", "an OVEN which is closed", "an OVEN which is open", "You open the oven.", "You close the oven."));

		/*locs.add(new Location("kitchen", "This is your kitchen. Someone seems to have stolen all your knives. This would be a little concerning, "
			+ "if you weren't already worried about other things.\nRooms nearby: DINING, HALLWAY", exits, things));*/
		locs.add(new Location("kitchen", "This is your kitchen. Someone seems to have stolen all your knives. This would be a little concerning, "
			+ "if you weren't already worried about other things.", exits, things));
		exits.remove(2);
		exits.remove(0);
		exits.add("bedroom");
		exits.add("bathroom");
		//exits.add("storage");
		exits.add("storage door");
		exits.add("kitchen");
		//locs.add(new Location ("hallway", "This is the hallway of your apartment.\nNothing interesting is going on here.\nRooms nearby: BEDROOM, BATHROOM, STORAGE, DINING, KITCHEN", exits));
		things = new ArrayList<Item>();
		/*things.add(new InteractableItem("front door", "your FRONT DOOR, which is locked", "your FRONT DOOR, which is still locked", "You reach to unlock your front door, but then realize maybe you should find a weapon to defend yourself with.", "You "
			+ "still don't have a weapon to brave the streets outside. Getting one might be a good idea."));*/
		things.add(new InteractableItem("padlock", "multiple chains and a PADLOCK which bar your front door", "multiple chains and a stubborn PADLOCK which bar your front door", "You hammer on the padlock to try to "
			+ "get out, but it's futile.", "Despite the futility of your efforts, you slam your fist on the padlock, trying to break it open. You'll need a better weapon."));
		locs.add(new Location ("hallway", "This is the hallway of your apartment.\nNothing interesting is going on here.", exits, things));

		exits = new ArrayList<String>();
		things = new ArrayList<Item>();
		//exits.add("hallway");
		locs.add(new Location("outside", "You stand alone, outside, your baseball bat on your shoulder. The streets are barren, and the wind whistles softly as it beats against the sides of abandoned buildings. Not a light is on. "
			+ "\nYou feel that unease again, tugging at you. What kind of strange events must have happened while you were sleeping, to cause such a change in this normally bustling city?"
			+ "\n\nYou don't know, but you sense that you're about to find out."
			+ "\n\nIf you've reached this point, you've reached the end of the game, as of now. Congratulations.", exits));
		exits.add("kitchen");
		things.add(new GettableItem("yeast", "a box of YEAST", "This is a box of yeast that you use for cooking. It's alive! IT'S ALIIIIIVE!"));
		things.add(new GettableItem("sugar", "a bag of SUGAR", "This is a bag of sugar that you use for cooking. You have a bad habit for using too much of this in your cookies."));
		things.add(new GettableItem("flour", "a plastic container of FLOUR", "This is a container of flour that you use for cooking. You would give multiple of these to your significant other, but that's too punny for you."));
		things.add(new GettableItem("glass bowl", "a empty GLASS BOWL", "This is a empty glass bowl that you could probably use for mixing things."));
		locs.add(new Location("pantry", "This is the pantry, where all the cooking ingredients are. For some reason, all the prepared food is gone, but there are still boxes and bags of raw materials lying around.", exits, things));
	}

	public Location findLocation(String s)
	{
		for (Location l: locs)
		{
			if (l.getName().equalsIgnoreCase(s))
				return l;
		}
		return null; //should not ever happen
	}

	public Location run(Location c, String r)
	{
		Reaction reaction = new Reaction(c, mainCharacter);

		//general options check
		if (r.equalsIgnoreCase("stats"))
		{
			System.out.println(mainCharacter);
			return c;
		}
		if (r.equalsIgnoreCase("inv")||r.equalsIgnoreCase("inventory"))
		{
			System.out.println(mainCharacter.getInventory());
			return c;
		}
		if (r.equals("41149512125"))
		{
			System.out.println("You checking out my code, or something? Congrats, you got a special response. It's not like I like you or anything, alright?");
			return c;
		}
		if (r.equalsIgnoreCase("commands")||r.equalsIgnoreCase("help"))
		{
			System.out.println("Universal commands that will always work are LOOK, which refreshes the current location, and STATS. Check your inventory with INVENTORY or INV.");
			System.out.println("Remove items from containers with GET <item> FROM <container>. Use items together with USE <item> WITH <item>.");
			System.out.println("To examine items that you have in your inventory, EXAMINE <item>. To eat items, EAT <item>. To drop items, DROP <item>.");
			return c;
		}

		ArrayList<GettableItem> inventory = mainCharacter.getInventory().invItems;
		if (r.length()>=8 && r.substring(0,8).equalsIgnoreCase("examine "))
		{
			if (inventory.size()==0)
			{
				System.out.println("You don't have anything in your inventory; how can you examine anything?");
				return c;
			}
			for (GettableItem a: inventory)
			{
				if (r.substring(8).equalsIgnoreCase(a.getName()))
				{
					System.out.println("You examine the " + a.getName().toUpperCase() + ". " + a.complexDesc);
					return c;
				}
			}
			System.out.println("You try to examine the \"" + r.substring(8).toUpperCase() + "\" but you either don't have that or you're just messing around.");
			return c;
		}

		if (r.length()>=4 && r.substring(0,4).equalsIgnoreCase("eat "))
		{
			boolean hasItem = false;
			for (GettableItem a: inventory)
			{
				if (r.substring(4).equalsIgnoreCase("baguette")&&a.getName().equals("baguette"))
				{
					System.out.println("You bite into the baguette, savoring every bite until it's gone. Wait, what's this?");
					System.out.println("You find a SILVER KEY inside the BAGUETTE!");
					mainCharacter.addItem(new GettableItem("silver key", "a SILVER KEY", "This is your silver key to the front door. It must have been inside one of the containers"
						+ " of the ingredients you used to make the baguette. What are the chances of that?"));
					mainCharacter.removeItem("baguette");
					return c;
				}
				if (r.substring(4).equalsIgnoreCase(a.getName()))
					hasItem = true;
			}
			if (hasItem)
			{
				System.out.println("You make to take a bite out of the " + r.substring(4).toUpperCase() + ", but then realize that is an incredibly stupid idea.");
				return c;
			}
			else
			{
				System.out.println("You can't eat that, simply because you don't have it.");
				return c;
			}
		}

		if (r.length()>=5 && r.substring(0,5).equalsIgnoreCase("drop "))
		{
			for (GettableItem a: inventory)
			{
				if (r.substring(5).equalsIgnoreCase(a.getName()))
				{
					System.out.print("You drop the " + r.substring(5).toUpperCase() + " on the floor. ");
					if (a.getName().equalsIgnoreCase("glass bowl"))
						System.out.println("Er, gently.");
					else if (a.getName().equalsIgnoreCase("towel"))
						System.out.println("o.O");
					else
						System.out.println();
					c.addItem(a);
					mainCharacter.removeItem(a.getName());
					return c;
				}
			}
		}

		boolean gettingItem = false;
		//getting items from container check or getting item redundancy
		if (r.length()>=4 && r.substring(0,4).equalsIgnoreCase("get "))
		{
			gettingItem = true;
			String itemName = "";
			String containerName = "";
			GettableItem item = null;
			ContainerItem container = null;
			for (int x = 4; x<r.length()-6; x++) //checks the response for what item from what container
			{
				if (r.substring(x,x+6).equalsIgnoreCase(" from "))
				{
					gettingItem = false;
					itemName = r.substring(4,x);
					containerName = r.substring(x+6,r.length());
				}
			}
			if (!gettingItem) //if you're trying to get something from a container
			{
				for (Item possibleContainer: c.getItems())
				{
					if ((possibleContainer instanceof ContainerItem) && (possibleContainer.getName().equalsIgnoreCase(containerName)))
						container = (ContainerItem)possibleContainer;
				}
				if (container == null)
				{
					System.out.println("There is no such container in the room!");
					return c;
				}
				item = container.getItem(itemName);
				if (item != null)
				{
					mainCharacter.addItem(item);
					System.out.println("You grab the " + item.getName().toUpperCase() + " from the " + container.getName().toUpperCase() + ".");
					return c;
				}
				else
				{
					System.out.println("The " + container.getName().toUpperCase() + " doesn't contain that item!");
					return c;
				}
			}

			else //if you're not, and just getting an item by using GET <item>, instead of just typing <item>
			{
				r = r.substring(4,r.length());
			}
		}

		//item check
		ArrayList<Item> interact = c.getItems();
		for (int l = 0; l<interact.size(); l++)
		{
			if (r.equalsIgnoreCase(interact.get(l).getName()))
			{
				if (gettingItem && !(interact.get(l) instanceof GettableItem))
				{
					System.out.println("You can't get that item. It is just not possible. Unpossible, if you will.");
					return c;
				}
				interact.get(l).act();
				if (interact.get(l) instanceof GettableItem)
				{
					mainCharacter.addItem((GettableItem)interact.get(l));
					c.removeItem(interact.get(l).getName()); //Also need to add it to the player's inventory. DO THIS LATER. Actually, I think it's done now.
				}
				return c;
			}
		}

		//using items check
		if (r.length()>=4 && r.substring(0,4).equalsIgnoreCase("use "))
		{
			String item1 = "";
			String item2 = "";
			//int index = 0;
			for (int x = 4; x < r.length()-6; x++)
			{
				if (r.substring(x, x+6).equalsIgnoreCase(" with "))
				{
					item1 = r.substring(4, x);
					item2 = r.substring(x+6, r.length());
				}
			}
			if (item1.equals("")&&item2.equals(""))
			{
				System.out.println("USE what WITH what?");
				return c;
			}
			if (item1.equals(item2))
			{
				System.out.println("You can't use an item with itself!");
				return c;
			}
			Item oneItem = null;
			Item twoItem = null;
			/*for (int y = 0; y < p.getInventory().invItems.size(); y++)
			{
				if ()
			}*/
			for (Item invItem: mainCharacter.getInventory().invItems)
			{
				if (invItem.getName().equalsIgnoreCase(item1))
					oneItem = invItem;
				if (invItem.getName().equalsIgnoreCase(item2))
					twoItem = invItem;
			}
			if (oneItem == null)
			{
				System.out.println("You don't have the first item!");
				return c;
			}
			if (twoItem==null)
			{
				for (Item locItem: c.getItems())
					if ((locItem.getName().equalsIgnoreCase(item2)) && !(locItem instanceof GettableItem))
						twoItem = locItem;
			}
			if (twoItem==null)
			{
				System.out.println("You don't have the second item!");
				return c;
			}
			//System.out.println("Items used");
			//System.out.println(item1 + " " + item2);
			//combine the items
			if (twoItem instanceof GettableItem)
				reaction.use(oneItem, (GettableItem)twoItem);
			if (twoItem instanceof InteractableItem)
				reaction.use(oneItem, (InteractableItem)twoItem);
			if (twoItem instanceof ContainerItem)
				reaction.use(oneItem, (ContainerItem)twoItem);
			return c;
		}

		//exit check
		boolean validity = false;
		for (String s: c.getValidComs())
		{
			if (r.equalsIgnoreCase(s) || r.equalsIgnoreCase("exit") || r.equalsIgnoreCase("look"))
				validity = true;
		}
		if (validity == false)
		{
			int idle = (int)(Math.random()*6 + 1);
			if (idle == 1)
				System.out.println("You shift in place, unsure what to do.");
			if (idle == 2)
				System.out.println("You wonder what sound a potato makes.");
			if (idle == 3)
				System.out.println("That command isn't valid. To get HELP, you can always type COMMANDS for a list of valid commands.");
				//System.out.println("If a tree falls in a forest and no one is around, does it make a sound?");
			if (idle == 4)
				System.out.println("You can't do that!");
			if (idle == 5)
				System.out.println("That's ridiculous. That's not even funny.");
			if (idle == 6)
				System.out.println("Would your mother approve of that?");
			if (idle == 7)
				System.out.println("Would your father approve of that?");
			return c;
		}

		//look check
		if (r.equalsIgnoreCase("look"))
		{
			System.out.println(c.getDesc());
			return c;
		}

		//change rooms if it is both valid and nothing general
		return findLocation(r);
	}
}