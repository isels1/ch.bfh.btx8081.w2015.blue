package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
			BasicEvent e = new BasicEvent(a.getOrt(),
					a.getHealthvisitor().getName() + " " + a.getHealthvisitor().getFirstName(),
					a.getStartTime().getTime(), a.getEndTime().getTime());
			
			events.add(e);
		}
		
//        GregorianCalendar start1 = new GregorianCalendar();
//		GregorianCalendar end1   = new GregorianCalendar();
//		start1.add(java.util.Calendar.HOUR, 2);
//		end1.add(java.util.Calendar.HOUR, 4);
//		BasicEvent event1 = new BasicEvent("Calendar study1",
//		        "Learning how to use Vaadin Calendar",
//		        start1.getTime(), end1.getTime());
//		
//		GregorianCalendar start2 = new GregorianCalendar();
//		GregorianCalendar end2   = new GregorianCalendar();
//		start2.add(java.util.Calendar.HOUR, 4);
//		end2.add(java.util.Calendar.HOUR, 6);
//		BasicEvent event2 = new BasicEvent("Calendar study2",
//		        "Learning more",
//		        start2.getTime(), end2.getTime());
//		
//		GregorianCalendar start3 = new GregorianCalendar();
//		GregorianCalendar end3   = new GregorianCalendar();
//		start3.add(java.util.Calendar.HOUR, 8);
//		end3.add(java.util.Calendar.HOUR, 12);
//		BasicEvent event3 = new BasicEvent("Calendar study3",
//		        "Learning much more",
//		        start3.getTime(), end3.getTime());
//		
//        events.add(event1);
//        events.add(event2);
//        events.add(event3);
		return events;
	}

}
