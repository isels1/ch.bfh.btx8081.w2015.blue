package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import com.vaadin.ui.TabSheet;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientDetailView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.TabView;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientDetailController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...controls the events from the detail view
 * </span>
 * <br>
 * <br>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		16.01.2016
 * </span>
 * <br><br>
 * @author zwahf1
 * @version 1.0
 */
public class PatientDetailController {

	private PatientDetailView detailView;
	
	/**
	 * This constructor initialize the appointment controller for add a new appointment
	 */
	public PatientDetailController() {
	}
	
	/**
	 * create a patient detail with the given patient and show it
	 * @param pat: Patient
	 */
	public void createPatientDetail(Patient pat) {
		detailView = PatientDetailView.getInstance();
		detailView.setPatient(pat);
		TabSheet tabView = TabView.getInstance().getTabSheet();
		tabView.replaceComponent(tabView.getTab(1).getComponent(), 
									detailView.getPatientDetail());
	}
	
	/**
	 * get the detail view
	 * @return detailView: PatientDetailView
	 */
	public PatientDetailView getPatDetailView() {
		return detailView;
	}
	
	/**
	 * close the detail view and shows the patient list view
	 */
	public void closePatientDetail() {
		detailView = PatientDetailView.getInstance();
		TabSheet tabView = TabView.getInstance().getTabSheet();
		tabView.replaceComponent(detailView.getPatientDetail(),
								PatientListView.getInstance().getPatientList());
	}
}
