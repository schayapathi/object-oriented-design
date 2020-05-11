
public class Nurse extends Person implements Employee{
	
	private int salary;
	
	public Nurse(String name, int id, int salary)
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
	public void diagnose(Patient p)
	{
		//diagnose a certain Patient p and set their condition
	}
	public void careForPatient(Patient p)
	{
		//care for a certain patient p
	}
	public void updateDoctor(Doctor d, Patient p)
	{
		//update Doctor d about a certain patient p
	}
}
