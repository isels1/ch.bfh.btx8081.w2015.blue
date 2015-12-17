package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateNew;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Patient
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a patient. 
 * </span>
 * <br>
 * <br>
 * The Patient contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				id:
 * 			</font> 
 * 			<i>integer</i>
 * 			- The identification number of the Patient
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				comment:
 * 			</font> 
 * 			<i>Note</i>
 * 			-  A potential note for the Patient
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				treatment:
 * 			</font> 
 * 			<i>Treatment</i>
 * 			-
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				appointment:
 * 			</font> 
 * 			<i>Appointment</i>
 * 			- 
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				healthvisitor:
 * 			</font> 
 * 			<i>HealthVisitor</i>
 * 			- 
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				state:
 * 			</font> 
 * 			<i>PatientState</i>
 * 			- 
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new Patient you need necessary at least following informations:
 * 	<ul>
 * 		<li>id</li>
 * 		<li>comment</li>
 * 		<li>treatment</li>
 *		<li>appointment</li>
 *		<li>healthvisitor</li>
 *		<li>state</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		17.12.2015
 * </span>
 * <br><br>
 * @author hugil1
 * @version 0.0
 */
public class Patient extends Person {
	
	//================================================================================
    // Patient Data
    //================================================================================
	
	private int id;
	private Note comment;
	private Treatment treatment;
	private Appointment appointment;
	private HealthVisitor healthvisitor;
	private PatientState state;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	public Patient(String name, String firstName, Date birthdate,
			Address address, String phone, int id) {
		super(name, firstName, birthdate, address, phone);
		this.id = id;
	}
	
	
	public Patient(String name, String firstName, Date birthdate,
			Address address, String phone, int id, Note comment, Treatment treatment, Appointment appointment, HealthVisitor healthvisitor) {
		super(name, firstName, birthdate, address, phone);
		this.id = id;
		this.comment = comment;
		this.treatment = treatment;
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
		this.state = new PatientStateNew();
	}

	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the id
	 * @param id The Id /Int
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * The setter for the comment
	 * @param comment The Comment /Note
	 */
	public void setComment(Note comment) {
		this.comment = comment;
	}
	/**
	 * The setter for the treatment
	 * @param treatment The Treatment /Treatment
	 */
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	/**
	 * The setter for the appointment
	 * @param appointment The Appointment /Appointment
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	/**
	 * The setter for the healthvisitor
	 * @param healthvisitor The Healthvisitor /Healthvisitor
	 */
	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}
	/**
	 * The setter for the Patient State
	 * @param state The State of the Patient /PatientState
	 */
	public void setPatientState(PatientState state){
		this.state = state;
	}

	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the id
	 * @return The Id /Int
	 */
	public int getId() {
		return id;
	}
	/**
	 * The getter for the comment
	 * @return The Comment /Note
	 */
	public Note getComment() {
		return comment;
	}
	/**
	 * The getter for the treatment
	 * @return The Treatment /Treatment
	 */
	public Treatment getTreatment() {
		return treatment;
	}
	/**
	 * The getter for the appointment
	 * @return The Appointment /Appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	/**
	 * The getter for the healthvisitor
	 * @return The Healthvisitor /Healthvisitor
	 */
	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}
	/**
	 * The setter for the Patient State
	 * @return state The State of the Patient /PatientState
	 */
	public PatientState getPatientState(){
		return state;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String returnString = "" + super.getName() + " " + super.getFirstName() +" " + id;
//		returnString = String.format("%20s %20s %5s" ,super.getName(),super.getFirstName(),id);
//		System.out.println(String.format("%20s %20s %5s" ,super.getName(),super.getFirstName(),id));
		return returnString;
	}
	 /**
	  * Compares two patients and tests if they are the same
	  * @return if the IDs of the Patient objects are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if (obj != null) {
			Patient pat = (Patient) obj;
			return this.getId() == pat.getId();
		}
		return false;
	}
	
}
