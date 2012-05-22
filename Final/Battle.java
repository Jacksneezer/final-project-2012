public class Battle
{
	private Enemy anemone;
	private Player platypus;
	private int playerRoll;
	private int enemyRoll;

	public Battle(Enemy e, Player p)
	{
		anemone = e;
		platypus = p;
	}

	//calculates the battle result? maybe another method to do that?
	public void reroll()
	{
		playerRoll = (int)(Math.random()*100)+1;
		enemyRoll = (int)(Math.random()*100)+1;
	}
}