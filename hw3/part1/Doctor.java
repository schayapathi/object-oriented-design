
public class Doctor extends Person implements Employee{
	
	private int salary;
	
	public Doctor(String name, int id, int salary)
	{
		super(name, id);
		this.salary = salary;
	}
	
	public boolean working()
	{
		//return whether or not they are working
		return true;
	}
	public int getSalary()
	{
		return salary;
	}
	public void performSurgery(Patient p)
	{
		//do surgery on a certain patient p
	}
	public void prescribeMedicine(Patient p)
	{
		//create a prescription for a certain patient p
	}
	public void updateNurse(Nurse n, Patient p)
	{
		//update nurse n about a certain patient p
	}
	
}
