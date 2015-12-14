package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.HealthVisitorController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListCellStyleGenerator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatinetListComboBoxChangeListener;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatietnListView
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		creates an instance of a PatientListView.
 * </span>
 * <br>
 * <br>
 * the PatietnListView contains following Vaadin Elements:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Combobox:</b>
 * 			</font> 
 * 			<i>Combobox</i>
 * 			 - whit a Filter for each Patient State
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Table:</b>
 * 			</font> 
 * 			<i>Table</i>
 * 			- List whit all patients
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Button:</b>
 * 			</font> 
 * 			<i>Button</i>
 * 			- add a new patient Button
 * 		</li>
 *	 </ul>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		01.12.2015
 * </span>
 * <br><br>
 * @author dornt1 isels1
 * @version 1.7
 */
public class PatientListView {

	private static PatientListView patListView = null;
	
	//================================================================================
    // PatietnList  Data
    //================================================================================
		
		final static String WIDTH = "318";
		final static String HEIGHT = "394";
		
		private VerticalLayout patientViewTab;//the whole patient View is on this Layout
		
		private Table patientTable;
		private ComboBox comboboxFilter;
		private Button b_addPatient = new Button("Add new Patient");
		
		//Name for the patient filter
		private final String str_Ambulant = "Ambulant";
		private final String str_Archived = "Archived";
		private final String str_New = "New";
		private final String str_Stationary = "Stationary";
		private final String str_AllPatinets = "All patients";
	
	//================================================================================
    // Constructor Section
    //================================================================================
	private PatientListView() {
		//add all components to the patientViewTab
		patientViewTab = new VerticalLayout();
		
		initCombobox(); //First add Combobox for the Filter
		initTable();	//add Table whit all patients
		initAddPatientButton();	//finaly add button whit add Patient

		patientViewTab.addComponent(b_addPatient);
		patientViewTab.addComponent(patientTable);	
		patientViewTab.addComponent(b_addPatient);
	}
	
	/**
	 * @return the combobox for the Patietn filter
	 */
	public ComboBox getCombobox(){
		return comboboxFilter;
	}
	
	/**
	 * @return patientViewTab 
	 * return this for the PatientView
	 */
	public VerticalLayout getPatientList(){	
		return patientViewTab;
	}
	
	/**
	 * @return the b_addPatient
	 */
	public Button getB_addPatient() {
		return b_addPatient;
	}
	/**
	 * @return the insance of the Class
	 */
	public static PatientListView getInstance() {
		if (patListView == null) {
			patListView = new PatientListView();
		}		
		return patListView;
	}
	/**
	 * refresch the Table whit the patient list
	 * 
	 * 	 * Filters the PatientList to the Status
	 * 
	 * 	- Ambulant
	 *  - Stationary
	 *  - New
	 *  - Archived
	 *  - All Patinet
	 *  
	 */
	public void refreshView(){
		insertPatientsInList();
	}
	
	//================================================================================
    // Private Helper Section
    //================================================================================
    
	/**
	 * init the combobox for the patient filter and add it to the Vertical Layout
	 * The table can Filter every Patient State
	 * 	- Ambulant
	 *  - Stationary
	 *  - New
	 *  - Archived
	 *  - All Patinet
	 *  
	 *  the standard Value is All patients
	 */
	private void initCombobox (){
		comboboxFilter = new ComboBox("");
		comboboxFilter.setInvalidAllowed(false);
		comboboxFilter.setWidth(WIDTH);
		comboboxFilter.setNullSelectionAllowed(false);
		comboboxFilter.setNewItemsAllowed(false);   
		// Add some items and specify their item ID.
		// The item ID is by default used as item caption.
		comboboxFilter.addItems(str_AllPatinets, str_Stationary, str_Ambulant, str_New,str_Archived);
		comboboxFilter.setValue(comboboxFilter.getItemIds().iterator().next());
	
		comboboxFilter.addValueChangeListener(new PatinetListComboBoxChangeListener());
	}	
	/**
	 * init the Table for the Patient list and add it to the Vertical Layout
	 * 
	 */
	private void initTable(){
		HealthVisitorController hvController = new HealthVisitorController();
		HealthVisitor hv = hvController.getHealthVisitor();
		patientTable = new Table("Patientlist " + hv.getFirstName()+ " "+ hv.getName());
		patientTable.setWidth(WIDTH);
		patientTable.setHeight(HEIGHT);
		
		patientTable.addContainerProperty("Patient Name", Patient.class, null);
		
		insertPatientsInList();
	}
	/**
	 * init the addPatientButton for the Patient list and add it to the Vertical Layout
	 * 
	 */
	private void initAddPatientButton (){
		b_addPatient = new Button("Add Patient");
		b_addPatient.setWidth(WIDTH);
		b_addPatient.setIcon(FontAwesome.USER);
		b_addPatient.addClickListener(new PatientListButtonClickHandler());
	}
	/**
	 * insert Patients in the PatientTable
	 * 
	 */
	private void insertPatientsInList()
	{
		String status = (String) comboboxFilter.getValue();
		PatientController patCon = new PatientController();
		patientTable.removeAllItems();
		for(Patient p: patCon.getPatientsDefaultOrder())
		{	
			if((status) == p.getPatientState().getPatientStateName()
					|| (status == str_AllPatinets)){
				Object[] collumn = new Object[]{p};	
				patientTable.addItem(collumn,p.getId());
			}
		}
		patientTable.setCellStyleGenerator(new PatientListCellStyleGenerator());
	}
}

