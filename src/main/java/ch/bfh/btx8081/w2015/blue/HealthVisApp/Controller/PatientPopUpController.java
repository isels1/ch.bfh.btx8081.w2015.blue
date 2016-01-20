package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;


import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;
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
		patView.getWindow().setCaption("add new patient");
	}
	
	public void createPatientEditPopUp(Patient p) {
		editPatient = true;
		patView = new PatientListPopUpView();
		patView.getWindow().setCaption("edit patient");
		patView.setTextFieldName(p.getName());
		patView.setTextFieldFirstname(p.getFirstName());
		patView.setPatientId(p.getId());
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
				
		Patient pat = new Patient();
		pat.setName(patView.getTextFieldName());
		
		System.out.println(patView.getTextFieldName());
		
		pat.setFirstName(patView.getTextFieldFirstname());
		pat.setAddress(new Address(addr[0], Integer.parseInt(addr[1]), 
				Integer.parseInt(addr[2]), addr[3]));
		pat.setBirthdate(patView.getPopupDateFieldDate());
		pat.setPhone(patView.getTextFieldTel());							

		pat.setPatientState(patView.getCmBoxPatientState());
		
		pat.setComment(com);
		pat.setHealthvisitor(DataProvider.getInstance().getHealthVisitor());
		
		if (editPatient) {
			pat.setId(patView.getPatientId());
			patc.editPatient(pat);
			System.out.println("edit");
		} else {
			patc.addNewPatient(pat);
		}
	}
}
