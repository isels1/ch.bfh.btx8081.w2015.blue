package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		HealthVisitorController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...controller for the health visitor data
 * </span>
 * <br>
 * <br>
 * The HealthVisitorController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				ddc:
 * 			</font> 
 * 			<i>DummyDataCreator</i>
 * 			- The dummy data creator to get the events... later on it will be replaced with the persistence layer
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				hv:
 * 			</font> 
 * 			<i>HealthVisitor</i>
 * 			- The Health Visitor itself, to retrieve the data from the right health visitor
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		xx.xx.2015
 * </span>
 * <br><br>
 * @author zwahf1, dornt1, isels1
 * @version 1.0
 */
public class HealthVisitorController {
	
	//================================================================================
    // HealthVisitorController Data
    //================================================================================
	private DataProvider dp;
	private HealthVisitor hv;
	
	/**
	 * This constructor initialize the healthvisitor controller by loading the data
	 */
	public HealthVisitorController(){
		dp = DataProvider.getInstance();
		hv = dp.getHealthVisitor();
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
