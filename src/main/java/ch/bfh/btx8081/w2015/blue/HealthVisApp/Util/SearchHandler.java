package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientListController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

public class SearchHandler {
	
	
	static ArrayList<Patient> patList;

	public static Patient searchPatient(int id) {
		PatientListController c = PatientListController.getInstance();
		patList = c.getPatientsDefaultOrder();
		for(Patient p : patList) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public static Patient searchPatient(String name) {
		PatientListController c = PatientListController.getInstance();
		patList = c.getPatients();
		for(Patient p : patList) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public static Patient searchPatient(String name, String firstname) {
		PatientListController c = PatientListController.getInstance();
		patList = c.getPatients();
		for(Patient p : patList) {
			if(p.getName().equals(name) && p.getFirstName().equals(firstname)) {
				return p;
			}
		}
		return null;
	}
}
