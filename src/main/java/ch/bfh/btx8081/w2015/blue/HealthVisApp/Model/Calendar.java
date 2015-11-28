package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.ArrayList;
import java.util.Date;


public class Calendar {
	
	//================================================================================
    // Calendar Data
    //================================================================================
	
	private ArrayList<Appointment> appointment;
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Calendar(ArrayList<Appointment> appointment, HealthVisitor healthvisitor)
	{
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
	}
	
	//================================================================================
    // Add/Setter Section
    //================================================================================
	
	public void newAppointment(Date startTime, Date endTime, String ort, 
									  Patient patient, HealthVisitor healthvisitor)
	{
		Appointment newAppointment = new Appointment(startTime, endTime, ort, patient, healthvisitor);
		if(checkAvailability(newAppointment)) {
		appointment.add(newAppointment);
		}
	}
	
	public void setHealthVisitor(HealthVisitor hv){
		healthvisitor = hv;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	public ArrayList<Appointment> getAppointments() {
		return appointment;
	}
	
	public HealthVisitor getHealthVisitor() {
		return healthvisitor;
	}
	
	//================================================================================
    // Helper/Private Section
    //================================================================================
	
	private boolean checkAvailability(Appointment app)
	{
		for (Appointment i: appointment )
		{
			//Existing times to compare 
			Date oldStartTime = i.getStartTime();
			Date oldEndTime = i.getEndTime();
			
			//new time to compare
			Date newStartTime = app.getStartTime();
			Date newEndTime = app.getEndTime();
			
			//Checks if the new Appointment is entirely before or entirely after the old one,
			//if the end-and start-time is the same it's also ok.
			//if not returns false.
			if (!((newStartTime.before(oldStartTime) && 
					(newEndTime.before(oldStartTime) || newEndTime.equals(oldStartTime)))
				||((newStartTime.after(oldEndTime) || newStartTime.equals(oldEndTime))
					&& (newEndTime.after(oldEndTime))))
					)  
			{
				return false;
			}
			

			
			
		}		
		return true;
		
	}
		
}
