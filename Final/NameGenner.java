import java.io.*;
import java.util.*;

public class NameGenner
{
	private String first;
	private String last;
//	FileReader reed = new FileReader("H:\\My Documents\\APCS\\Final\\names.txt");
//	FileWriter wright = new FileWriter("H:\\My Documents\\APCS\\Final\\names.txt");
	private Scanner scan = new Scanner(System.in);

	public NameGenner()
	{
	}

/*	public void firstPrompt() throws IOException
	{
//		FileReader reed = new FileReader("H:\\My Documents\\APCS\\Final\\names.txt");
		FileWriter wright = new FileWriter("H:\\My Documents\\APCS\\Final\\names.txt", true);
//		BufferedReader twinreed = new BufferedReader(reed);
		String rubbish = "";
		boolean go = true;
		while(go)
		{
			System.out.print("Enter first name: ");
			rubbish = scan.next() + "\n";
			wright.write(rubbish);
			wright.flush();
			//wright.close();
			System.out.print("Go again? ");
			if (scan.next().equalsIgnoreCase("n"))
				go = false;
		}
		wright.close();
	}*/

	public void prompt(String filename) throws IOException
	{
		FileWriter wright = new FileWriter(filename, true);
		String rubbish = "";
		boolean go = true;
		while(go)
		{
			System.out.print("Enter name: ");
			rubbish = scan.next() + "\n";
			wright.write(rubbish);
			wright.flush();
			System.out.print("Go again? ");
			if (scan.next().equalsIgnoreCase("n"))
				go = false;
		}
		wright.close();
	}

	public ArrayList<String> getNames(String filename) throws IOException
	{
		FileReader reed = new FileReader(filename);
		BufferedReader twinreed = new BufferedReader(reed);
		ArrayList<String> firstNames = new ArrayList<String>();
		for (;;) {
			String s = twinreed.readLine();
			if (s == null) break;
			firstNames.add(s);
		}
//		while (twinreed.readLine()!=null)
//			firstNames.add(twinreed.readLine());
		return firstNames;
	}

	public String compileName(int a) throws IOException
	{
		String name="";
		ArrayList<String> lastNames = this.getNames("relast.txt");
		ArrayList<String> firstNames = new ArrayList<String>();
		int randIndex = 0;
		int randIndex2 = 0;
		if (a==0)
		{
			firstNames = this.getNames("names.txt");
			randIndex = (int)(firstNames.size()*Math.random());
			randIndex2 = (int)(lastNames.size()*Math.random());
			first = firstNames.get(randIndex);
			last = lastNames.get(randIndex2);
			return firstNames.get(randIndex) + " " + lastNames.get(randIndex2);
		}
		if (a==1)
		{
			firstNames = this.getNames("femfirst.txt");
			randIndex = (int)(firstNames.size()*Math.random());
			randIndex2 = (int)(lastNames.size()*Math.random());
			first = firstNames.get(randIndex);
			last = lastNames.get(randIndex2);
			return firstNames.get(randIndex) + " " + lastNames.get(randIndex2);
		}
		return "";
	}

	public String getFirst()
	{
		return first;
	}

	public String getLast()
	{
		return last;
	}
}