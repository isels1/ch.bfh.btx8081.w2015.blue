package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		AppointmentPopUpController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...controls the events from the appointment view
 * </span>
 * <br>
 * <br>
 * The AppointmentPopUpController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				final DATE_DELIMITER:
 * 			</font> 
 * 			<i>String</i>
 * 			- Delimiter to split the date format
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				final TIME_DELIMITER:
 * 			</font> 
 * 			<i>String</i>
 * 			- Delimiter to split the time format
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				appView:
 * 			</font> 
 * 			<i>AppointmentPopUpView</i>
 * 			- The view to handle the events given from the appoointment-view (save new appointment)
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
public class AppointmentPopUpController {
	
	//================================================================================
    // AppointmentPopUpController  Data
    //================================================================================
	public static String DATE_DELIMITER = "/";
	public static String TIME_DELIMITER = ":";
	
	private AppointmentPopUpView appView;

	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor initialize the appointment controller for add a new appointment
	 */
	public AppointmentPopUpController(){
	}
	
	//================================================================================
    // Other  Section
    //================================================================================
	
	/**
	 * create new appointment pop-up
	 */
	public void createAppointmentPopUp() {
		appView = new AppointmentPopUpView();
	}
	
	/**
	 * get the new created appointment
	 * @return appView: AppointmentPopUpView
	 */
	public AppointmentPopUpView getAppView() {
		return appView;
	}
	
	/**
	 * save a new appointment in the actual calendar
	 * @param hvc
	 * @return true if appointment has no conflict otherwise false
	 */
	public boolean saveAppointment(HealthVisitorController hvc) {
		Date date = appView.getPopupDateFieldDate();
		String[] time1 = appView.getTextFieldFrom().split(TIME_DELIMITER);
		String[] time2 = appView.getTextFieldTo().split(TIME_DELIMITER);
		Note com = new Note();
		com.setComment(appView.getTextFieldComment());
		
		GregorianCalendar start = new GregorianCalendar();
		date.setHours(Integer.parseInt(time1[0]));
		date.setMinutes(Integer.parseInt(time1[1]));
		start.setTime(date);
		
		GregorianCalendar end = new GregorianCalendar();
		date.setHours(Integer.parseInt(time2[0]));
		date.setMinutes(Integer.parseInt(time2[1]));
		end.setTime(date);
		
		Appointment app = new Appointment(start, 
						end, 
						appView.getTextFieldLocation(), 
						appView.getcomboboxPatient());
		
		app.setComment(com);
		
		if(hvc.getCalendar().newAppointment(app)) {
			hvc.addNewApp(app);
			return true;
		}
		else {
			return false;
		}
	}
}
