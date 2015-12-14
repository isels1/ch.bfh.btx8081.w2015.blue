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
 * shows all Patient in a Table
 * 
 * define a Filter for the Patient whit the Combobox (Patient States)
 * 
 * Add a Patient whit the new Patient Button
 * 
 * The Color of each patient is different for each state
 * @author Tim
 *
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
		
		initcombobox(); //First add Combobox for the Filter
		initTable();	//add Table whit all patients
		initAddPatientButton();	//finaly add button whit add Patient

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
		insertPatientinList();
	}
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
	//
	//Private Methods
	//
	private void initcombobox (){
		comboboxFilter = new ComboBox("");
		comboboxFilter.setInvalidAllowed(false);
		comboboxFilter.setWidth(WIDTH);
		comboboxFilter.setNullSelectionAllowed(false);
		comboboxFilter.setNewItemsAllowed(false);   
		// Add some items and specify their item ID.
		// The item ID is by default used as item caption.
		comboboxFilter.addItems(str_AllPatinets, str_Stationary, str_Ambulant, str_New,str_Archived);
		comboboxFilter.setValue(comboboxFilter.getItemIds().iterator().next());
		patientViewTab.addComponent(comboboxFilter);
	
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
		
		insertPatientinList();
		patientViewTab.addComponent(patientTable);	
	}
	private void initAddPatientButton (){
		b_addPatient = new Button("Add Patient");
		b_addPatient.setWidth(WIDTH);
		b_addPatient.setIcon(FontAwesome.USER);
		b_addPatient.addClickListener(new PatientListButtonClickHandler());
		
		patientViewTab.addComponent(b_addPatient);
	}
	private void insertPatientinList()
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

