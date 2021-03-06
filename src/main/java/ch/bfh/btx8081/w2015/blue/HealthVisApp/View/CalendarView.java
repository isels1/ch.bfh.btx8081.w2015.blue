package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.AppointmentEventProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Calendar.TimeFormat;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		CalendarView
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		creates an instance of a Calendar View.
 * </span>
 * <br>
 * <br>
 * the CalendarView contains following Vaadin Elements:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a HorizontalLyout whit 3 Buttons:</b>
 * 			</font> 
 * 			<i>HorizontalLayout</i>
 * 			- 3 Buttons for change the View (daily, weekly and monthly)
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a VaadinCalendar:</b>
 * 			</font> 
 * 			<i>Calendar</i>
 * 			- a Calendar whit all appointments
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Button:</b>
 * 			</font> 
 * 			<i>Button</i>
 * 			- add a new appointment
 * 		</li>
 *	 </ul>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		01.12.2015
 * </span>
 * <br><br>
 * @author dornt1
 * @version 1.7
 */
public class CalendarView {
	
		//================================================================================
	    // CalendarView Data
	    //================================================================================
			final static String CALWIDTH = "318";
			final static String CALHEIGHT= "449";
			
			final static String BUTTONWIDTH = "106";
			
			private static CalendarView calView = null;
			private VerticalLayout calendarTab;
			private Calendar calendar = null;
			private HorizontalLayout headerLayout = null;
			
			private Button b_MonthlyView;
			private Button b_WeeklyView;
			private Button b_DailyView;
			private Button b_addApp;
		
		//================================================================================
	    // Constructor Section
	    //================================================================================
		private CalendarView(){
	        
			
			//Great a Horizontal Layout whit 3 Buttons
			initHeaderLayout();
			initCalendar();	
			// Add events
			AppointmentEventProvider appointmentProvider = new AppointmentEventProvider();
			
			//Fill the Calendar whit all existing Appointments
			for(CalendarEvent i : appointmentProvider.getEvents(new Date(), new Date())) {
				calendar.addEvent(i);
			}
			
			//Add Button for new Appointments
			b_addApp = new Button("Add Apointment");
			b_addApp.setWidth(CALWIDTH);
			b_addApp.setIcon(FontAwesome.CALENDAR);
	
			b_addApp.addClickListener(new CalendarButtonClickHandler());
	        
			//Add all Components of this View to the Vertical Layout
	        calendarTab = new VerticalLayout();
	        calendarTab.addComponent(headerLayout);
	        calendarTab.addComponent(calendar);
	        calendarTab.addComponent(b_addApp);
		}
		//================================================================================
	    // Public methods
	    //================================================================================
	
		//================================================================================
	    // getter and setter section
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
		/**
		 * @return the b_MonthlyView
		 */
		public Button getB_MonthlyView() {
			return b_MonthlyView;
		}
		/**
		 * @return the b_WeeklyView
		 */
		public Button getB_WeeklyView() {
			return b_WeeklyView;
		}
		/**
		 * @return the b_DailyView
		 */
		public Button getB_DailyView() {
			return b_DailyView;
		}
		/**
		 * @return the b_addApp
		 */
		public Button getB_addApp() {
			return b_addApp;
		}
		//================================================================================
	    // add new Appointment Section
	    //================================================================================

		/**
		 * shows new added Appointment from popup
		 * @param app: Appointment 
		 * @param cal Model.Calendar
		 */
		public void addNewApp(Appointment app, ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar cal) {
			
			BasicEvent e = new BasicEvent(app.getlocation(),
					app.getPatient().getName() + " " + app.getPatient().getFirstName(),
					app.getStartTime().getTime(), app.getEndTime().getTime());
			calendar.addEvent(e);
			calendarTab.replaceComponent(calendar, calendar);
		}		
		//================================================================================
	    // Methods to change the view (Daily, Weekly and Monthly)
	    //================================================================================	
		/**
		 * Set the view of the calendar to the actual Day
		 */
		public void changeToDaily()
		{
			calendar.setStartDate(new Date());
			calendar.setEndDate(new Date());
			
			calendar.setFirstVisibleDayOfWeek(1);
			calendar.setLastVisibleDayOfWeek(7);
		}	
		/**
		 * Set the view of the calendar to the actual Week
		 * only show Monday to Friday
		 */
		public void changeToWeekly()
		{	
			// Change the date range to the current week
			GregorianCalendar weekstart = new GregorianCalendar();
			GregorianCalendar weekend   = new GregorianCalendar();
			
			weekstart.setFirstDayOfWeek(java.util.Calendar.MONDAY);
			weekstart.set(java.util.Calendar.HOUR_OF_DAY, 0);
			weekstart.set(java.util.Calendar.DAY_OF_WEEK,
			               java.util.Calendar.MONDAY);
			weekend.set(java.util.Calendar.HOUR_OF_DAY, 23);
			weekend.set(java.util.Calendar.DAY_OF_WEEK,
			               java.util.Calendar.SUNDAY);
			calendar.setStartDate(weekstart.getTime());
			calendar.setEndDate(weekend.getTime());
			  
			calendar.setFirstVisibleDayOfWeek(2);
			calendar.setLastVisibleDayOfWeek(6);		
		}
		/**
		 * Set the view of the calendar to the actual Month
		 */
		public void changeToMonthly()
		{
			calendar.setFirstVisibleDayOfWeek(2);
			calendar.setLastVisibleDayOfWeek(6);

			// Set start date to first date in this month
			GregorianCalendar calStart = new GregorianCalendar();
			calendar.setStartDate(calStart.getTime());

			// Set end date to last day of this month
			GregorianCalendar calEnd = new GregorianCalendar();
			calEnd.set(java.util.Calendar.DATE, 1);
			calEnd.roll(java.util.Calendar.DATE, -1);
			calendar.setEndDate(calEnd.getTime());
		}
		
		//================================================================================
	    // Private Methods
	    //================================================================================
		
		/**
		 * Init the Calendar 
		 * standart View is the dailyView of the actual Day
		 */
		private void initCalendar(){
			CalendarEventProvider dataSource = new BasicEventProvider();
	        
	        calendar = new Calendar(dataSource);
	        calendar.setStyleName("HealthVisAppTheme");
	        calendar.setWidth(CALWIDTH + "px");
	        calendar.setHeight(CALHEIGHT + "px");
	        
	        //show only 0600h to 2000h	//Not in use because when appointments between not visible range the view is buggy
	        //calendar.setFirstVisibleHourOfDay(6);
			//calendar.setLastVisibleHourOfDay(20);
			
			//German Language and time zone 
			calendar.setLocale(new Locale("en", "US"));
			calendar.setTimeFormat(TimeFormat.Format24H);
			calendar.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
			//set Format to European standard
			calendar.setWeeklyCaptionFormat("dd.MM.yyyy");
			
			changeToDaily();
		}
		/**
		 * Create all Buttons and add it to a Horizontal Layout
		 */
		private void initHeaderLayout(){
			
			headerLayout = new HorizontalLayout();
			
			b_MonthlyView = new Button("Month");
			b_MonthlyView.setWidth(BUTTONWIDTH);
			b_MonthlyView.addClickListener(new CalendarButtonClickHandler());
			
			b_WeeklyView = new Button("Week");
			b_WeeklyView.setWidth(BUTTONWIDTH);
			b_WeeklyView.addClickListener(new CalendarButtonClickHandler());
			
			b_DailyView = new Button("Day");
			b_DailyView.setWidth(BUTTONWIDTH);
			b_DailyView.addClickListener(new CalendarButtonClickHandler());
			
			headerLayout.addComponent(b_MonthlyView);
			headerLayout.addComponent(b_WeeklyView);
			headerLayout.addComponent(b_DailyView);
		}		
	}