package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.Calendar.TimeFormat;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

public class CalendarView {

	final static String CALWIDTH = "260";
	final static String CALHEIGHT= "448";
	
	public static Calendar initCalendarView()
	{
	
        CalendarEventProvider dataSource = new BasicEventProvider();
        Calendar cal = new Calendar(dataSource);
        cal.setWidth(CALWIDTH + "px");
        cal.setHeight(CALHEIGHT + "px");
        
        //show only 0600h to 2000h
        cal.setFirstVisibleHourOfDay(6);
		cal.setLastVisibleHourOfDay(20);
		
		//show only Monday to Friday
		// --IMPORTANT: do only if weekly view. Daily and Monthly like that is buggy as fu**
//		cal.setFirstVisibleDayOfWeek(1);
//		cal.setLastVisibleDayOfWeek(5);
		
		//German Language and time zone 
		cal.setLocale(Locale.GERMAN);
		cal.setTimeFormat(TimeFormat.Format24H);
		cal.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
		//set Format to European standard
		cal.setWeeklyCaptionFormat("dd.MM.yyyy");
		
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
		
		GregorianCalendar start2 = new GregorianCalendar();
		GregorianCalendar end2   = new GregorianCalendar();
		start2.add(java.util.Calendar.HOUR, 24);
		end2.add(java.util.Calendar.HOUR, 28);
		cal.addEvent(new BasicEvent("Calendar study2",
		        "Learning how to use Vaadin Calendar",
		        start2.getTime(), end2.getTime()));

		return cal;
	}
}
