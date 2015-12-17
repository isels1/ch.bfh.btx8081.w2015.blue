package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Calendar
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		represent a calendarobject
 * </span>
 * <br>
 * <br>
 * The Calendar contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				appointment:
 * 			</font> 
 * 			<i>ArrayList<Appointment></i>
 * 			- List with appointments
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				healthvisitor:
 * 			</font> 
 * 			<i>HealthVisitor</i>
 * 			- The responsible healthvisitor
 * 		</li>
 *	 </ul>
 * <br>
 * To create a calendarobject you need necessary at least following informations:
 * 	<ul>
 * 		<li>appointment</li>
 * 		<li>healthvisitor</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		16.12.2015
 * </span>
 * <br><br>
 * @author hugil1
 * @version 0.0
 */
public class Calendar {
	
	//================================================================================
    // Calendar Data
    //================================================================================
	
	private ArrayList<Appointment> appointment = new ArrayList<Appointment>();
	private HealthVisitor healthvisitor;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor is used for testing.
	 */
	
	public Calendar(){
		
	}
	/**
	 * This constructor initialize the calendar with the necessary information
	 * <br>
	 * <br>
	 * @param Appointment List with Appointments /ArrayList<Appointment>
	 * @param Healthvisitor The responsible Healthvisitor /HealthVisitor
	 */
	public Calendar(ArrayList<Appointment> appointment, HealthVisitor healthvisitor)
	{
		this.appointment = appointment;
		this.healthvisitor = healthvisitor;
	}
	
	//================================================================================
    // Add/Setter Section
    //================================================================================
	
	/**
	 * add a new appointment to the calendar if not conflicted with others
	 * @param newAppointment: Appointment
	 * @return true if appointment has no conflict otherwise false
	 */
	public boolean newAppointment(Appointment newAppointment)
	{
		if(checkAvailability(newAppointment)) {
			appointment.add(newAppointment);
			return true;
		}
		return false;
	}
	/**
	 * Setter for the appointment
	 * @param a add a single Appointment /appointment
	 */
	public void setAppointment(Appointment a){
		appointment.add(a);
	}
	/**
	 * Setter for the appointment
	 * @param al add all Appointments /appointment
	 */
	public void setAppointments(ArrayList<Appointment> al){
		appointment.addAll(al);
	}
	/**
	 * Setter for the healthvisitor
	 * @param hv Add a Healthvisitor  /healthvisitor
	 */
	public void setHealthVisitor(HealthVisitor hv){
		healthvisitor = hv;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * Getter for the appointment
	 * @return Returns all Appointments: ArrayList<Appointment>
	 */
	public ArrayList<Appointment> getAppointments() {
		return appointment;
	}
	/**
	 * Getter for the healthvisitor
	 * @return the Healthvisitor  /healthvisitor
	 */
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
			
			//new times to compare
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
