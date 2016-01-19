package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataPersister;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;

import com.vaadin.data.Property.ValueChangeEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientListController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...controls the events from the patient list view
 * </span>
 * <br>
 * <br>
 * The PatientListController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				plc:
 * 			</font> 
 * 			<i>PatientListController</i>
 * 			- PatientListController object for sinelton class
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				ddc:
 * 			</font> 
 * 			<i>DummyDataCreator</i>
 * 			- The dummy data creator to get the events... later on it will be replaced with the persistence layer
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				hv:
 * 			</font> 
 * 			<i>HealthVisitor</i>
 * 			- The Health Visitor itself, to retrieve the data from the right health visitor
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
public class PatientListController {

	//================================================================================
    // PatientListController Data
    //================================================================================
	
	private static PatientListController plc = null;
	private static DataProvider dp;
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
		dp = DataProvider.getInstance();
		hv = dp.getHealthVisitor();
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
		return new ArrayList<Patient>(hv.getPatient());
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
		DataPersister.getInstance().addNewPatient(pat);
		PatientListView.getInstance().refreshView();
	}
	
	/**
	 * edit
	 * 
	 */
	public void editPatient(Patient pat) {
		for (int i = 0; i < hv.getPatient().size(); i++) {
			Patient p = hv.getPatient().get(i);
			System.out.print("Person to Edit: " + pat.getId() +
					 " --Person in for: " + p.getId() + "\n");
			if (p.getId() == pat.getId()) {
				System.out.print("Person to Edit FOUND" + "\n");
				p = pat;		
				DataPersister.getInstance().updatePatient(pat);
			}
			hv.getPatient().set(i, p);
		}
		PatientListView.getInstance().refreshView();
	}

}
