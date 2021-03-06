package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Treatment
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a treatment. 
 * </span>
 * <br>
 * <br>
 * The Treatment contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				id:
 * 			</font> 
 * 			<i>int</i>
 * 			- The id of the treatment
 * 		</li>
 *  * 	<li>
 * 			<font face="courier new">
 * 				patientId:
 * 			</font> 
 * 			<i>int</i>
 * 			- The id of the patient
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				doctor:
 * 			</font> 
 * 			<i>String</i>
 * 			-  The doctor who administered the treatment
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				date:
 * 			</font> 
 * 			<i>GregorianCalendar</i>
 * 			- The date the treatment was administered
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				description:
 * 			</font> 
 * 			<i>String</i>
 * 			- The description of the treatment
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new treatment you need at least following information:
 * 	<ul>
 * 		<li>id</li>
 * 		<li>patientId</li>
 * 		<li>doctor</li>
 * 		<li>date</li>
 * 		<li>description</li>
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
 * @author hugil1, nosec1, isels1, dornt1, zwahf1
 * @version 0.0
 */
@Entity
@Table(name = "treatment")
public class Treatment {
	//================================================================================
    // Treatment Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String doctor; 
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar date;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor is used for testing.
	 */
	public Treatment() {
	}
	
	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the id
	 * @param id The id of the Treatment /int
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * The setter for the patientId
	 * @param patientId The id of the Patient /int
	 */
	public void setPatientId(Patient patientId) {
		this.patient = patientId;
	}
	
	/**
	 * The setter for the doctor
	 * @param doctor The doctor who administered the Treatment /String
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * The setter for the date
	 * @param date The date of the Treatment /GregorianCalendar
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	/**
	 * The setter for the description
	 * @param description The description of the Treatment /String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the id
	 * @return id the id of the Treatment /int
	 */
		public int getId() {
		return id;
	}
	
	/**
	 * The getter for the patientId
	 * @return patientId the id of the patient /int
	 */
		public Patient getPatientId() {
		return patient;
	}
		
	/**
	 * The getter for the Doctor
	 * @return Doctor the Doctor who administered the Treatment /String
	 */
	
	public String getDoctor() {
		return doctor;
	}
						
	/**
	 * The getter for the date
 	 * @return date the date of the Treatment /GregorianCalendar
 	 */
 	
 	public GregorianCalendar getDate() {
 		return date;
 	}
		
 	/**
 	 * The getter for the description
 	 * @return description the description of the Treatment /String
 	 */
		
 	public String getDescription() {
 		return description;
	}
	
 	
 	
	/**
	 * The string representation is "id, patientId, doctor, date, description"
	 * @return the String representation of the treatment /String
	 */
	@Override
	public String toString() {
		String aString = "";
		
		if (!(date == null)){
			aString = aString + "" + getNumberRepresentation(String.valueOf(date.get(GregorianCalendar.DAY_OF_MONTH)))
					+ "." + getNumberRepresentation(String.valueOf(date.get(GregorianCalendar.MONTH + 1)))
					+ "." + String.valueOf(date.get(GregorianCalendar.YEAR));
		}
		
		if (!(doctor == null)){
			aString = aString + "; " + doctor;
		}
		
		if (!(description == null)){
			aString = aString + "; " + description;
		}
		
		return aString;
	}
	
	private String getNumberRepresentation(String min) {
		String rep = "";
		if(min.length() == 1) {
			rep = "0" + min;
		}
		else {
			rep = "" + min;
		}
		return rep;
	}
}
