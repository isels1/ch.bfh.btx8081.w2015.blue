package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.sql.Date;
import java.util.ArrayList;


public class HealthVisitor extends Person {
	
	private String userName;
	private String password;
	private Calendar calendar;
	private ArrayList<Patient> patient;

	public HealthVisitor(String name, String firstName, Date birthdate,
			Address address, String phone, String userName, String password, Calendar calendar, ArrayList<Patient> patient) {
		super(name, firstName, birthdate, address, phone);
		
		this.userName = userName;
		this.password = password;
		this.calendar = calendar;
		this.patient = patient;
		
		
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public ArrayList<Patient> getPatient() {
		return patient;
	}

	public void setPatient(ArrayList<Patient> patient) {
		this.patient = patient;
	}

}
