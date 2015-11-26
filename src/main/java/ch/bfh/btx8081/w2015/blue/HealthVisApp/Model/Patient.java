package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.sql.Date;


public class Patient extends Person {

	private int id;
	private Note comment;
	private Treatment treatment;
	private Appointment appointment;
	private HealthVisitor healthvisitor;
	
	
	public Patient(String name, String firstName, Date birthdate,
			Address address, String phone, int id, Note comment, Treatment treatment, Appointment appointment, HealthVisitor healthvisitor) {
		super(name, firstName, birthdate, address, phone);
		this.id = id;
		this.comment = comment;
		this.treatment = treatment;
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
		

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Note getComment() {
		return comment;
	}


	public void setComment(Note comment) {
		this.comment = comment;
	}


	public Treatment getTreatment() {
		return treatment;
	}


	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}


	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}


	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}

}
