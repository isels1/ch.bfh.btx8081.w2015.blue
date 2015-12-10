package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.AppointmentPopUpController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;

public class SearchHandler {
	
	
	static ArrayList<Patient> patList;
	static Patient pat = null;

	public static Patient searchPatient(int id) {
		PatientController c = new PatientController();
		patList = c.getPatients();
		for(Patient p : patList) {
			if(p.getId() == id) {
				return pat;
			}
		}
		return null;
	}
	
	public static Patient searchPatient(String name) {
		PatientController c = new PatientController();
		patList = c.getPatients();
		for(Patient p : patList) {
			if(p.getName().equals(name)) {
				return pat;
			}
		}
		return null;
	}
	
	public static Patient searchPatient(String name, String firstname) {
		PatientController c = new PatientController();
		patList = c.getPatients();
		for(Patient p : patList) {
			if(p.getName().equals(name) && p.getFirstName().equals(firstname)) {
				return pat;
			}
		}
		return null;
	}
}
