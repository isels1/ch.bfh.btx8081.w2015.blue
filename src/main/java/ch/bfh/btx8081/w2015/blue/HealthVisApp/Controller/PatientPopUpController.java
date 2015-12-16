package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateAmbulant;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateArchived;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateNew;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateStationary;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.SearchHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientPopUpController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...controls the events from the patient pop up view
 * </span>
 * <br>
 * <br>
 * The PatientPopUpController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				final ADDR_DELIMITER:
 * 			</font> 
 * 			<i>String</i>
 * 			- Delimiter to split the address
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				patView:
 * 			</font> 
 * 			<i>PatientListPopUpView</i>
 * 			- The patient list popup view to handle the events
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				editPatient:
 * 			</font> 
 * 			<i>boolean</i>
 * 			- To know if the event has to execute an add or update patient (same popup view is used)
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
public class PatientPopUpController {
	public static final String ADDR_DELIMITER = "/";
	
	private PatientListPopUpView patView;
	private boolean editPatient;
	
	public PatientPopUpController(){
	}
	
	public void createPatientPopUp() {
		editPatient = false;
		patView = new PatientListPopUpView();
	}
	
	public void createPatientEditPopUp(Patient p) {
		editPatient = true;
		patView = new PatientListPopUpView();
		patView.setTextFieldName(p.getName());
		patView.setTextFieldFirstname(p.getFirstName());
		patView.setTextFieldId(p.getId());
		patView.setPopupDateFieldDate(p.getBirthdate());
		patView.setTextFieldAddress(p.getAddress());
		if (p.getPhone() != null) {
			patView.setTextFieldTel(p.getPhone());
		}
		
		patView.setCmBoxPatientState(p.getPatientState());
		
		if (p.getComment() != null) {
			patView.setTextFieldComment(p.getComment().getComment());
		}
	}
	
	public PatientListPopUpView getPatView() {
		return patView;
	}
	
	public void savePatient(PatientListController patc) {
		String[] addr = patView.getTextFieldAddress().split(ADDR_DELIMITER);
		Note com = new Note();
		com.setComment(patView.getTextFieldComment());
				
		Patient pat = new Patient(patView.getTextFieldName(), 
									patView.getTextFieldFirstname(), 
									patView.getPopupDateFieldDate(), 
									new Address(addr[0], Integer.parseInt(addr[1]), 
											Integer.parseInt(addr[2]), addr[3]), 
									patView.getTextFieldTel(), 
									patView.getTextFieldId());

		pat.setPatientState(patView.getCmBoxPatientState());
		
		pat.setComment(com);
		
		if (editPatient) {			
			patc.editPatient(pat);
		} else {
			patc.addNewPatient(pat);
		}
	}
}
