package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import java.util.Locale;
import java.util.TimeZone;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.AppointmentEventProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Calendar.TimeFormat;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

public class CalendarView {


	
		//================================================================================
	    // CalendarView Data
	    //================================================================================
			final static String CALWIDTH = "260";
			final static String CALHEIGHT= "448";
			private static CalendarView calView = null;
			private VerticalLayout calendarTab;
		
		//================================================================================
	    // Constructor Section
	    //================================================================================
		
		private CalendarView(){
	        CalendarEventProvider dataSource = new BasicEventProvider();
	        Calendar cal = null;
	        cal = new Calendar(dataSource);
	        cal.setWidth(CALWIDTH + "px");
	        cal.setHeight(CALHEIGHT + "px");
	        
	        //show only 0600h to 2000h
//	        cal.setFirstVisibleHourOfDay(6);
//			cal.setLastVisibleHourOfDay(20);
			
			//show only Monday to Friday
			// --IMPORTANT: do only if weekly view. Daily and Monthly like that is buggy as fu**
//			cal.setFirstVisibleDayOfWeek(1);
//			cal.setLastVisibleDayOfWeek(5);
			
			//German Language and time zone 
			cal.setLocale(Locale.GERMAN);
			cal.setTimeFormat(TimeFormat.Format24H);
			cal.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
			//set Format to European standard
			cal.setWeeklyCaptionFormat("dd.MM.yyyy");
			
			//show daily view of calendar
			cal.setStartDate(new Date());
			cal.setEndDate(new Date());
			
			// Add events
			AppointmentEventProvider appointmentProvider = new AppointmentEventProvider();
			
			for(CalendarEvent i : appointmentProvider.getEvents(new Date(), new Date())) {
				cal.addEvent(i);
			}

			Button addApp = new Button("Add Apointment");
	        
			addApp.addClickListener(new CalendarButtonClickHandler());
	        
	        calendarTab = new VerticalLayout();
	        calendarTab.addComponent(cal);
	        calendarTab.addComponent(addApp);
		}
		
		public static CalendarView getInstance() {
			if (calView == null) {
				calView = new CalendarView();
			}
			return calView;
		}
		
		public VerticalLayout getCalendarView(){	
			return calendarTab;
		}
	}

