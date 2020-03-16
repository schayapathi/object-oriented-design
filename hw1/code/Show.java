import java.util.*;
import java.io.*;

public class Show
{
	public static ArrayList<String> availableSeats = new ArrayList<String>();
	private String date, time;

	public Show(String date, String time)
	{
		this.date = date;
		this.time = time;
	}

	public String getDate()
	{
		return date;
	}

	public String getTime()
	{
		return time;
	}
	public static void makeSeats()
	{
		for (int m = 1; m < 150; m++)
		{
			availableSeats.add("m" + String.valueOf(m));
		}
		for (int sb = 1; sb < 50; sb++)
		{
			availableSeats.add("sb" + String.valueOf(sb));
		}
		for(int wb = 1; wb < 100; wb++)
		{
			availableSeats.add("wb" + String.valueOf(wb));
		}
		for(int eb = 1; eb < 100; eb++)
		{
			availableSeats.add("eb" + String.valueOf(eb));
		}
	}

	public static void getAvailableSeats()
	{
		System.out.println("Available seats: ");
		for(String s : availableSeats)
		{
			System.out.print(s + ", ");
		}
	}
	public static void makeSeatUnavailable(String seat)
	{
		availableSeats.remove(seat);
	}

	public static void makeSeatAvailable(String seat)
	{
		availableSeats.add(seat);
	}

}
