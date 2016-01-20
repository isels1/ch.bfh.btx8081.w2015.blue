package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.HealthVisitorController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Treatment;

import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

//TODO

public class PatientDetailOverviewView {

	//================================================================================
    // TreatmentView  Data
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
	 * This constructor initialize the detail treatment view for add a all treatments
	 */
	public PatientDetailOverviewView() {
	    
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
	 * Set the treatment of the view an refresh it
	 */
	public void setPatient(Patient pat) {
		patientTable.removeAllItems();
		for(Patient p : hv.getPatient()) {
			if(pat.getId() == p.getId()) {
				for(Treatment t : p.getTreatment()) {
					Object[] collumn = new Object[]{t};
					patientTable.addItem(collumn,null);
				}
			}
		}
	}
	
	/**
	 * init the Table for the Treatment list and add it to the Vertical Layout
	 * 
	 */
	private void initTable(){
		HealthVisitorController hvController = new HealthVisitorController();
		hv = hvController.getHealthVisitor();
		patientTable = new Table("Appointment list " + hv.getFirstName()+ " "+ hv.getName());
		patientTable.setWidth(WIDTH);
		patientTable.setHeight(TABHEIGHT);
		patientTable.addContainerProperty("Treatments", Treatment.class, null);
	}
}
