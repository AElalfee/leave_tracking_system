package leave_tracking;

public class Main {

	public static void main(String[] args) {	
		Employee employee = new Employee("Abdelrahman", "abdelrahman@example.com", "IT");
		LeaveRequest request = employee.applyLeave("15-05-2026", "20-05-2026", "Sick");
		System.out.println(request);
		request.setStatus("Approved", employee.getName());
		System.out.println(request);
	}

}