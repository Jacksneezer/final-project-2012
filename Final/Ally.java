public class Ally
{
	private String name;
	private int type;
	private int health;
	private int healthMax;

	public Ally(String s, int t)
	{
		name = s;
		type = t;
	}

	public String toString()
	{
		return "Name: "+name+"\nLife: "+health+"/"+healthMax;
	}
}





/*Types:
 *1 - Sane
 *2 - Angry
 *3 - Shattered
 *4 - Intoxicated (temp)
 *5 - Best Friend
 *6 - Significant Other (give option?)
 */