package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * 				treatment:
 * 			</font> 
 * 			<i>String</i>
 * 			- The treatment for the Patient
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new treatment you need necessary at least following informations:
 * 	<ul>
 * 		<li>treatment</li>
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
 * @author hugil1, nosec1
 * @version 0.0
 */
@Entity
@Table(name = "treatment")
public class Treatment {
	//================================================================================
    // Treatment Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@ManyToOne
	private int patientId;
	
	private String doctor;
	
    @Temporal(TemporalType.DATE)
	private GregorianCalendar date;
	
	private String description;
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
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
		public int getPatientId() {
		return patientId;
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
	 * The string representation is "id patientId doctor date description"
	 * @return the String representation of the treatment /String
	 
	@Override
	public String toString() {
		String aString = "";
		
		if (!(id==null))
		{aString = aString + ", " + name;}
		
		if (!(firstName==null))
		{aString = aString + ", " + firstName;}
		
		if (!(birthdate==null))
		{aString = aString + ", " + birthdate;}
		
		aString = aString + ", " + addr;
		
		if (!(phone==null))
		{aString = aString + ", " + phone;}
		
		return aString;
	}
	*/

}
