package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

import com.vaadin.ui.Button.ClickEvent;

public class UIController {

	//================================================================================
    // UIController Data
    //================================================================================
	
	private static UIController c = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private UIController(){
	}
	
	public static UIController getInstance() {
		if (c == null) {
			c = new UIController();
		}
		return c;
	}
	
	public void changeCalendarViewController(ClickEvent event) {
		CalendarView calView = CalendarView.getInstance();
		
		if(calView.getB_DailyView() == event.getSource()){
			calView.changeToDaily();
		}
		
		if(calView.getB_MonthlyView() == event.getSource()){
			calView.changeToMonthly();
		}
		
		if(calView.getB_WeeklyView() == event.getSource()){
			calView.changeToWeekly();
		}
	}
	
	public void getAppointmentPopUp() {
		AppointmentPopUpView appView = AppointmentPopUpView.getInstance();
	}
	
	public void getPatientPopUp() {
		PatientListPopUpView patView = PatientListPopUpView.getInstance();
	}
	
	public void saveAppointment() {
		AppointmentPopUpView appView = AppointmentPopUpView.getInstance();
		Patient pat = SearchHandler.searchPatient(appView.getTextFieldPatient());
		
//		DummyDataCreator.getInstance().getHealthVisitor().getCalendar().
//			newAppointment(startTime, endTime, location, pat);
//		Date date = (Date) appView.getTextFieldDate();
		appView.getTextFieldFrom();
		appView.getTextFieldTo();
		appView.getTextFieldComent();
	}
	
	public void closeAppointmentPopUp() {
		AppointmentPopUpView appView = AppointmentPopUpView.getInstance();
	}
}
