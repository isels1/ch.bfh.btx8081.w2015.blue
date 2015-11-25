package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;
import java.util.GregorianCalendar;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

public class CalendarView {

	
	public static Calendar initCalendarView()
	{
	
        CalendarEventProvider dataSource = new BasicEventProvider();
        Calendar cal = new Calendar(dataSource);
        cal.setWidth("260px");
        cal.setHeight("500px");
      //show only 0600h to 2000h
        cal.setFirstVisibleHourOfDay(6);
		cal.setLastVisibleHourOfDay(20);
		//show only Monday to Friday
		cal.setFirstVisibleDayOfWeek(1);
		cal.setLastVisibleDayOfWeek(5);
		
		//show daily view of calendar
		cal.setStartDate(new Date());
		cal.setEndDate(new Date());
		
		// Add a two-hour event
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end   = new GregorianCalendar();
		end.add(java.util.Calendar.HOUR, 2);
		cal.addEvent(new BasicEvent("Calendar study",
		        "Learning how to use Vaadin Calendar",
		        start.getTime(), end.getTime()));
		
		cal.setWeeklyCaptionFormat("dd-MM-yyyy");
		

		
		return cal;
	}
}
