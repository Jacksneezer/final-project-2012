import java.io.*;
import java.util.*;

public class FinalRunner
{
	public static void main (String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		String response;
		Location curLocation;
		Location oldLocation;
/*		namer.prompt("femfirst.txt");
		System.out.println(namer.getNames("femfirst.txt"));*/

		Player mainChar = new Player("uninitialized");

		System.out.println("The murky darkness foretells a story. A rather anticlimactic story, if you are to be honest with yourself, but a story nonetheless."
			+"\nAre you a MALE, or a FEMALE? Be forewarned that answering incompletely or strangely will set off the self-destruct on this mechanism.");
		String scanned = scan.nextLine();
		mainChar = CharacterCreation.create(scanned);
		if (mainChar.getName().equals("uninitialized"))
		{
			CharacterCreation.freakError();
			return;
		}
		System.out.println("You are " + mainChar.getName() + ", and the world is ending.");
		curLocation = new Location("wake");
		System.out.println(curLocation.deprecatedDesc());
		boolean terminate = false;
		GameParser parser = new GameParser();
		while (!terminate)
		{
			response = scan.nextLine();
			if (response.equalsIgnoreCase("exit"))
				return;
			if (response.equalsIgnoreCase("continue")&&parser.getDoor())
				terminate = true;
			else
				parser.parse(curLocation, response, mainChar);
		}
		boolean endGame = false;
		GameRunner run = new GameRunner(mainChar);
		run.genLocations();
		curLocation = run.findLocation("hallway");
		System.out.println(curLocation.getDesc());
		while (!endGame)
		{
			response = scan.nextLine();
			if (response.equalsIgnoreCase("exit"))
				endGame = true;
			else
			{
				oldLocation = curLocation;
				curLocation = run.run(curLocation, response);
				if (curLocation!=oldLocation)
				{
					System.out.println(curLocation.getDesc());
				}
			}
		}

	}
}

//"H:\\My Documents\\APCS\\Final\\names.txt"
//"H:\\My Documents\\APCS\\Final\\femfirst.txt"
//"H:\\My Documents\\APCS\\Final\\relast.txt"
//"H:\\My Documents\\APCS\\Final\\mfirstridi.txt"
//"H:\\My Documents\\APCS\\Final\\ffirstridi.txt"
//"H:\\My Documents\\APCS\\Final\\ridilast.txt"

//Homecomp
//"C:\\APCS\\Final\\names.txt"
//"C:\\APCS\\Final\\femfirst.txt"
//"C:\\APCS\\Final\\relast.txt"