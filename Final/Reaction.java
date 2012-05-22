public class Reaction
{
	Location curLocation;
	Player mainChar;

	public Reaction(Location c, Player p)
	{
		curLocation = c;
		mainChar = p;
	}

	public void use(Item one, GettableItem two)
	{
		if (one.getName().equalsIgnoreCase("sugar") && two.getName().equalsIgnoreCase("yeast"))
		{
			for (GettableItem a: mainChar.getInventory().invItems)
				if (a.getName().equals("sugared yeast"))
				{
					System.out.println("You've already got some SUGARED YEAST. You don't need more.");
					return;
				}
			System.out.println("You pour the SUGAR and YEAST together in your hand, creating a handful of SUGARED YEAST.");
			mainChar.addItem(new GettableItem("sugared yeast", "a handful of SUGARED YEAST", "This is a handful of sugar mixed with yeast. You're not gonna eat this."));
			return;
		}
		if (one.getName().equalsIgnoreCase("yeast") && two.getName().equalsIgnoreCase("sugar"))
		{
			for (GettableItem a: mainChar.getInventory().invItems)
				if (a.getName().equals("yeasted sugar"))
				{
					System.out.println("You've already got some YEASTED SUGAR. You don't need more.");
					return;
				}
			System.out.println("You pour the YEAST and SUGAR together in your hand, creating a handful of YEASTED SUGAR.");
			mainChar.addItem(new GettableItem("yeasted sugar", "a handful of YEASTED SUGAR", "This is a handful of yeast mixed with sugar. You're not gonna eat this."));
			return;
		}
		if ((one.getName().equalsIgnoreCase("sugared yeast") && two.getName().equalsIgnoreCase("yeasted sugar"))||(one.getName().equalsIgnoreCase("yeasted sugar") && two.getName().equalsIgnoreCase("sugared yeast")))
		{
			System.out.println("You pour the " + one.getName().toUpperCase() + " and " + two.getName().toUpperCase() + " together in your hand, creating a handful of SUGAR AND YEAST ABOMINATION.");
			System.out.println("What are you even doing? What are you supposed to make with that? You throw it away in disgust.");
			mainChar.removeItem("sugared yeast");
			mainChar.removeItem("yeasted sugar");
			return;
		}
		/*if (((one.getName().equals("yeasted sugar")||one.getName().equals("sugared yeast"))&&(two.getName().equals("warm water")))||((one.getName().equals("warm water"))&&(two.getName().equals("yeasted sugar")||two.getName().equals("sugared yeast"))))
		{
			System.out.println("You put the yeast and sugar mixture into the bowl of warm water.");
			mainChar.removeItem("sugared yeast");
			mainChar.removeItem(")
		}*/
		if ((one.getName().equals("yeasted sugar")&&two.getName().equals("warm water"))||((one.getName().equals("warm water"))&&(two.getName().equals("yeasted sugar"))))
		{
			System.out.println("You pour the YEASTED SUGAR into the WARM WATER, creating a YEAST MIXTURE.");
			mainChar.removeItem("yeasted sugar");
			mainChar.removeItem("warm water");
			mainChar.addItem(new GettableItem("yeast mixture", "a bowl with yeast mixture inside", "This is a bowl with yeast mixture inside. It needs flour."));
			return;
		}
		if ((one.getName().equals("sugared yeast")&&two.getName().equals("warm water"))||((one.getName().equals("warm water"))&&(two.getName().equals("sugared yeast"))))
		{
			System.out.println("You pour the SUGARED YEAST into the WARM WATER, creating a YEAST MIXTURE.");
			mainChar.removeItem("sugared yeast");
			mainChar.removeItem("warm water");
			mainChar.addItem(new GettableItem("yeast mixture", "a bowl with yeast mixture inside", "This is a bowl with yeast mixture inside. It needs flour."));
			return;
		}
		if ( ((one.getName().equals("yeast mixture"))&&(two.getName().equals("flour"))) || ((one.getName().equals("flour"))&&(two.getName().equals("yeast mixture"))) )
		{
			System.out.println("You add FLOUR to the YEAST MIXTURE, creating a BREAD MIXTURE.");
			mainChar.removeItem("yeast mixture");
			mainChar.addItem(new GettableItem("bread mixture", "a bowl with bread mixture inside", "This is a bowl with bread mixture inside. It needs to be cooked!"));
			return;
		}
		if ((one.getName().equals("sugar")&&two.getName().equals("warm water")) || (one.getName().equals("warm water")&&two.getName().equals("sugar")))
		{
			System.out.println("You place SUGAR in the WARM WATER, creating SUGARED WATER.");
			mainChar.addItem(new GettableItem("sugared water", "a bowl with sugared water inside", "This is a bowl with sugared water inside. It needs more ingredients."));
			mainChar.removeItem("warm water");
			return;
		}
		if ((one.getName().equals("sugared water")&&two.getName().equals("yeast")) || (one.getName().equals("yeast")&&two.getName().equals("sugared water")))
		{
			System.out.println("You add YEAST to the SUGARED WATER, creating a YEAST MIXTURE.");
			mainChar.removeItem("sugared water");
			mainChar.addItem(new GettableItem("yeast mixture", "a bowl with yeast mixture inside", "This is a bowl with yeast mixture inside. It needs flour."));
			return;
		}
		if ((one.getName().equals("yeast")&&two.getName().equals("warm water")) || (one.getName().equals("warm water")&&two.getName().equals("yeast")))
		{
			System.out.println("You place YEAST in the WARM WATER, creating YEASTED WATER.");
			mainChar.removeItem("warm water");
			mainChar.addItem(new GettableItem("yeasted water", "a bowl with yeasted water inside", "This is a bowl with yeasted water inside. It needs more ingredients."));
			return;
		}
		if ((one.getName().equals("yeasted water")&&two.getName().equals("sugar")) || (one.getName().equals("sugar")&&two.getName().equals("yeasted water")))
		{
			System.out.println("You add SUGAR to the YEASTED WATER, creating a YEAST MIXTURE.");
			mainChar.removeItem("yeasted water");
			mainChar.addItem(new GettableItem("yeast mixture", "a bowl with yeast mixture inside", "This is a bowl with yeast mixture inside. It needs flour."));
			return;
		}

		if (one.getName().equals("warm water")||two.getName().equals("warm water"))
		{
			System.out.println("That's not something you want to be placing into the water, 'cuz it's poisonous for you.");
			return;
		}
		if (one.getName().equals("flour")||two.getName().equals("flour"))
		{
			System.out.println("It's not a good idea to add flour to that at the moment.");
			return;
		}
		System.out.println("You think about using your " + one.getName().toUpperCase() + " with your " + two.getName().toUpperCase() + ", but conclude that won't work.");
	}

	public void use(Item one, InteractableItem two)
	{
		if (one.getName().equalsIgnoreCase("key") && two.getName().equalsIgnoreCase("door"))
		{
			curLocation.addExit("storage");
			System.out.println("The key turns nicely in the lock, opening the storage room.");
			curLocation.removeItem("door");
			return;
		}
		/*if (one.getName().equalsIgnoreCase("bat") && two.getName().equals("front door"))
		{
			curLocation.addExit("outside");
			System.out.println("With your trusty baseball bat, you feel ready to face whatever lies in wait outside. You reach out and unlock the front door.");
			curLocation.removeItem("front door");
			return;
		}*/
		if (one.getName().equalsIgnoreCase("bat")&&two.getName().equals("padlock"))
		{
			System.out.println("With all your might, you swing your trusty baseball bat and smash the padlock to smithereens. The way to the FRONT DOOR is now clear.");
			curLocation.removeItem("padlock");
			curLocation.addItem(new InteractableItem("front door", "your FRONT DOOR, which is locked", "your FRONT DOOR, which is still locked", "You rattle the doorknob. Your door is locked from the outside! You wouldn't have thought that possible, "
				+ "but it seems that it has happened.", "You rattle "
				+ "the doorknob again. It won't open. Looks like it's locked from the outside."));
			return;
		}
		if (one.getName().equalsIgnoreCase("silver key") && two.getName().equals("front door"))
		{
			curLocation.addExit("outside");
			System.out.println("You unlock your FRONT DOOR with the SILVER KEY. That's it, you're free from this accursed house! You only dread what may lie outside, in the empty streets...");
			curLocation.removeItem("front door");
			return;
		}
		if (one.getName().equalsIgnoreCase("towel") && two.getName().equalsIgnoreCase("blender"))
		{
			System.out.println("You throw your TOWEL over the BLENDER. It looks quite silly. You take the TOWEL back off the BLENDER.");
			return;
		}
		if (one.getName().equalsIgnoreCase("glass bowl") && two.getName().equalsIgnoreCase("sink"))
		{
			System.out.println("You fill the GLASS BOWL with the warm water from the sink. You should probably get that sink fixed, but can't see it happening anytime soon.");
			mainChar.addItem(new GettableItem("warm water", "a bowl with WARM WATER in it", "Despite its name, this is actually a glass bowl, containing warm water."));
			mainChar.removeItem("glass bowl");//remove the items from the inventory
			return;
		}
		/*if (one.getName().equalsIgnoreCase("key") && two.getName().equalsIgnoreCase("front door"))
		{
			System.out.println("The key doesn't fit in the lock for the front door. Besides, you can unlock this door easily; you just need to be sure you have a weapon to face what's outside.");
			return;
		}*/
		if (one.getName().equalsIgnoreCase("key")&&two.getName().equalsIgnoreCase("padlock"))
		{
			System.out.println("The key doesn't fit in the padlock. You'll need brute force to break this down.");
			return;
		}
		if (one.getName().equalsIgnoreCase("glass bowl") && two.getName().equals("blender"))
		{
			System.out.println("That's likely to destroy both the bowl and the blender. And you don't want that.");
			return;
		}
		if (one.getName().equalsIgnoreCase("bread mixture")&&two.getName().equals("oven"))
		{
			System.out.println("You preheat the oven, and wait.");
			System.out.println("Then you shove the bread mixture inside the oven, and wait.");
			System.out.println("And wait.");
			System.out.println("There are a few more steps, but eventually you get bread. A BAGUETTE, to be specific!");
			mainChar.removeItem("bread mixture");
			mainChar.addItem(new GettableItem("baguette", "a hard-earned baguette", "This is a very tasty baguette."));
			return;
		}



		if (two.getName().equals("blender"))
		{
			System.out.print("WILL IT BLEND!? ");
			System.out.println("...Yeah, it probably will, but you're not one to risk it.");
			return;
		}
		if (two.getName().equals("oven"))
		{
			System.out.println("Doing that's probably gonna cause some sort of mishap. Best not to.");
			return;
		}
		System.out.println("You think about using your " + one.getName().toUpperCase() + " on the " + two.getName().toUpperCase() + ", but conclude that won't work.");
	}

	public void use(Item one, ContainerItem two)
	{
		System.out.println("You don't want to put your " + one.getName().toUpperCase() + " inside a container. You'd rather haul around all your junk like a street vendor.");
	}
}