import java.util.*;

public class User
{
	private static String username, password;
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public User (String userName, String passWord)
	{
		this.username = userName;
		this.password = passWord;
	}
	public static String getUsername ()
	{
		return username;
	}
	public static void addReservation(Reservation reservation)
	{
		reservations.add(reservation);
	}
	public static void printReservations()
	{
		for(Reservation r: reservations)
		{
			System.out.println(r.getShowDate() + " " + r.getShowTime() + " " + r.getSeat());
		}
	}

}
