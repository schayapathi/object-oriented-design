
public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	
	public Employee(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	
	public Employee clone()
	{
		return (new Employee(this.id, this.name));
	}
	
	public int compareTo(Employee e)
	{
		if(this.getId() == e.getId())
		{
			return this.getName().compareTo(e.getName());
		}
		else
		{
			if(this.getId() > e.getId())
				return 1;
			else if (this.getId() < e.getId())
				return -1;
			else 
				return 0;
		}
	}
}
