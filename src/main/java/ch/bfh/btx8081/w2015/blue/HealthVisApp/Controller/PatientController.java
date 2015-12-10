package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;

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
}
