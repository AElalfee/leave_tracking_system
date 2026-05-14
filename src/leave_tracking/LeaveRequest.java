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
			setStatus("Rejected", "Automated");
		}else {
			setStatus("Processing", "Automated");
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
	
	public void setStatus(String newStatus, String changeBy) {
		String oldStatus = this.status;
		this.status = newStatus;
		
		if(newStatus.equals("Approved")) {
			int days = this.getRangeInDays();
	        this.employee.setBalance(days);
		}
		
		// TODO: get currentDat and assign it while creating object.
		StatusChange change = new StatusChange(oldStatus, newStatus, "", changeBy);
		statusHistory.add(change);
	}

	@Override
	public String toString() {
		return "LeaveRequest [requestId=" + requestId + ", startDate= " + startDate + ", endDate= " + endDate
				+ ", status= " + status + ", reason= " + reason + ", statusHistory= " + statusHistory + ", " + employee + "]";
	}
	
	
	public class StatusChange{
		private final String oldStatus;
		private final String newStatus;
		private final String changeDate;
		private final String changeBy;
		
		public StatusChange(String oldStatus, String newStatus, String changeDate, String changeBy) {
			this.oldStatus = oldStatus;
			this.newStatus = newStatus;
			this.changeDate = changeDate;
			this.changeBy = changeBy;
		}
		
		public String getOldStatus() {
			 return oldStatus;
		 }

		 public String getNewStatus() {
			 return newStatus;
		 }

		 public String getChangeDate() {
			 return changeDate;
		 }

		 public String getChangeBy() {
			 return changeBy;
		 }

		 @Override
		 public String toString() {
			return "[oldStatus=" + oldStatus + ", newStatus=" + newStatus + ", changeDate=" + changeDate
					+ ", changeBy=" + changeBy + "]";
		 }
		 
	}
}
