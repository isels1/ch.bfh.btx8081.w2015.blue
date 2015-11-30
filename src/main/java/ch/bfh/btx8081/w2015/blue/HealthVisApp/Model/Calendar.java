package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Calendar {
	
	//================================================================================
    // Calendar Data
    //================================================================================
	
	private ArrayList<Appointment> appointment = new ArrayList<Appointment>();
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public Calendar(){
		
	}
	
	public Calendar(ArrayList<Appointment> appointment, HealthVisitor healthvisitor)
	{
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
	}
	
	//================================================================================
    // Add/Setter Section
    //================================================================================
	
	public void newAppointment(GregorianCalendar startTime, GregorianCalendar endTime, String location, 
									  Patient patient, HealthVisitor healthvisitor)
	{
		Appointment newAppointment = new Appointment(startTime, endTime, location, patient, healthvisitor);
		if(checkAvailability(newAppointment)) {
		appointment.add(newAppointment);
		}
	}
	
	public void setAppointment(Appointment a){
		appointment.add(a);
	}
	
	public void setAppointments(ArrayList<Appointment> al){
		appointment.addAll(al);
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
			GregorianCalendar oldStartTime = i.getStartTime();
			GregorianCalendar oldEndTime = i.getEndTime();
			
			//new time to compare
			GregorianCalendar newStartTime = app.getStartTime();
			GregorianCalendar newEndTime = app.getEndTime();
			
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
