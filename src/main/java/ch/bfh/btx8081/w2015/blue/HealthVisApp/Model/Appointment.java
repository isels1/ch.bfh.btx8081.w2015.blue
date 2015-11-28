package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.Date;

public class Appointment {
	
	//================================================================================
    // Appointment Data
    //================================================================================
	
	private Date startTime;
	private Date endTime;
	private String ort;
	private Patient patient;
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Appointment(Date startTime, Date endTime, String ort, Patient patient, HealthVisitor healthvisitor){	
		this.startTime = startTime;
		this.endTime = endTime;
		this.ort = ort;
		this.patient = patient;
		this.healthvisitor = healthvisitor;
	}

	//================================================================================
    // Setter Section
    //================================================================================
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	
	public String getOrt() {
		return ort;
	}


	public Patient getPatient() {
		return patient;
	}


	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}

}
