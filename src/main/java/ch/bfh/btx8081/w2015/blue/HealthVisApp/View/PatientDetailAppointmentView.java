package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.HealthVisitorController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentListCellStyleGenerator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListItemClickListener;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//TODO

public class PatientDetailAppointmentView {

	//================================================================================
    // AppointmentView  Data
    //================================================================================
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String TABHEIGHT = "300";				//356 full
	final static String DATEFORMAT = "dd.MM.yyyy";
	
	AppointmentPopUpView appView = null; 
	VerticalLayout layout = null;
	Table patientTable;
	HealthVisitor hv;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the detail appointment view for add a all appointments
	 */
	public PatientDetailAppointmentView() {
	    
		layout = new VerticalLayout();
		
		initTable();
		
		layout.addComponent(patientTable);
	}
	
	/**
	 * Get the layout from detail appointment view
	 * @return layout: VerticalLayout
	 */
	public VerticalLayout getLayout() {
		return layout;
	}
	
	/**
	 * Set the patient of the view an refresh it
	 */
	public void setPatient(Patient pat) {
		patientTable.removeAllItems();
		for(Appointment app : hv.getAppointment()) {
			if(pat.getId() == app.getPatient().getId()) {
				Object[] collumn = new Object[]{app};
				patientTable.addItem(collumn,null);
//				patientTable.setCellStyleGenerator(new AppointmentListCellStyleGenerator());
			}
		}
	}
	
	/**
	 * init the Table for the Appointment list and add it to the Vertical Layout
	 * 
	 */
	private void initTable(){
		HealthVisitorController hvController = new HealthVisitorController();
		hv = hvController.getHealthVisitor();
		patientTable = new Table("Appointment list " + hv.getFirstName()+ " "+ hv.getName());
		patientTable.setWidth(WIDTH);
		patientTable.setHeight(TABHEIGHT);
		patientTable.addContainerProperty("Appointments", Appointment.class, null);
	}
}
