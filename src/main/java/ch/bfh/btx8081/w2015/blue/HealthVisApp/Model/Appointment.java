package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.Date;




public class Appointment {
	
	private Date startTime;
	private Date endTime;
	private String ort;
	private Patient patient;
	private HealthVisitor healthvisitor;
	
	public Appointment(Date startTime, Date endTime, String ort, Patient patient, HealthVisitor healthvisitor){
	
	this.startTime = startTime;
	this.endTime = endTime;
	this.ort = ort;
	this.patient = patient;
	this.healthvisitor = healthvisitor;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}

	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}
}
