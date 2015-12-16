package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;

import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		AppointmentEventProvider
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>implements</b> CalendarEventProvider
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...provides the events (appointments) for the callendar
 * </span>
 * <br>
 * <br>
 * The AppointmentEventProvider contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				ddc:
 * 			</font> 
 * 			<i>DummyDataCreator</i>
 * 			- The dummy data creator to get the events... later on it will be replaced with the persistence layer
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		xx.xx.2015
 * </span>
 * <br><br>
 * @author zwahf1, dornt1, isels1
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AppointmentEventProvider implements CalendarEventProvider {

	//================================================================================
    // EventProvider Data
    //================================================================================
	
	private DummyDataCreator ddc;
	
	//================================================================================
    // Setter Section
    //================================================================================
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * Get all events in a given range from the calendar
	 * @param startDate: Date
	 * @param endDate: Date
	 * 
	 * @return events: List<CalendarEvent>
	 */
	@Override
	public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
		
		ddc = DummyDataCreator.getInstance();
		
		List<CalendarEvent> events = new ArrayList<CalendarEvent>();

		Calendar calendarObject= ddc.getCalendar();
		
		ArrayList<Appointment> al = calendarObject.getAppointments();
		
		for(Appointment a : al){
			BasicEvent e = new BasicEvent(a.getlocation(),
					a.getPatient().getName() + " " + a.getPatient().getFirstName(),
					a.getStartTime().getTime(), a.getEndTime().getTime());
			
			events.add(e);
		}
		
		return events;
	}
}
