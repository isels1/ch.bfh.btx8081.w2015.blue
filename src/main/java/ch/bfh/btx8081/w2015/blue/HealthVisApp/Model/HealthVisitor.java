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

	
	public HealthVisitor(String name, String firstName, Date birthdate,
			Address address, String phone){
		super(name, firstName, birthdate, address, phone);
	}
	
	public HealthVisitor(String name, String firstName, Date birthdate,
			Address address, String phone, String userName, String password, Calendar calendar, ArrayList<Patient> patient) {
		super(name, firstName, birthdate, address, phone);
		
		this.userName = userName;
		this.password = password;
		this.calendar = calendar;
		this.patient = patient;
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
	 * @param userName The Username /String
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * The getter for the password
	 * @param password The Password /String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * The getter for the calendar
	 * @param calendar The Calendar /Calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	public ArrayList<Patient> getPatient() {
		return patient;
	}

}
