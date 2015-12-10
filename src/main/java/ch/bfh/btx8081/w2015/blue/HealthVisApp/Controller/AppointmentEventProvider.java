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
