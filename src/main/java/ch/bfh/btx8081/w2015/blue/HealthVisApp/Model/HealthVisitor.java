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
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

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
    // Setter Section
    //================================================================================

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public ArrayList<Patient> getPatient() {
		return patient;
	}

}
