package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.HealthVisitorController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
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
    // AppointmentPopUpView  Data
    //================================================================================
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "81";				//568 / 7
	final static String COMPWIDTH = "160";				//320 / 2
	final static String DATEFORMAT = "dd.MM.yyyy";
	
	AppointmentPopUpView appView = null; 
	VerticalLayout layout = null;

	Label labPat;
	Label labDate;
	Label labLoc;
	Label labFrom;
	Label labTo;
	Label labCom;
	
	ComboBox comboboxPatient;
	TextField tfDate;
	TextField tfLoc;
	TextField tfFrom;
	TextField tfTo;
	
	PopupDateField dfDate;
	
	TextArea taCom;
	
	Button butSave;
	Button butCancel;
	
	Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the pop-up view for add a new appointment
	 */
	public PatientDetailAppointmentView() {
		
	    
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
		
	}
	
	/**TODO
	 * init the Table for the Patient list and add it to the Vertical Layout
	 * 
	 */
	private void initTable(){
//		HealthVisitorController hvController = new HealthVisitorController();
//		HealthVisitor hv = hvController.getHealthVisitor();
//		patientTable = new Table("Patientlist " + hv.getFirstName()+ " "+ hv.getName());
//		patientTable.setWidth(WIDTH);
//		patientTable.setHeight(HEIGHT);
//		
//		patientTable.addContainerProperty("Patient Name", Patient.class, null);
//		patientTable.addItemClickListener(new PatientListItemClickListener());
//		
//		insertPatientsInList();
	}
}
