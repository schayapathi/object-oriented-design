public class Reservation
{
	private Show show;
	private User user;
	private String seat;

	public Reservation (Show show, User user, String seat)
	{
		this.show = show;
		this.user = user;
		this.seat = seat;
	}

	public Show getShow()
	{
		return show;
	}
	public String getShowDate()
	{
		return show.getDate();
	}

	public String getShowTime()
	{
		return show.getTime();
	}

	public User getUser()
	{
		return user;
	}

	public String getSeat()
	{
		return seat;
	}
}