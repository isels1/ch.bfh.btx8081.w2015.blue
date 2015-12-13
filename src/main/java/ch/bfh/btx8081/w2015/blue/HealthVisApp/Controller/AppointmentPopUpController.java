package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

public class AppointmentPopUpController {
	
	public static String DATE_DELIMITER = "/";
	public static String TIME_DELIMITER = ":";
	
	private AppointmentPopUpView appView;
	
	public AppointmentPopUpController(){
	}
	
	public void createAppointmentPopUp() {
		appView = new AppointmentPopUpView();
	}
	
	public AppointmentPopUpView getAppView() {
		return appView;
	}
	
	public void saveAppointment(HealthVisitorController hvc) {
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
		
		hvc.addNewApp(app);
	}
}
