package leave_tracking;

public class Employee {
	private int employeeId = 0;
	private String name;
	private String email;
	private String department;

	public Employee(String name, String email, String department) {
		employeeId = employeeId + 1; // Assigning an incrementing id while creating object
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDepartment() {
		return department;
	}

}
