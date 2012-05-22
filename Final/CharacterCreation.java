import java.util.*;
import java.io.*;

public class CharacterCreation
{

	public static Player create(String scanned) throws IOException
	{
		NameGenner namer = new NameGenner();

		Player mainChar = new Player("uninitialized");

		int randIndex = 0;
		int randIndex2 = 0;

		if (scanned.equalsIgnoreCase("male"))
		{
			mainChar = new Player(namer.compileName(0), namer);
		}
		else if (scanned.equalsIgnoreCase("female"))
				{
					mainChar = new Player(namer.compileName(1), namer);
				}
		return mainChar;
	}

	public static void freakError()
	{
		System.out.println("does not compute exterminating earth's population now\nerror\nerror\nfatal error\noperation will terminate");
	}
}