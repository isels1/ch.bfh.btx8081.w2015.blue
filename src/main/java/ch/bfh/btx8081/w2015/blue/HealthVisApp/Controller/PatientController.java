package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;

public class PatientController {
	
	private DummyDataCreator ddc;
	private HealthVisitor hv;
	
	public PatientController(){
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
	}
	
	public ArrayList<Patient> getPatients(){
		return hv.getPatient();
	}
	
	public void addNewPatient(Patient pat) {
		hv.setPatient(pat);
		PatientListView.getInstance().addNewPatient(pat);
	}
	
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
	
	
}
