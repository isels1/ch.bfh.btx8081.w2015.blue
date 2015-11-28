package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.sql.Date;


public class Patient extends Person {
	
	//================================================================================
    // Patient Data
    //================================================================================
	
	private int id;
	private Note comment;
	private Treatment treatment;
	private Appointment appointment;
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Patient(String name, String firstName, Date birthdate,
			Address address, String phone, int id, Note comment, Treatment treatment, Appointment appointment, HealthVisitor healthvisitor) {
		super(name, firstName, birthdate, address, phone);
		this.id = id;
		this.comment = comment;
		this.treatment = treatment;
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
	}

	//================================================================================
    // Setter Section
    //================================================================================
	
	public void setId(int id) {
		this.id = id;
	}

	public void setComment(Note comment) {
		this.comment = comment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	public void setHealthvisitor(HealthVisitor healthvisitor) {
		this.healthvisitor = healthvisitor;
	}

	//================================================================================
    // Getter Section
    //================================================================================
	
	public int getId() {
		return id;
	}

	public Note getComment() {
		return comment;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public HealthVisitor getHealthvisitor() {
		return healthvisitor;
	}

}
