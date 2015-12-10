package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.AppointmentEventProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListButtonClickHandler;

import com.vaadin.data.Item;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.calendar.event.CalendarEvent;

public class PatientListView {

	private static PatientListView patListView = null;
	
	//================================================================================
    // PatietnList  Data
    //================================================================================

		
		final static String WIDTH = "318";
		final static String HEIGHT = "460";
		
		private VerticalLayout patientViewTab;
		
		private Button b_addPatient = new Button("Add new Patient");;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListView() {
		
		patientViewTab = new VerticalLayout();
		
		Table patientTable = new Table("Patientlist HVIS NAME");
		patientTable.setWidth(WIDTH);
		patientTable.setHeight(HEIGHT);
		
		patientTable.addContainerProperty("Name", String.class, null);
		patientTable.addContainerProperty("Forename",  String.class, null);
//		patientTable.addContainerProperty("Patient ID",String.class,null);
	
		PatientController patCon = new PatientController();
		int i = 0;
		for(Patient p: patCon.getPatients() )
		{
			patientTable.addItem(new Object[]{p.getName(), p.getFirstName()},i);

			i++;
		}
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
	
	public static PatientListView getInstance() {
		if (patListView == null) {
			patListView = new PatientListView();
		}		
		return patListView;
	}
}
