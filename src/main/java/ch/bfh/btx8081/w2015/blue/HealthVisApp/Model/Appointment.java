package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.GregorianCalendar;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Appointment
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates an appointment of a Healthvisitor.
 * </span>
 * <br>
 * <br>
 * The appointment contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				startTime:
 * 			</font> 
 * 			<i>GregorianCalendar</i>
 * 			- The start time of the Appointment
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				endTime:
 * 			</font> 
 * 			<i>GregorianCalendar</i>
 * 			- The end time of the Appointment
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				location:
 * 			</font> 
 * 			<i>String</i>
 * 			- The location where the appointment is
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				patient:
 * 			</font> 
 * 			<i>Patient</i>
 * 			- The patient, with which the Healthvisitor has the appointment.
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				calendar:
 * 			</font> 
 * 			<i>Model.Calendar</i>
 * 			- 
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				comment:
 * 			</font> 
 * 			<i>Note</i>
 * 			- A potential note for the Appointment
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new address you need necessary at least following informations:
 * 	<ul>
 * 		<li>startTime</li>
 * 		<li>endTime</li>
 * 		<li>location</li>
 *		<li>patient</li>
 *		<li>calendar</li>
 *		<li>comment</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		16.12.2015
 * </span>
 * <br><br>
 * @author hugil1
 * @version 0.0
 */
public class Appointment {
	
	//================================================================================
    // Appointment Data
    //================================================================================
	
	private GregorianCalendar startTime;
	private GregorianCalendar endTime;
	private String location;
	private Patient patient;
	private Calendar calendar;
	private Note comment;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor is used for testing.
	 */
	
	public Appointment(){
		
	}
	/**
	 * This constructor initialize the appointment with the necessary information
	 * <br>
	 * <br>
	 * @param startTime The Time when the Appointment starts /GregorianCalendar
	 * @param endTime The Time when the Appointment ends /GregorianCalendar
	 * @param location The location where the appointment is /String
	 * @param patient The Patient who has the Appointment /Patient
	 */
	public Appointment(GregorianCalendar startTime, GregorianCalendar endTime, String location, Patient patient){	
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.patient = patient;
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
	
	/**
	 * Setter for the comment
	 * @param comment The note who belongs to the Appointment /Note
	 */
	public void setComment(Note comment) {
		this.comment = comment;
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
	
	/**
	 * Getter for the comment
	 * @return comment The Note who belongs to the Appointment /Note
	 */
	public Note getComment() {
		return comment;
	}
	
	//================================================================================
	// Methods Section
	//================================================================================

	 /**
	  * The string representation is "startTime endTime location comment"
	  * @return the string representation of the person /String
	  */
	@Override
	public String toString() {
		String aString = super.toString();
		
		if (!startTime.equals(null))
		{aString = aString + ", " + startTime;}
		
		if (!endTime.equals(null))
		{aString = aString + ", " + endTime;}
		
		if (!location.equals(null))
		{aString = aString + ", " + location;}
		
		aString = aString + ", " + patient.toString();
		
		return aString;
	}
}
