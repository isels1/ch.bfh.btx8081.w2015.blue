package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import com.vaadin.ui.TabSheet;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientDetailView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.TabView;

public class PatientDetailController {

	private PatientDetailView detailView;
	
	public void PatientDetailController() {
	}
	
	public void createPatientDetail(Patient pat) {
		detailView = PatientDetailView.getInstance();
		detailView.setPatient(pat);
		TabSheet tabView = TabView.getInstance().getTabSheet();
		tabView.replaceComponent(tabView.getTab(1).getComponent(), 
									detailView.getPatientDetail());
	}
	
	public PatientDetailView getPatDetailView() {
		return detailView;
	}
	
	public void closePatientDetail() {
		detailView = PatientDetailView.getInstance();
		TabSheet tabView = TabView.getInstance().getTabSheet();
		tabView.replaceComponent(detailView.getPatientDetail(),
								PatientListView.getInstance().getPatientList());
	}
}
