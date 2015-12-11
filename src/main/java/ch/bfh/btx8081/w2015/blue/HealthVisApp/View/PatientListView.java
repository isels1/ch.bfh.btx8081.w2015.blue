package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.*;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListCellStyleGenerator;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PatientListView {

	private static PatientListView patListView = null;
	
	//================================================================================
    // PatietnList  Data
    //================================================================================

	Table patientTable;
		
		final static String WIDTH = "318";
		final static String HEIGHT = "460";
		
		private VerticalLayout patientViewTab;
		
		private Button b_addPatient = new Button("Add new Patient");;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListView() {
		
		patientViewTab = new VerticalLayout();
		
		/*Table*/ patientTable = new Table("Patientlist HVIS NAME");
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
			
			Object[] l = new Object[]{p.getName(),
									p.getFirstName(),
									p.getPatientState().doEnter()};
			
			patientTable.addItem(l,p.getId());
		}
		
		patientTable.setCellStyleGenerator(new PatientListCellStyleGenerator());
		
		patientViewTab.addComponent(patientTable);
		
		b_addPatient = new Button("Add Patient");
		b_addPatient.setWidth(WIDTH);
		b_addPatient.setIcon(FontAwesome.USER);
		patientViewTab.addComponent(b_addPatient);
		
		b_addPatient.addClickListener(new PatientListButtonClickHandler());
		
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
	
	public void addNewPatient(Patient p) {
		p.setPatientState(new PatientStateNew());
		
		Object[] l = new Object[]{p.getName(),
				p.getFirstName(),
				p.getPatientState().doEnter()};
		
		patientTable.addItem(l,p.getId());
		
		patientTable.setCellStyleGenerator(new PatientListCellStyleGenerator());
		
		patientViewTab.replaceComponent(patientTable, patientTable);
	}
	
	public static PatientListView getInstance() {
		if (patListView == null) {
			patListView = new PatientListView();
		}		
		return patListView;
	}
}
