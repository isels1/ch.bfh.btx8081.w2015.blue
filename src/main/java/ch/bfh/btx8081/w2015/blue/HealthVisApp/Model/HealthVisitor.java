package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		HealthVisitor
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a healthvisitor. 
 * </span>
 * <br>
 * <br>
 * The Healthvisitor contains following information:
 * 	<ul>
 *  	<li>
 * 			<font face="courier new">
 * 				id:
 * 			</font> 
 * 			<i>int</i>
 * 			- The id of the healthvisitor
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				userName:
 * 			</font> 
 * 			<i>String</i>
 * 			- The username of the healthvisitor
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				password:
 * 			</font> 
 * 			<i>String</i>
 * 			- The password of the healthvisitor
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				calendar:
 * 			</font> 
 * 			<i>Calendar</i>
 * 			- the calendar of the healthvisitor
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				patient:
 * 			</font> 
 * 			<i>ArrayList<Patient></i>
 * 			- The patients who are assigned to the healthvisitor
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new healthvisitor you need necessary at least following informations:
 * 	<ul>
 * 		<li>userName</li>
 * 		<li>password</li>
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
@DiscriminatorValue("hv")
@Table(name="healthVisitor")
public class HealthVisitor extends Person {
	
	//================================================================================
    // HealthVisitor Data
    //================================================================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	private String username;
	private String password;
	
	@Transient
	private Calendar calendar;
	
	@OneToMany(mappedBy = "healthVisitor")
	private List<Patient> patient = new ArrayList<Patient>();
	@OneToMany(mappedBy="healthVisitor")
	private List<Appointment> appointments = new ArrayList<Appointment>();

	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor is used for the login
	 * <br>
	 * <br>
	 * @param userName Username of the Healthvisitor /String
	 * @param password The password of the Healthvisitor /String
	 */
	public HealthVisitor(String userName, String password) {
		super();
	}
	
	public HealthVisitor(){
	}

	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the userName
	 * @param userName The Username /String
	 */
	public void setUserName(String userName) {
		this.username = userName;
	}
	/**
	 * The setter for the password
	 * @param password The Password /String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * The setter for the calendar
	 * @param calendar The Calendar /Calendar
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	/**
	 * The setter for the patients
	 * @param patient The patients /ArrayList<Patient>
	 */
	public void setAllPatients(ArrayList<Patient> patient) {
		this.patient.addAll(patient);
	}
	/**
	 * adds a new patient to the list
	 * @param patient The patient /Patient
	 */
	public void setPatient(Patient p){
		this.patient.add(p);
	}

	public void addAppointment(Appointment a){
		this.appointments.add(a);
	}
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the userName
	 * @return The Username /String
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * The getter for the password
	 * @return The Password /String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * The getter for the calendar
	 * @return The Calendar /Calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}
	/**
	 * The getter for the patient
	 * @return The patients /ArrayList<Patient>
	 */
	public List<Patient> getPatient() {
		return patient;
	}
	
	public List<Appointment> getAppointment(){
		return appointments;
	}

	/**
	 * The string representation is "name, firstName, birthdate, aStreet, aStreetNr, aZIP, aCity, phone, username"
	 * @return the string representation of the person /String
	 */
	@Override
	public String toString() {
		String aString = super.toString();
		if (!(username==null)) 
			{aString = aString + ", " + username;}
		return aString;
	}
	
	/**
	  * Compares two health visitors and tests if they are the same
	  * @return if the name, firstName, birthdate, address and phone are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if(obj != null) {
			HealthVisitor hv = (HealthVisitor) obj;
			return super.equals(hv);
		}
		return false;
	}
}
