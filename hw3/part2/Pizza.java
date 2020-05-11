
public abstract class Pizza {
	
	//Template method
	public void makeFromScratch()
	{
		makeCrust();
		addToppings();
		preHeatOven();
		cook();
	}
	
	//Abstract methods
	public abstract void makeCrust();
	public abstract void addToppings();
	public abstract void preHeatOven();
	public abstract void cook();
	
	
	//Tester
	public static void main(String[]args)
	{
		System.out.println("Making a pizza Chicago style: ");
		Pizza chic = new ChicagoStyle();
		chic.makeFromScratch();
		System.out.println();
		
		System.out.println("Making a pizza New York style: ");
		Pizza ny = new NYStyle();
		ny.makeFromScratch();
		System.out.println();

		
		System.out.println("Making a pizza California style: ");
		Pizza cali = new CaliStyle();
		cali.makeFromScratch();

		
	}
}
