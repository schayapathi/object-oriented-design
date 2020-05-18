package exercise9;

public class Deposit implements Runnable {
	public void run()
	{
		while(true)
		{
			BankAccount.deposit(100);
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
