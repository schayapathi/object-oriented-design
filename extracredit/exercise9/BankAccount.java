package exercise9;

public class BankAccount {
	/**
	 * Without locks, the bank account can easily be corrupted due to the
	 * race condition. Even though there are constant deposits and 
	 * withdrawals of the same amount of money, the balance goes negative
	 * between some iterations because the balance has not been updated
	 * in another thread.
	 */
	private static int balance;

	public BankAccount()
	{
		balance = 0;
	}
	
	public static void deposit(int amount)
	{
		System.out.println("Depositing $" + amount);
		balance = balance + amount;
		System.out.println("Current balance: $" + balance);
	}
	
	public static void withdraw(int amount)
	{
		System.out.println("Withdrawing $" + amount);
		balance = balance - amount;
		System.out.println("Current balance: $" + balance);
	}
	
	public static void main(String[]args)
	{
		Thread deposit = new Thread (new Deposit());
		Thread withdraw = new Thread (new Withdraw());
		Thread deposit2 = new Thread (new Deposit());
		Thread withdraw2 = new Thread (new Withdraw());
		deposit.start();
		withdraw.start();
		deposit2.start();
		withdraw2.start();
	}
}
