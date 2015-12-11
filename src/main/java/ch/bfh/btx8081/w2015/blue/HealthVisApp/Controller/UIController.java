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
	AppointmentPopUpController appPopUpCon;
	PatientPopUpController patPopUpCon;
	
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
	
	//================================================================================
    // Calendar Section
    //================================================================================
	
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

	//================================================================================
    // Patient PopUp Section
    //================================================================================
	
	public PatientPopUpController getPatPopUpController() {
		return patPopUpCon;
	}
	
	public void createPatientPopUp() {
		patPopUpCon = new PatientPopUpController();
		patPopUpCon.createPatientPopUp();
	}
	
	public void closePatientPopUp() {
		patPopUpCon.getPatView().close();
	}
	
	public void savePatient() {
		patPopUpCon.savePatient(new PatientController());
		patPopUpCon.getPatView().close();
		
		PatientController pc = new PatientController();
//		System.out.println(""+pc.getPatients().toString());
	}
	
	//================================================================================
    // Appointment PopUp Section
    //================================================================================
	
	public AppointmentPopUpController getAppPopUpController() {
		return appPopUpCon;
	}
	
	public void createAppointmentPopUp() {
		appPopUpCon = new AppointmentPopUpController();
		appPopUpCon.createAppointmentPopUp();
	}
	
	public void closeAppointmentPopUp() {
		appPopUpCon.getAppView().close();
	}
	
	public void saveAppointment() {
		appPopUpCon.saveAppointment(new HealthVisitorController());
		appPopUpCon.getAppView().close();
	}
}
