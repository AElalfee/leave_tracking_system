package leave_tracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
}
