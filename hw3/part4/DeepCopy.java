
import java.util.*;

public class DeepCopy {

	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public DeepCopy()
	{
		employees.add(new Employee(345, "Tom"));
		employees.add(new Employee(200, "Joseph"));
		employees.add(new Employee(327, "Mary"));
	}
	public static void main(String[]args)
	{
		DeepCopy dc = new DeepCopy();
		List<Employee> clone = new ArrayList<Employee>();
		for(Employee e: employees)
		{
			clone.add(e.clone());
		}
		Collections.sort(clone);
		System.out.println("Sorted clone:");
		for(Employee e: clone)
		{
			System.out.println(e.getId() + " " + e.getName());
		}
		
		System.out.println("Original ArrayList:");
		for(Employee e: employees)
		{
			System.out.println(e.getId() + " " + e.getName());
		}
	}
}
