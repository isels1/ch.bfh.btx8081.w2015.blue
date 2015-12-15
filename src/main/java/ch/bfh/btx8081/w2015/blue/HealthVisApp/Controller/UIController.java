package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.ErrorMessagePopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

import com.vaadin.ui.Button.ClickEvent;

/**
 * control all events from the health visitor app
 * 
 * <ul>
 * 	control all made events from the diffrent views in the health visitor app
 * </ul>
 * @author zwahf1
 *
 */
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
	
	/**
	 * This constructor initialize the user interface controller for the app
	 */
	private UIController(){
	}
	
	/**
	 * get the ui controller
	 * @return c: UIController
	 */
	public static UIController getInstance() {
		if (c == null) {
			c = new UIController();
		}
		return c;
	}
	
	//================================================================================
    // Calendar Section
    //================================================================================
	
	/**
	 * change and show the selected view of the calendar
	 * @param event: ClickEvent
	 */
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
	
	/**
	 * get the patient pop-up controller
	 * @return patPopUpCon: PatientPopUpController
	 */
	public PatientPopUpController getPatPopUpController() {
		return patPopUpCon;
	}
	
	/**
	 * create and show a new patient pop-up
	 */
	public void createPatientPopUp() {
		patPopUpCon = new PatientPopUpController();
		patPopUpCon.createPatientPopUp();
	}
	
	/**
	 * creates and shows the patient edit-pop-up
	 * @param patientId: int
	 */
	public void createPatientEditPopUp(int patientId) {
		Patient pat = null;
		
		for (Patient p : PatientListController.getInstance().getPatients()) {
			if (p.getId() == patientId) {
				pat = p;
			}
		}
		
		patPopUpCon = new PatientPopUpController();
			patPopUpCon.createPatientEditPopUp(pat);
	}
	
	/**
	 * close the actual patient pop-up
	 */
	public void closePatientPopUp() {
		patPopUpCon.getPatView().close();
	}
	
	/**
	 * save a new patient and add to the health visitor
	 */
	public void savePatient() {
		patPopUpCon.savePatient(PatientListController.getInstance());
		patPopUpCon.getPatView().close();
	}
	
	//================================================================================
    // Appointment PopUp Section
    //================================================================================
	
	/**
	 * get the appointment pop-up controller
	 * @return appPopUpCon: AppointmentPopUpController
	 */
	public AppointmentPopUpController getAppPopUpController() {
		return appPopUpCon;
	}
	
	/**
	 * create and show a new appointment pop-up
	 */
	public void createAppointmentPopUp() {
		appPopUpCon = new AppointmentPopUpController();
		appPopUpCon.createAppointmentPopUp();
	}
	
	/**
	 * close the actual appointment pop-up
	 */
	public void closeAppointmentPopUp() {
		appPopUpCon.getAppView().close();
	}
	
	/**
	 * save a new appointment and add to the calendar
	 */
	public void saveAppointment() {
		if(appPopUpCon.saveAppointment(new HealthVisitorController())) {
			appPopUpCon.getAppView().close();
		}
		else {
			new ErrorMessagePopUpView("Time range is not allowed for appointment"
									+ "(time already in use)");
		}
		
	}
}
