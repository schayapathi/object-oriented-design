import java.util.*;
import java.io.*;

public class UserManager
{
	private static ArrayList<User> users = new ArrayList<User>();

	public static User getUser(String username)
	{
		for(User us: users)
		{
			if(us.getUsername().equals(username))
				return us;
		}
		return null;
	}

	public static void addUser (String username, String password)
	{
		User u = new User(username, password);
		users.add(u);
		BufferedWriter writer; 
		try
		{
			writer = new BufferedWriter(new FileWriter("/Users/swatichayapathi/Documents/TheaterReservation/users.txt"));
			writer.write(username);
			writer.newLine();
			writer.write(password);
			writer.newLine();
			writer.close();
		} catch (IOException e)
		{
			System.out.println(e);
		}
	}
	public static boolean authenticateUser (String username, String password)
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader("/Users/swatichayapathi/Documents/TheaterReservation/users.txt"));
			String line = reader.readLine();
			while(line != null)
			{
				if(line.equals(username) && reader.readLine().equals(password))
				{
					return true;
				}
				else
					line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}
}