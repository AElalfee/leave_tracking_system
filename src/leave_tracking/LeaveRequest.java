package leave_tracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LeaveRequest {
	private static int counter = 0;
	private int requestId;
	private String startDate;
	private String endDate;
	private String status;
	private String reason;
	private Employee employee;
	@SuppressWarnings("unused")
	private ArrayList<StatusChange> statusHistory = new ArrayList<>();

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
	
	
	public class StatusChange{
		private String oldStatus;
		private String newStatus;
		private String changeDate;
		private Employee changeBy;
		
		public StatusChange(String oldStatus, String newStatus, String changeDate, Employee changeBy) {
			this.oldStatus = oldStatus;
			this.newStatus = newStatus;
			this.changeDate = changeDate;
			this.changeBy = changeBy;
		}
		
		public String getOldStatus() {
			 return oldStatus;
		 }

		 public void setOldStatus(String oldStatus) {
			 this.oldStatus = oldStatus;
		 }

		 public String getNewStatus() {
			 return newStatus;
		 }

		 public void setNewStatus(String newStatus) {
			 this.newStatus = newStatus;
		 }

		 public String getChangeDate() {
			 return changeDate;
		 }

		 public void setChangeDate(String changeDate) {
			 this.changeDate = changeDate;
		 }

		 public Employee getChangeBy() {
			 return changeBy;
		 }

		 public void setChangeBy(Employee changeBy) {
			 this.changeBy = changeBy;
		 }
	}
}
