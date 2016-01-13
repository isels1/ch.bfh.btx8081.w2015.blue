package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
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
 * 			<i>Model.Calendar</i>
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
 * 		<li>calendar</li>
 *		<li>patient</li>
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
@Entity
@DiscriminatorValue("H")
@Table(name="healthVisitor")
public class HealthVisitor extends Person {
	
	//================================================================================
    // HealthVisitor Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	
	private String userName;
	private String password;
	
	@Transient
	private Calendar calendar;
	
	@OneToMany(mappedBy = "healthVisitor")
	private ArrayList<Patient> patient = new ArrayList<Patient>();

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
	
	/**
	 * This constructor initialize the HealthVisitor with the necessary information
	 * <br>
	 * <br>
	 * @param name The Name of the Healthvisitor /String
	 * @param firstName The first Name of the Healthvisitor /String
	 * @param birthdate the birthdate of the Healthvisitor /Date
	 * @param address the address of the Healthvisitor /Address
	 * @param phone the phone number of the Healthvisitor /String
	 */
	
	public HealthVisitor(String name, String firstName, Date birthdate,
			Address address, String phone){
		super(name, firstName, birthdate, address, phone);
	}
	

	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the userName
	 * @param userName The Username /String
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setAllPatients(ArrayList<Patient> patient) {
		this.patient.addAll(patient);
	}
	
	public void setPatient(Patient p){
		this.patient.add(p);
	}

	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the userName
	 * @return The Username /String
	 */
	public String getUserName() {
		return userName;
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

	public ArrayList<Patient> getPatient() {
		return patient;
	}
	

	/**
	 * The string representation is "name firstName birthdate aStreet aStreetNr aZIP aCity phone"
	 * @return the string representation of the person /String
	 */
	@Override
	public String toString() {
		String aString = super.toString();
		if (!(userName==null)) 
			{aString = aString + ", " + userName;}
		return aString;
	}
	
	/**
	  * Compares two health visitor and tests if they are the same
	  * @return if the username, password and calendar of the health visitor objects are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if(obj != null) {
			HealthVisitor hv = (HealthVisitor) obj;
			return super.equals(hv);
//			boolean username = this.userName.equals(hv.userName);
//			boolean password = this.password.equals(hv.password);
//			boolean calendar = this.calendar.equals(hv.calendar);
			
//			return (username && password && calendar);
		}
		return false;
	}
}
