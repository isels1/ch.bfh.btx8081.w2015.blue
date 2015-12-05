package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.HorizontalLayout;
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
/**
 * This class Crates a Vertical Layout for the Calendar View
 * 
 *  The Layout Contains:
 *   three Buttons for changing the View(Monthly,Weekly and daily)
 *   One Calendar Object
 *   One Button for adding a new Appointment
 * @author Tim
 *
 */
public class CalendarView {
	
		//================================================================================
	    // CalendarView Data
	    //================================================================================
			final static String CALWIDTH = "282";
			final static String CALHEIGHT= "410";
			
			final static String BUTTONWIDTH = "94";
			
			private static CalendarView calView = null;
			private VerticalLayout calendarTab;
			private Calendar cal = null;
			
			HorizontalLayout headerLayout  = null;
		//================================================================================
	    // Constructor Section
	    //================================================================================
		
		private CalendarView(){
	        
			initCalendar();	
			//Great a Horizontal Layout whit 3 Buttons
			initHeaderLayout();

			// Add events
			AppointmentEventProvider appointmentProvider = new AppointmentEventProvider();
			
			//Fill the Calendar whit all existing Appointments
			for(CalendarEvent i : appointmentProvider.getEvents(new Date(), new Date())) {
				cal.addEvent(i);
			}
			
			//Add Button for new Appointments
			Button addApp = new Button("Add Apointment");
			addApp.setWidth(CALWIDTH);
			addApp.setIcon(FontAwesome.CALENDAR);
	
			addApp.addClickListener(new CalendarButtonClickHandler());
	        
			//Add all Components of this View to the Vertical Layout
	        calendarTab = new VerticalLayout();
	        calendarTab.addComponent(headerLayout);
	        calendarTab.addComponent(cal);
	        calendarTab.addComponent(addApp);
		}
		//================================================================================
	    // Public Methods
	    //================================================================================
		/**
		 * This Methode Creates and Instance of the CalendarView Class if it not already exists
		 * @return A instance of the CalendarView class
		 * 
		 */
		public static CalendarView getInstance() {
			if (calView == null) {
				calView = new CalendarView();
			}
			return calView;
		}
		/**
		 * 
		 * @return the Calendar Object of the CalendarView class in a Vertical Layout
		 */
		public VerticalLayout getCalendarView(){	
			return calendarTab;
		}
		//================================================================================
	    // Private Methods
	    //================================================================================
		/**
		 * Init the Calendar 
		 */
		private void initCalendar(){
			CalendarEventProvider dataSource = new BasicEventProvider();
	        
	        cal = new Calendar(dataSource);
	        cal.setWidth(CALWIDTH + "px");
	        cal.setHeight(CALHEIGHT + "px");
	        
	        //show only 0600h to 2000h
	        cal.setFirstVisibleHourOfDay(6);
			cal.setLastVisibleHourOfDay(20);
			
			//show only Monday to Friday
			// --IMPORTANT: do only if weekly view. Daily and Monthly like that is buggy as fu**
			cal.setFirstVisibleDayOfWeek(1);
			cal.setLastVisibleDayOfWeek(5);
			
			//German Language and time zone 
			cal.setLocale(Locale.GERMAN);
			cal.setTimeFormat(TimeFormat.Format24H);
			cal.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
			//set Format to European standard
			cal.setWeeklyCaptionFormat("dd.MM.yyyy");
			
			//show daily view of calendar
			cal.setStartDate(new Date());
			cal.setEndDate(new Date());
		}
		/**
		 * Create all Buttons and add it to a Horizontal Layout
		 */
		private void initHeaderLayout(){
			
		headerLayout = new HorizontalLayout();
		
		Button b_MonthlyView = new Button("Month");
		b_MonthlyView.setWidth(BUTTONWIDTH);
		Button b_WeeklyView = new Button("Week");
		b_WeeklyView.setWidth(BUTTONWIDTH);
		Button b_DailyView = new Button("Day");
		b_DailyView.setWidth(BUTTONWIDTH);
		
		headerLayout.addComponent(b_MonthlyView);
		headerLayout.addComponent(b_WeeklyView);
		headerLayout.addComponent(b_DailyView);
		}
	}

