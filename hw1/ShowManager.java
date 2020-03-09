import java.util.*;

public class ShowManager
{
	public static ArrayList<Show> scheduledShows = new ArrayList<Show>();

	public static void createShows()
	{
		Show dec23_6 = new Show("Dec 23, 2020", "6:30");
		Show dec23_8 = new Show("Dec 23, 2020", "8:30");
		Show dec24_6 = new Show("Dec 24, 2020", "6:30");
		Show dec24_8 = new Show("Dec 24, 2020", "8:30");
		Show dec25_6 = new Show("Dec 25, 2020", "6:30");
		Show dec25_8 = new Show("Dec 25, 2020", "8:30");
		Show dec26_6 = new Show("Dec 26, 2020", "6:30");
		Show dec26_8 = new Show("Dec 26, 2020", "8:30");
		Show dec27_6 = new Show("Dec 27, 2020", "6:30");
		Show dec27_8 = new Show("Dec 27, 2020", "8:30");
		Show dec28_6 = new Show("Dec 28, 2020", "6:30");
		Show dec28_8 = new Show("Dec 28, 2020", "8:30");
		Show dec29_6 = new Show("Dec 29, 2020", "6:30");
		Show dec29_8 = new Show("Dec 29, 2020", "8:30");
		Show dec30_6 = new Show("Dec 30, 2020", "6:30");
		Show dec30_8 = new Show("Dec 30, 2020", "8:30");
		Show dec31_6 = new Show("Dec 31, 2020", "6:30");
		Show dec31_8 = new Show("Dec 31, 2020", "8:30");
		Show jan1_6 = new Show("Jan 1, 2021", "6:30");
		Show jan1_8 = new Show("Jan 1, 2021", "8:30");
		Show jan2_6 = new Show("Jan 2, 2021", "6:30");
		Show jan2_8 = new Show("Jan 2, 2021", "8:30");	

		scheduledShows.add(dec23_6);
		scheduledShows.add(dec23_8);
		scheduledShows.add(dec24_6);
		scheduledShows.add(dec24_8);
		scheduledShows.add(dec25_6);
		scheduledShows.add(dec25_8);
		scheduledShows.add(dec26_6);
		scheduledShows.add(dec26_8);
		scheduledShows.add(dec27_6);
		scheduledShows.add(dec27_8);
		scheduledShows.add(dec28_6);
		scheduledShows.add(dec28_8);
		scheduledShows.add(dec29_6);
		scheduledShows.add(dec29_8);
		scheduledShows.add(dec30_6);
		scheduledShows.add(dec30_8);
		scheduledShows.add(dec31_6);
		scheduledShows.add(dec31_8);
		scheduledShows.add(jan1_6);
		scheduledShows.add(jan1_8);
		scheduledShows.add(jan2_6);
		scheduledShows.add(jan2_8);
	}
	public static Show getShow(String showDate, String showTime)
	{
		for(Show s: scheduledShows)
		{
			if(s.getDate().equals(showDate) && s.getTime().equals(showTime))
			{
				return s;
			}
		}
		return null;
	}
	public static void generateSeats()
	{
		for(int i = 0; i < scheduledShows.size(); i++)
		{
			scheduledShows.get(i).makeSeats();
		}

	}







}