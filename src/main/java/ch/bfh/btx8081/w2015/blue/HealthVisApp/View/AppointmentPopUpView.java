package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * shows a pop-up for adding a new appointment
 * 
 * <ul>
 * 	save or cancel the creating of the new appointment by two buttons
 * </ul>
 * <ul>
 * create a new appointment by given attributes:
 * 	<li>
 * 		<b>
 * 		patient	
 * 		</b>
 * 		: select a patient from the combobox
 * 	</li>
 * 	<li>
 * 		<b>
 * 		date	
 * 		</b>
 * 		: enter the date from the appointment (dd.MM.yyyy) or
 * 				  select date from attached calendar
 * 	</li>
 * 	<li>
 * 		<b>
 * 		location: 
 * 		</b>
 * 		enter location from the appointment
 * 	</li>
 * 	<li>
 * 		<b>
 * 		from	
 * 		</b>
 * 		: enter the start-time from the appointment (hh:mm)
 * 	</li>
 * 	<li>
 * 		<b>
 * 		to	
 * 		</b>
 * 		: enter the end-time from the appointment (hh:mm)
 * 	</li>
 * 	<li>
 * 		<b>
 * 		comment	
 * 		</b>
 * 		: enter a comment to the appointment as note
 * 	</li>
 * </ul>
 * @author zwahf1
 *
 */
public class AppointmentPopUpView {
	
	//================================================================================
    // AppointmentPopUpView  Data
    //================================================================================
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "81";				//568 / 7
	final static String COMPWIDTH = "160";				//320 / 2
	
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
	
	TextArea tfCom;
	
	Button butSave;
	Button butCancel;
	
	Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the pop-up view for add a new appointment
	 */
	public AppointmentPopUpView() {
		this.createWindow();
		
		layout = createPopUpLayout();
		
	    window.setContent(layout);
	    
	    HealthVisAppUI.getCurrent().addWindow(window);
	}
	
	//================================================================================
    // Getter  Section
    //================================================================================
	
	/**
	 * get layout from pop-up view
	 * @return layout: VerticalLayout
	 */
	public VerticalLayout getPopUpLayout() {
		return layout;
	}
	
	/**
	 * get patient from pop-up view
	 * @return patient: Patient
	 */
	public Patient getcomboboxPatient() {
		return (Patient) comboboxPatient.getValue();
	}
	
	/**
	 * get location value from pop-up view
	 * @return location: String
	 */
	public String getTextFieldLocation() {
		return tfLoc.getValue();
	}
	
	/**
	 * get from-time value from pop-up view
	 * @return time: String
	 */
	public String getTextFieldFrom() {
		return tfFrom.getValue();
	}
	
	/**
	 * get to-time value from pop-up view
	 * @return time: String
	 */
	public String getTextFieldTo() {
		return tfTo.getValue();
	}
	
	/**
	 * get comment value from pop-up view
	 * @return comment: String
	 */
	public String getTextFieldComment() {
		return tfCom.getValue();
	}
	
	/**
	 * get date value from pop-up view
	 * @return date: Date
	 */
	public Date getPopupDateFieldDate() {
		return dfDate.getValue();
	}
	
	/**
	 * get button cancel from pop-up view
	 * @return save-button: Button
	 */
	public Button getButtonSave() {
		return butSave;
	}
	
	/**
	 * get button cancel from pop-up view
	 * @return cancel-button: Button
	 */
	public Button getButtonCancel() {
		return butCancel;
	}
	
	//================================================================================
    // Other  Section
    //================================================================================
	
	/**
	 * close the pop-up view (current window)
	 */
	public void close() {
		HealthVisAppUI.getCurrent().removeWindow(window);
	}
	
	//================================================================================
    // private methods  Section
    //================================================================================
	/**
	 * create layout for pop-up view
	 */
	private VerticalLayout createPopUpLayout() {
		
		//===============================
	    // layout Section
	    //===============================
		VerticalLayout layAll = new VerticalLayout();
		
		HorizontalLayout layPat = new HorizontalLayout();
		layPat.setHeight(COMPHEIGHT);
		
		HorizontalLayout layDate = new HorizontalLayout();
		layDate.setHeight(COMPHEIGHT);
		
		HorizontalLayout layLoc = new HorizontalLayout();
		layLoc.setHeight(COMPHEIGHT);
		
		HorizontalLayout layFrom = new HorizontalLayout();
		layFrom.setHeight(COMPHEIGHT);
		
		HorizontalLayout layTo = new HorizontalLayout();
		layTo.setHeight(COMPHEIGHT);
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(COMPHEIGHT);
		
		HorizontalLayout layBut = new HorizontalLayout();
		
		//===============================
	    // create Section
	    //===============================
	    this.createLabPat();
	    this.createLabDate();
	    this.createLabLoc();
	    this.createLabFrom();
	    this.createLabTo();
	    this.createLabCom();
	    
	    this.createCombobox();
	    
	    this.createTfLoc();
	    this.createTfFrom();
	    this.createTfTo();
	    this.createTfCom();
	    
		this.createDfDate();
		
		this.createButSave();
		this.createButCancel();
	    
	    //===============================
	    // Add Section
	    //===============================
	    layPat.addComponent(labPat);
	    layPat.addComponent(comboboxPatient);
	    
	    layDate.addComponent(labDate);
	    layDate.addComponent(dfDate);
	    
	    layLoc.addComponent(labLoc);
	    layLoc.addComponent(tfLoc);
	    
	    layFrom.addComponent(labFrom);
	    layFrom.addComponent(tfFrom);
	    
	    layTo.addComponent(labTo);
	    layTo.addComponent(tfTo);
	    
	    layCom.addComponent(labCom);
	    layCom.addComponent(tfCom);
	    
	    layBut.addComponent(butSave);
	    layBut.addComponent(butCancel);
	    
	    layAll.addComponent(layPat);
	    layAll.addComponent(layDate);
	    layAll.addComponent(layLoc);
	    layAll.addComponent(layFrom);
	    layAll.addComponent(layTo);
	    layAll.addComponent(layCom);
	    layAll.addComponent(layBut);
	    
		return layAll;
	}
	
	/**
	 * create label for patient
	 */
	private void createLabPat() {
		labPat = new Label("Patient");
	    labPat.setWidth(COMPWIDTH);
	}
	
	/**
	 * create label for date
	 */
	private void createLabDate() {
		labDate = new Label("Date");
	    labDate.setWidth(COMPWIDTH);
	}
	
	/**
	 * create label for location
	 */
	private void createLabLoc() {
		labLoc = new Label("Location");
	    labLoc.setWidth(COMPWIDTH);
	}
	
	/**
	 * create label for from (time)
	 */
	private void createLabFrom() {
		labFrom = new Label("From");
	    labFrom.setWidth(COMPWIDTH);
	}
	
	/**
	 * create label for to (time)
	 */
	private void createLabTo() {
		labTo = new Label("To");
	    labTo.setWidth(COMPWIDTH);
	}
	
	/**
	 * create label for comment
	 */
	private void createLabCom() {
		labCom = new Label("Coment");
	    labCom.setWidth(COMPWIDTH);
	}
	
	/**
	 * create combobox for patient with list patients
	 */
	private void createCombobox() {
		comboboxPatient = new ComboBox("");
		comboboxPatient.setInvalidAllowed(false);
		comboboxPatient.setWidth(COMPWIDTH);
		comboboxPatient.setNullSelectionAllowed(false);
		comboboxPatient.setNewItemsAllowed(false);   
		PatientController patCon = new PatientController();
		for(Patient p: patCon.getPatientsDefaultOrder())
		{
			comboboxPatient.addItems(p);
		}
	}
	
	/**
	 * create textfield for location
	 */
	private void createTfLoc() {
		tfLoc = new TextField();
	    tfLoc.setWidth(COMPWIDTH);
	}

	/**
	 * create textfield for from (time)
	 */
	private void createTfFrom() {
		tfFrom = new TextField();
	    tfFrom.setWidth(COMPWIDTH);
	}
	
	/**
	 * create textfield for to (time)
	 */
	private void createTfTo() {
		tfTo = new TextField();
	    tfTo.setWidth(COMPWIDTH);
	}
	
	/**
	 * create textarea for comment
	 */
	private void createTfCom() {
		tfCom = new TextArea();
	    tfCom.setHeight(COMPHEIGHT);
	    tfCom.setWidth(COMPWIDTH);
	}
	
	/**
	 * create datefield for date
	 */
	private void createDfDate() {
		dfDate = new PopupDateField();
	    dfDate.setWidth(COMPWIDTH);
	    dfDate.setDateFormat("dd/MM/yyyy");
	}
	
	/**
	 * create button for save
	 */
	private void createButSave() {
		butSave = new Button("Save");
	    butSave.setWidth(COMPWIDTH);
	    butSave.addClickListener(new AppointmentButtonClickHandler());
	}
	
	/**
	 * create button for cancel
	 */
	private void createButCancel() {
		butCancel = new Button("Cancel");
	    butCancel.setWidth(COMPWIDTH);
	    butCancel.addClickListener(new AppointmentButtonClickHandler());
	}
	
	/**
	 * create window for pop-up layout
	 */
	private void createWindow() {
		window = new Window("Add new appointment");
//				window.setModal(true);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
//				window.center();
	}
}
