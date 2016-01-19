package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientListController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentButtonClickHandler;

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
	public Patient getComboboxPatient() {
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
		return taCom.getValue();
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
    // Setter  Section
    //================================================================================
	
	/**
	 * set location from textfield location
	 * @param location
	 */
	public void setTextFieldLocation(String location) {
		tfLoc.setValue(location);
	}
	
	/**
	 * set from from textfield from
	 * @param from
	 */
	public void setTextFieldFrom(String from) {
		tfFrom.setValue(from);
	}
	
	/**
	 * set to from textfield to
	 * @param to
	 */
	public void setTextFieldTo(String to) {
		tfTo.setValue(to);
	}
	
	/**
	 * set text from textfield comment
	 * @param comment
	 */
	public void setTextFieldComment(String comment) {
		taCom.setValue(comment);
	}

	/**
	 * set date from datefield
	 * @param date
	 */
	public void setPopupDateFieldDate(Date date) {
		dfDate.setValue(date);
	}
	
	/**
	 * set patient of combobox
	 * @param patient
	 */
	public void setComboboxPatient(Patient patient){
		comboboxPatient.setValue(patient);
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
		layout = new VerticalLayout();
		
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
		labPat = new Label();
		this.createLabel(labPat, "Patient", COMPWIDTH);
		labDate = new Label();
		this.createLabel(labDate, "Date", COMPWIDTH);
		labLoc = new Label();
		this.createLabel(labLoc, "Location", COMPWIDTH);
		labFrom = new Label();
		this.createLabel(labFrom, "From", COMPWIDTH);
		labTo = new Label();
		this.createLabel(labTo, "To", COMPWIDTH);
		labCom = new Label();
		this.createLabel(labCom, "Comment", COMPWIDTH);
	    
	    this.createCombobox();
	    
	    tfLoc = new TextField();
	    this.createTextField(tfLoc, COMPWIDTH, "");
	    tfFrom = new TextField();
	    this.createTextField(tfFrom, COMPWIDTH, "hh:mm");
	    tfTo = new TextField();
	    this.createTextField(tfTo, COMPWIDTH, "hh:mm");
	    
	    taCom = new TextArea();
	    this.createTextArea(taCom, COMPWIDTH, COMPHEIGHT, "");
	    
	    dfDate = new PopupDateField();
		this.createPopupDateField(dfDate, COMPWIDTH, DATEFORMAT);
		
		butSave = new Button();
		this.createButton(butSave, "Save", COMPWIDTH, new AppointmentButtonClickHandler());
		butCancel = new Button();
		this.createButton(butCancel, "Cancel", COMPWIDTH, new AppointmentButtonClickHandler());
	    
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
	    layCom.addComponent(taCom);
	    
	    layBut.addComponent(butSave);
	    layBut.addComponent(butCancel);
	    
	    layout.addComponent(layPat);
	    layout.addComponent(layDate);
	    layout.addComponent(layLoc);
	    layout.addComponent(layFrom);
	    layout.addComponent(layTo);
	    layout.addComponent(layCom);
	    layout.addComponent(layBut);
	    
		return layout;
	}
	
	/**
	 * create label for pop-up view
	 * @param label: Label
	 * @param labelContent: String
	 * @param width: String
	 */
	private void createLabel(Label label, String labelContent, String width) {
		label.setCaption(labelContent);
		label.setWidth(width);
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
		PatientListController patCon = PatientListController.getInstance();
		for(Patient p: patCon.getPatientsDefaultOrder())
		{
			comboboxPatient.addItems(p);
		}
	}
	
	/**
	 * create textfield for pop-up view
	 * @param tf: TextField
	 * @param width: String
	 * @param inputPrompt: String
	 */
	private void createTextField(TextField tf, String width, String inputPrompt) {
	    tf.setWidth(width);
	    tf.setInputPrompt(inputPrompt);
	}
	
	/**
	 * create textarea for comment
	 * @param ta: TextArea
	 * @param width: String
	 * @param height: String
	 * @param inputPrompt: String
	 */
	private void createTextArea(TextArea ta, String width, String height, String inputPrompt) {
	    ta.setHeight(height);
	    ta.setWidth(width);
	    ta.setInputPrompt(inputPrompt);
	}
	
	/**
	 * create popup-datefield for pop-up view
	 * @param df: PopupDateField
	 * @param width: String
	 * @param dateFormat: String
	 */
	private void createPopupDateField(PopupDateField df, String width, String dateFormat) {
	    df.setWidth(width);
	    df.setDateFormat(dateFormat);
	    df.setInputPrompt(dateFormat);
	}
	
	/**
	 * create button for pop-up view
	 * @param button: Button
	 * @param buttonName: String
	 * @param width: String
	 * @param appHandler: AppointmentButtonClickHandler
	 */
	private void createButton(Button button, String buttonName, String width, AppointmentButtonClickHandler appHandler) {
		button.setCaption(buttonName);
		button.setWidth(width);
		button.addClickListener(appHandler);
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
