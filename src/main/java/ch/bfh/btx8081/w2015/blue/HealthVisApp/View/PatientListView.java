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

public class PatientListView {

	private static PatientListView patListView = null;
	
	//================================================================================
    // PatietnList  Data
    //================================================================================
		
		final static String WIDTH = "318";
		final static String HEIGHT = "394";
		
		private VerticalLayout patientViewTab;
		private Table patientTable;
		private ComboBox combobox;
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
		
		patientViewTab = new VerticalLayout();
		
		HealthVisitorController hvController = new HealthVisitorController();
		HealthVisitor hv = hvController.getHealthVisitor();
		patientTable = new Table("Patientlist " + hv.getFirstName()+ " "+ hv.getName());
		patientTable.setWidth(WIDTH);
		patientTable.setHeight(HEIGHT);
		
		patientTable.addContainerProperty("Name", String.class, null);
		patientTable.addContainerProperty("Forename",  String.class, null);
		patientTable.addContainerProperty("State",  String.class, null);
		
		//Hide Patient State column
		patientTable.setColumnCollapsingAllowed(true);
		patientTable.setColumnCollapsed("State", true);	
	
		PatientController patCon = new PatientController();
		for(Patient p: patCon.getPatientsDefaultOrder())
		{
//			Label l_Name = new Label(p.getName());
//			Label l_ForeName = new Label(p.getFirstName());
//			Label l_State = new Label(p.getPatientState().doEnter());
			
//			l_Name.setStyleName(p.getPatientState().doEnter());
//			l_ForeName.setStyleName(p.getPatientState().doEnter());
			
			Object[] collumn = new Object[]{p.getName(),
									p.getFirstName(),
									p.getPatientState().doEnter()};
			
			patientTable.addItem(collumn,p.getId());
		}
		
		patientTable.setCellStyleGenerator(new PatientListCellStyleGenerator());
		patientViewTab.addComponent(patientTable);	
		
		b_addPatient = new Button("Add Patient");
		b_addPatient.setWidth(WIDTH);
		b_addPatient.setIcon(FontAwesome.USER);
		b_addPatient.addClickListener(new PatientListButtonClickHandler());
		
		patientViewTab.addComponent(b_addPatient);
	
	}
	public ComboBox getCombobox(){
		return combobox;
	}
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
	 * Filters the PatientList to the Status
	 * 
	 * 	 - Ambulant
	 *  - Stationary
	 *  - New
	 *  - Archived
	 *  - All Patinet
	 *  
	 * @param status is the selected item in the Combobox 
	 */
	public void FilterStatus(String status){
		
		PatientController patCon = new PatientController();
		patientTable.removeAllItems();
		
		for(Patient p: patCon.getPatientsDefaultOrder())
		{
			Object[] collumn = new Object[]{p.getName(),
									p.getFirstName(),
									p.getPatientState().doEnter()};
			
			if((status) == p.getPatientState().getPatientStateName()
					||(status == str_AllPatinets)){
			patientTable.addItem(collumn,p.getId());
			}
		}
	}
	/**
	 * init the combobox for the patient filter
	 * The table can Filter every Patient State
	 * 	- Ambulant
	 *  - Stationary
	 *  - New
	 *  - Archived
	 *  - All Patinet
	 *  
	 *  the standard Value is All patients
	 */
	private void initcombobox (){
		combobox = new ComboBox("Select your Filter");
		combobox.setInvalidAllowed(false);
		combobox.setWidth(WIDTH);
		combobox.setNullSelectionAllowed(false);
		combobox.setNewItemsAllowed(false);   
		// Add some items and specify their item ID.
		// The item ID is by default used as item caption.
		combobox.addItems(str_AllPatinets, str_Stationary, str_Ambulant, str_New,str_Archived);
		combobox.setValue("str_AllPatinets");
		patientViewTab.addComponent(combobox);
		combobox.addValueChangeListener(new PatinetListComboBoxChangeListener());
	}	
}

