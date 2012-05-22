public class Player
{
	private final String name;
	private final String first;
	private final String last;
	private int phys = 10;
	private int physMax = 10;
	private int ment = 10;
	private int mentMax = 10;
	private int emot = 10;
	private int emotMax = 10;
	private Inventory playerInv = new Inventory();

	public Player(String n, NameGenner gen)
	{
		name = n;
		first = gen.getFirst();
		last = gen.getLast();
	}

	public Player(String n)
	{
		name = n;
		first = "";
		last = "";
	}

	public String getName()
	{
		return name;
	}

	public String getFirst()
	{
		return first;
	}

	public String getLast()
	{
		return last;
	}

	public Inventory getInventory()
	{
		return playerInv;
	}

	public void takeHit(int p, int m, int e)
	{
		phys-=p;
		ment-=m;
		emot-=e;
	}

	public void failEval()
	{
		if (phys == 0)
			System.out.println("Gasping for breath, you collapse to the floor. The world swims in your vision, slowly getting darker and darker until there is nothing left to see.\n\nShould have had a V8.");
		if (ment == 0)
			System.out.println("Eye twitching, you finally lose it, that tenuous grasp on reality. You hear a roaring laugh, coming from everywhere, nowhere...\n\n");
		if (emot == 0)
			System.out.println("Tears leaking from your eyes, you fall to your knees. You don't think you can take this anymore. You need a rest, a long, long rest...\n\n");
	}

	public void addItem(GettableItem a)
	{
		playerInv.addItem(a);
	}

	public void removeItem(String s)
	{
		playerInv.removeItem(s);
	}

	public String toString()
	{
		return "Name: "+name+"\nPhysical: "+phys+"/"+physMax+"\nMental: "+ment+"/"+mentMax
			+ "\nEmotional: "+emot+"/"+emotMax;
	}
}