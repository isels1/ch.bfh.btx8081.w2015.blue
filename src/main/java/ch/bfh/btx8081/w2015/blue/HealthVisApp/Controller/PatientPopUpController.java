package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

public class PatientPopUpController {
	public static String ADDR_DELIMITER = " ";
	
	private PatientListPopUpView patView;

	private DummyDataCreator ddc;
	
	public PatientPopUpController(){
		ddc = DummyDataCreator.getInstance();
	}
	
	public void createPatientPopUp() {
		patView = new PatientListPopUpView();
	}
	
	public PatientListPopUpView getPatView() {
		return patView;
	}
	
	public void savePatient(PatientController patc) {
		String[] addr = patView.getTextFieldAddress().split(ADDR_DELIMITER);
		
		patc.addNewPatient(new Patient(
				patView.getTextFieldName(), 
				patView.getTextFieldFirstname(), 
				patView.getPopupDateFieldDate(), 
				new Address(addr[0], Integer.parseInt(addr[1]), 
							Integer.parseInt(addr[2]), addr[3]), 
				patView.getTextFieldTel(), 
				Integer.parseInt(patView.getTextFieldId())));
	}
}
