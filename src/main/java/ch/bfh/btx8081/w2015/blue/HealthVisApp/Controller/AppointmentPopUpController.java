package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

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
		String[] date = appView.getTextFieldDate().split(DATE_DELIMITER);
		String[] time1 = appView.getTextFieldFrom().split(TIME_DELIMITER);
		String[] time2 = appView.getTextFieldTo().split(TIME_DELIMITER);
		
//		System.out.println("ds "+appView.getTextFieldDate());
//		System.out.println("0 "+date[0].trim());
//		System.out.println("1 "+date[1].trim());
//		System.out.println("2 "+date[2].trim());
//		
//		GregorianCalendar start = new GregorianCalendar();
//		start.set(Integer.parseInt(date[2]), 
//					Integer.parseInt(date[1]), 
//					Integer.parseInt(date[0]), 
//					Integer.parseInt(time1[0]), 
//					Integer.parseInt(time1[1]));
//		
//		GregorianCalendar end = new GregorianCalendar();
//		end.set(Integer.parseInt(date[2]), 
//				Integer.parseInt(date[1]), 
//				Integer.parseInt(date[0]), 
//				Integer.parseInt(time2[0]), 
//				Integer.parseInt(time2[1]));
		
		
//		hvc.getCalendar().newAppointment(start, 
//										end, 
//										appView.getTextFieldLocation(), 
//										SearchHandler.searchPatient(appView.getTextFieldPatient()));
	}
}
