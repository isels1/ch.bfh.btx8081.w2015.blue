package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.ArrayList;
import java.util.Date;



public class HealthVisitor extends Person {
	
	//================================================================================
    // HealthVisitor Data
    //================================================================================
	
	private String userName;
	private String password;
	private Calendar calendar;
	private ArrayList<Patient> patient = new ArrayList<Patient>();

	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor initialize the HealthVisitor with the necessary information
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
		if (!userName.equals(null)) 
			{aString = aString + ", " + userName;}
		return aString;
	}
}
