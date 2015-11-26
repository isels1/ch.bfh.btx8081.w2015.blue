package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.ArrayList;
import java.util.Date;


public class Calendar {
	
	private ArrayList<Appointment> appointment;
	private HealthVisitor healthvisitor;
	
	public Calendar(ArrayList<Appointment> appointment, HealthVisitor healthvisitor)
	{
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
	}
	

	public void newAppointment(Date startTime, Date endTime, String ort, 
									  Patient patient, HealthVisitor healthvisitor)
	{
		Appointment newAppointment = new Appointment(startTime, endTime, ort, patient, healthvisitor);
		if(checkAvailability(newAppointment)) {
		appointment.add(newAppointment);
		}
	}
	
	
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
