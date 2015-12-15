package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;

/**
 * Controller for data from healthvisitor 
 * @author isels1, zwahf1
 *
 */
public class HealthVisitorController {
	
	//================================================================================
    // HealthVisitorController Data
    //================================================================================
	private DummyDataCreator ddc;
	private HealthVisitor hv;
	
	/**
	 * This constructor initialize the healthvisitor controller by loading the data
	 */
	public HealthVisitorController(){
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
	}
	
	/**
	 * Get calendar from the healthvisitor
	 * @return hv-calendar: Calendar
	 */
	public Calendar getCalendar(){
		return hv.getCalendar();
	}
	
	/**
	 * Add a given appointment to the calendar
	 * @param app: Appointment
	 */
	public void addNewApp(Appointment app) {
		CalendarView.getInstance().addNewApp(app, hv.getCalendar());
	}
	
	/**
	 * Get the healthvisitor
	 * @return hv: HealthVisitor
	 */
	public HealthVisitor getHealthVisitor ()
	{
		return hv;
	}
}
