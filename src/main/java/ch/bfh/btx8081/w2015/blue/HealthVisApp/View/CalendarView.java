package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

public class CalendarView {

	
	public static Calendar initCalendarView()
	{
	
        CalendarEventProvider dataSource = new BasicEventProvider();
        Calendar cal = new Calendar(dataSource);
        cal.setWidth("260px");
        cal.setHeight("500px");
		cal.setFirstVisibleHourOfDay(6);
		cal.setLastVisibleHourOfDay(20);
		cal.setFirstVisibleDayOfWeek(1);
		cal.setLastVisibleDayOfWeek(5);
		
		cal.setWeeklyCaptionFormat("dd-MM-yyyy");
		

		
		return cal;
	}
}
