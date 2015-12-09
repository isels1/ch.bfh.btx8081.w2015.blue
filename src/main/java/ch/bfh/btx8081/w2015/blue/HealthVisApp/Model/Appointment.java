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
	private Calendar calendar;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Appointment(){
		
	}
	
	public Appointment(GregorianCalendar startTime, GregorianCalendar endTime, Calendar calendar){	
		this.startTime = startTime;
		this.endTime = endTime;
		this.calendar = calendar;
		//this.location = location;
		//this.patient = patient;
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
	 * Setter for the calendar
	 * @param calendar The Calendar who belongs to the Appointment /Calendar
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
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
	 * Getter for the calendar
	 * @return calendar The Calendar who belongs to the Appointment /Calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}
}
