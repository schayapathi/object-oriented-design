
public class Patient extends Person{
	
	private String condition;
	private int roomNumber;
	
	public Patient(String name, int id, String condition, int roomNumber)
	{
		super(name, id);
		this.condition = condition;
		this.roomNumber = roomNumber;
	}
	
	public String healthInsurance()
	{
		//returns patient's health insurance
		return "";
	}
	
	public boolean discharged()
	{
		//return whether or not the patient has been discharged
		return true;
	}
	public String getCondition()
	{
		//return condition set by the nurse
		return condition;
	}
	public int getRoomNumber()
	{
		return roomNumber;
	}
}
