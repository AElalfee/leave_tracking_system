package leave_tracking;

public class Employee {
	private static int counter = 0;
	private int employeeId;
	private String name;
	private String email;
	private String department;
	private int balance = 30;

	public Employee(String name, String email, String department) {
		counter++;
		employeeId = counter; // Assigning an incrementing id while creating object
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
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int days) {
		balance = balance - days;
	}
	
	public LeaveRequest applyLeave(String startDate, String endDate, String reason) {
		LeaveRequest request = new LeaveRequest(startDate, endDate, reason, this);
		request.processLeave();
		return request;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId =" + employeeId + ", name =" + name + ", email =" + email + ", department ="
				+ department + ", balance = " + balance + "]";
	}

}
