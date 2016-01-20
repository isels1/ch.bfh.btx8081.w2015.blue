package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.ErrorMessagePopUpView;

import com.vaadin.ui.Button.ClickEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		UIController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...control all events from the health visitor app. And the most important the events between the views.
 * </span>
 * <br>
 * <br>
 * The UIController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				c:
 * 			</font> 
 * 			<i>UIController</i>
 * 			- UIController object for the singleton class
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				appPopUpCon:
 * 			</font> 
 * 			<i>AppointmentPopUpController</i>
 * 			- To control the open and closing of the popup view
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				patPopUpCon:
 * 			</font> 
 * 			<i>PatientPopUpController</i>
 * 			- To control the open and closing of the popup view
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
public class UIController {

	//================================================================================
    // UIController Data
    //================================================================================
	
	private static UIController c = null;
	AppointmentPopUpController appPopUpCon;
	PatientPopUpController patPopUpCon;
	PatientDetailController patDetailCon;
	
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
    // Patient Detail Section
    //================================================================================
	
	/**
	 * get the patient detail controller
	 * @return patDetailCon: PatientDetailController
	 */
	public PatientDetailController getPatDetailController() {
		return patDetailCon;
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
	
	/**
	 * edit a patient and add to the health visitor
	 */
	public void editPatient() {
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
	
	//================================================================================
    // Patient detail Section
    //================================================================================
	
	/**
	 * creates and shows the patient detail view
	 * @param patientId: int
	 */
	public void createPatientDetailView(int patientId) {
		Patient pat = null;
		
		for (Patient p : PatientListController.getInstance().getPatients()) {
			if (p.getId() == patientId) {
				pat = p;
			}
		}
		
		patDetailCon = new PatientDetailController();
		patDetailCon.createPatientDetail(pat);
	}
	
	/**
	 * close the actual detail view and show patient list
	 */
	public void closePatientDetailView() {
		patDetailCon = new PatientDetailController();
		patDetailCon.closePatientDetail();
	}
}
