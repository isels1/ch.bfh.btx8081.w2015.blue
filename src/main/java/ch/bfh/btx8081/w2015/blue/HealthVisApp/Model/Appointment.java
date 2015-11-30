package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.GregorianCalendar;

public class Appointment {
	
	//================================================================================
    // Appointment Data
    //================================================================================
	
	private GregorianCalendar startTime;
	private GregorianCalendar endTime;
	private String location;
	private Patient patient;
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Appointment(){
		
	}
	
	public Appointment(GregorianCalendar startTime, GregorianCalendar endTime, 
			String location, Patient patient, HealthVisitor healthvisitor){	
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.patient = patient;
		this.healthvisitor = healthvisitor;
	}

	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * Setter for the startTime
	 * @param startTime The start Time of the Appointment /GregorianCalendar
	 */
	public void setStartTime(GregorianCalendar startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Setter for the endTime
	 * @param endTime The end Time of the Appointment /GregorianCalendar
	 */
	public void setEndTime(GregorianCalendar endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Setter for the location
	 * @param location The Location of the Appointment /String
	 */
	public void setlocation(String location) {
		this.location = location;
	}
	/**
	 * Setter for the patient
	 * @param patient The Patient who belongs to the Appointment /Patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * Setter for the healthVisitor
	 * @param healthVisitor The Healthvisitor who belongs to the Appointment /HealthVisitor
	 */
	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * Getter for the startTime
	 * @return startTime The start Time of the Appointment /GregorianCalendar
	 */
	public GregorianCalendar getStartTime() {
		return startTime;
	}
	
	/**
	 * Getter for the endTime
	 * @return endTime The end Time of the Appointment /GregorianCalendar
	 */
	public GregorianCalendar getEndTime() {
		return endTime;
	}
	
	/**
	 * Getter for the location
	 * @return The Location of the Appointment /String
	 */
	public String getlocation() {
		return location;
	}

	/**
	 * Getter for the patient
	 * @return The Patient who belongs to the Appointment /Patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Getter for the healthVisitor
	 * @return  The Healthvisitor who belongs to the Appointment /HealthVisitor
	 */
	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}

}
