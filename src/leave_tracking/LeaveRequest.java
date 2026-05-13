package leave_tracking;

public class LeaveRequest {
	private int requestId = 0;
	private String startDate;
	private String endDate;
	private String status;
	private String reason;
	private Employee employee;

	public LeaveRequest(String startDate, String endDate, String reason, Employee employee) {
		requestId = requestId + 1;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.employee = employee;
		status = "Under review";
	}
	
	public String getLeaveRange() {
		return ("Starts from " + startDate + " Untill " + endDate);
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getReason() {
		return reason;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
