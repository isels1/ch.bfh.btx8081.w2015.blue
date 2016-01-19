package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
 * The Appointment contains following information:
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
 * 			<i>Calendar</i>
 * 			- The calendar in which the Appointment is
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
 * To create a new appointment you necessarily need at least the following information:
 * 	<ul>
 * 		<li>startTime</li>
 * 		<li>endTime</li>
 * 		<li>location</li>
 *		<li>patient</li>
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
 * @author hugil1, nosec1, zwahf1, dornt1, isels1
 * @version 1.0
 */
@Entity
@Table(name = "appointment")
public class Appointment {
	
	//================================================================================
    // Appointment Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar startTime;
    
    @Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar endTime;
    
	private String location;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="healthVisitorId")
	private HealthVisitor healthVisitor;
	
	@Transient
	private Calendar calendar;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="noteId")
	private Note note;
	
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
	
	public void setHealthVisitor(HealthVisitor hv) {
		this.healthVisitor = hv;
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
		this.note = comment;
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
		return note;
	}
	
	//================================================================================
	// Methods Section
	//================================================================================

	 /**
	  * The string representation is "startTime, endTime, location, comment"
	  * @return the string representation of the person /String
	  */
	@Override
	public String toString() {
		String aString = super.toString();
		
		if (!(startTime==null))
		{aString = aString + ", " + startTime;}
		
		if (!(endTime==null))
		{aString = aString + ", " + endTime;}
		
		if (!(location==null))
		{aString = aString + ", " + location;}
		
		aString = aString + ", " + patient.toString();
		
		return aString;
	}
	
	 /**
	  * Compares two Appointments and tests if they are the same
	  * @return if the startTime, endTime, location and patient of the Person objects are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if(obj != null) {
			Appointment app = (Appointment) obj;
			boolean start = this.startTime.equals(app.startTime);
			boolean end = this.endTime.equals(app.endTime);
			boolean loc = this.location.equals(app.location);
			boolean pat = this.patient.equals(app.patient);
			
			return (start && end && loc && pat);
		}
		return false;
	}
}
