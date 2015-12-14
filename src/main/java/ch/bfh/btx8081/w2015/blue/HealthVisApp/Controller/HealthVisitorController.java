package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;

/**
 * 
 * @author Stefan Iseli
 *
 */
public class HealthVisitorController {
	private DummyDataCreator ddc;
	private HealthVisitor hv;
	
	/**
	 * 
	 */
	public HealthVisitorController(){
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
	}
	
	/**
	 * 
	 * @return
	 */
	public Calendar getCalendar(){
		return hv.getCalendar();
	}
		
	public void addNewApp(Appointment app) {
		hv.getCalendar().setAppointment(app);
		CalendarView.getInstance().addNewApp(app, hv.getCalendar());
	}
	
	public HealthVisitor getHealthVisitor ()
	{
		return hv;
	}
}
