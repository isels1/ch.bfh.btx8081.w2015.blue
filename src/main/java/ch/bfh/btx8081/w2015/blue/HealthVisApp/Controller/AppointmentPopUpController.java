package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

public class AppointmentPopUpController {
	
	public static String DATE_DELIMITER = ".";
	public static String TIME_DELIMITER = ":";
	
	private AppointmentPopUpView appView;

	private DummyDataCreator ddc;
	
	public AppointmentPopUpController(){
		ddc = DummyDataCreator.getInstance();
	}
	
	public void createAppointmentPopUp() {
		appView = new AppointmentPopUpView();
	}
	
	public AppointmentPopUpView getAppView() {
		return appView;
	}
	
	public void saveAppointment(HealthVisitorController hvc) {
		Date date = appView.getPopupDateFieldDate().getValue();
		String[] time1 = appView.getTextFieldFrom().split(TIME_DELIMITER);
		String[] time2 = appView.getTextFieldTo().split(TIME_DELIMITER);
		
		GregorianCalendar start = new GregorianCalendar();
		start.set(date.getYear(),
					date.getMonth(),
					date.getDay(),
					Integer.parseInt(time1[0]), 
					Integer.parseInt(time1[1]));
		
		GregorianCalendar end = new GregorianCalendar();
		start.set(date.getYear(),
				date.getMonth(),
				date.getDay(),
				Integer.parseInt(time2[0]), 
				Integer.parseInt(time2[1]));
		
		ddc.getCalendar().newAppointment(start, 
				end, 
				appView.getTextFieldLocation(), 
				SearchHandler.searchPatient(appView.getTextFieldPatient()));
		
//		hvc.getCalendar().newAppointment(
//			start, 
//			end, 
//			appView.getTextFieldLocation(), 
//			SearchHandler.searchPatient(appView.getTextFieldPatient()));
	}
}
