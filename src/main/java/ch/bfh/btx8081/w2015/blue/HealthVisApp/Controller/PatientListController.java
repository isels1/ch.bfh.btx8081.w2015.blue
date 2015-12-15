package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

public class PatientListController {

	//================================================================================
    // PatientListController Data
    //================================================================================
	
	private static PatientListController plc = null;
	private static DummyDataCreator ddc;
	private static HealthVisitor hv;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListController(){
	}
	
	public static PatientListController getInstance() {
		if (plc == null) {
			plc = new PatientListController();
		}
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
		return plc;
	}
	
	public void FilterPatientListController(ValueChangeEvent event) {
		PatientListView PatListView = PatientListView.getInstance();
		PatListView.refreshView();

	}
	
	//================================================================================
    // Getter  Section
    //================================================================================
	
	/**
	 * get all patients from actual healthvisitor
	 * @return patients: ArrayList<Patient>
	 **/
	public ArrayList<Patient> getPatients(){
		return hv.getPatient();
	}
	
	/**
	 * get all patients in the default order from actual healthvisitor
	 * @return patients: ArrayList<Patient>
	 **/
	public ArrayList<Patient> getPatientsDefaultOrder(){
		ArrayList<Patient> defaultOrder = new ArrayList<Patient>();
		defaultOrder.addAll(hv.getPatient());
		
		//Sorting
		Collections.sort(defaultOrder, new Comparator<Patient>() {
		        @Override
		        public int compare(Patient p1, Patient  p2)
		        {
		        	PatientState s1 = p1.getPatientState();
		        	PatientState s2 = p2.getPatientState();
		            return s1.getPatientStateId() - s2.getPatientStateId();
		        }
		    });
		
		return defaultOrder;
	}
	
	/**
	 * add new given patient
	 */
	public void addNewPatient(Patient pat) {
		hv.setPatient(pat);
		PatientListView.getInstance().refreshView();
	}

}
