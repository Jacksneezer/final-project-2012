public class Enemy
{
	private String name;
	private int health;

	public Enemy(String n, int h)
	{
		name = n;
		health = h;
	}

	public String toString()
	{
		return name;
	}
}