package exercise9;

public class Withdraw implements Runnable {
	public void run()
	{
		while(true)
		{
			BankAccount.withdraw(100);
			try
			{
				Thread.sleep(25);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
