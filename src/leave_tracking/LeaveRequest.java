package leave_tracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LeaveRequest {
	private static int counter = 0;
	private int requestId;
	private String startDate;
	private String endDate;
	private String status;
	private String reason;
	private Employee employee;

	public LeaveRequest(String startDate, String endDate, String reason, Employee employee) {
		counter++;
		requestId = counter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.employee = employee;
		status = "Under review";
	}
	
	public void processLeave() {
		int days = this.getRangeInDays();
		int balance = this.employee.getBalance();
		
		if((balance - days) < 0) {
			this.status = "Rejected";
		}else {
			this.status = "Processing";
		}
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
	
	public int getRangeInDays() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedStartDate = LocalDate.parse(this.startDate, dateFormatter);
        LocalDate parsedEndDate = LocalDate.parse(this.endDate, dateFormatter);
        
        int days = (int)ChronoUnit.DAYS.between(parsedStartDate, parsedEndDate);
        return days;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeaveRequest [requestId=" + requestId + ", startDate= " + startDate + ", endDate= " + endDate
				+ ", status= " + status + ", reason= " + reason + ", " + employee + "]";
	}
	
}
