package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateAmbulant;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateArchived;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateNew;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateStationary;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * shows a pop-up for adding a new patient
 * 
 * <ul>
 * 	save or cancel the creating of the new patient by two buttons
 * </ul>
 * <ul>
 * create a new patient by given attributes:
 * 	<li>
 * 		<b>
 * 		name	
 * 		</b>
 * 		: enter name from the patient
 * 	</li>
 * 	<li>
 * 		<b>
 * 		firstname	
 * 		</b>
 * 		: enter firstname from the patient 
 * 	</li>
 * 	<li>
 * 		<b>
 * 		id 
 * 		</b>
 * 		: enter id from the patient
 * 	</li>
 * 	<li>
 * 		<b>
 * 		birthdate	
 * 		</b>
 * 		: enter the birthdate from the patient (dd.MM.yyyy) or
 * 				  select date from attached calendar
 * 	</li>
 * 	<li>
 * 		<b>
 * 		address	
 * 		</b>
 * 		: enter the address from the patient by giving street, streetnumber, ZIP and city
 * 	</li>
 * 	<li>
 * 		<b>
 * 		phone	
 * 		</b>
 * 		: enter phone number from the patient
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
public class PatientListPopUpView {
	
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "61";				//568 / 9
	final static String HOR_LAY_HEIGHT = "61";			//568 / 9
	final static String VER_LAY_HEIGHT = "122";			//568 / 9 * 2
	final static String COMPWIDTH = "160";				//320 / 2
	final static String DATEFORMAT = "dd/MM/yyyy";
	
	AppointmentPopUpView appView = null; 
	VerticalLayout layout = null;
	
	Label labName;
	Label labFName;
	Label labId;
	Label labBDate;
	Label labAddr;
	Label labTel;
	Label labCom;
	Label labState;
	
	TextField tfName;
	TextField tfFName;
	TextField tfId;
	TextField tfAddr1;
	TextField tfAddr2;
	TextField tfTel;
	
	ComboBox cmbState;
	
	PopupDateField dfBDate;
	
	TextArea tfCom;
	
	Button butSave;
	Button butCancel;
	
	Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the pop-up view for add a new patient
	 */
	public PatientListPopUpView() {
		
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
	 * get name value from pop-up view
	 * @return name: String
	 */
	public String getTextFieldName() {
		return tfName.getValue();
	}
	
	/**
	 * get firstname value from pop-up view
	 * @return firstname: String
	 */
	public String getTextFieldFirstname() {
		return tfFName.getValue();
	}
	
	/**
	 * get id from pop-up view
	 * @return id: int
	 */
	public int getTextFieldId() {
		return Integer.parseInt(tfId.getValue());
	}
	
	/**
	 * get address value from pop-up view
	 * @return add1+addr2: String
	 */
	public String getTextFieldAddress() {
		return tfAddr1.getValue() + " " + tfAddr2.getValue();
	}
	
	/**
	 * get phone value from pop-up view
	 * @return tel: String
	 */
	public String getTextFieldTel() {
		return tfTel.getValue();
	}
	
	/**
	 * get comment value from pop-up view
	 * @return Com: String
	 */
	public String getTextFieldComment() {
		return tfCom.getValue();
	}
	
	/**
	 * get date from pop-up view
	 * @return date: Date
	 */
	public Date getPopupDateFieldDate() {
		return dfBDate.getValue();
	}
	
	/**
	 * get state from pop-up view
	 * @return state: PatientState
	 */
	public PatientState getCmBoxPatientState(){
		return (PatientState) cmbState.getValue();
	}
	
	/**
	 * get save button from pop-up view
	 * @return butSave: Button
	 */
	public Button getButtonSave() {
		return butSave;
	}
	
	/**
	 * get cancel button from pop-up view
	 * @return butCancel: Button
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
		
		//================================================================================
	    // Layout Section
	    //================================================================================
		
		VerticalLayout layAll = new VerticalLayout();
		
		HorizontalLayout layName = new HorizontalLayout();
		layName.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layFName = new HorizontalLayout();
		layFName.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layId = new HorizontalLayout();
		layId.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layBDate = new HorizontalLayout();
		layBDate.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layAddr = new HorizontalLayout();
		
		VerticalLayout layAddr1 = new VerticalLayout();
		layAddr1.setHeight(VER_LAY_HEIGHT);
		
		VerticalLayout layAddr2 = new VerticalLayout();
		layAddr2.setHeight(VER_LAY_HEIGHT);
		
		HorizontalLayout layTel = new HorizontalLayout();
		layTel.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layState = new HorizontalLayout();
		layState.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layBut = new HorizontalLayout();
		
		//================================================================================
	    // create Section
	    //================================================================================
		
	    labName = new Label();
	    this.createLabel(labName, "Name", COMPWIDTH);
	    labFName = new Label();
	    this.createLabel(labFName, "Firstame", COMPWIDTH);
	    labId = new Label();
	    this.createLabel(labId, "Patient-Id", COMPWIDTH);
	    labBDate = new Label();
	    this.createLabel(labBDate, "Birthdate", COMPWIDTH);
	    labAddr = new Label();
	    this.createLabel(labAddr, "Address", COMPWIDTH);
	    labTel = new Label();
	    this.createLabel(labTel, "Phone", COMPWIDTH);
	    labCom = new Label();
	    this.createLabel(labCom, "Comment", COMPWIDTH);
	    labState = new Label();
	    this.createLabel(labState, "Patient State", COMPWIDTH);
	    
	    tfName = new TextField();
	    this.createTextField(tfName, COMPWIDTH, "");
	    tfFName = new TextField();
	    this.createTextField(tfFName, COMPWIDTH, "");
	    tfId = new TextField();
	    this.createTextField(tfId, COMPWIDTH, "");
	    tfAddr1 = new TextField();
	    this.createTextField(tfAddr1, COMPWIDTH, "Street Number");
	    tfAddr2 = new TextField();
	    this.createTextField(tfAddr2, COMPWIDTH, "ZIP City");
	    tfTel = new TextField();
	    this.createTextField(tfTel, COMPWIDTH, "");
	    
	    tfCom = new TextArea();
	    this.createTextArea(tfCom, COMPWIDTH, COMPHEIGHT, "");

	    dfBDate = new PopupDateField();
	    this.createPopupDateField(dfBDate, COMPWIDTH, DATEFORMAT);
	    
	    cmbState = new ComboBox();
	    this.createCombobox();
	    
	    butSave = new Button();
		this.createButton(butSave, "Save", COMPWIDTH, new PatientButtonClickHandler());
		butCancel = new Button();
		this.createButton(butCancel, "Cancel", COMPWIDTH, new PatientButtonClickHandler());
	    
	    //================================================================================
	    // Add Section
	    //================================================================================
	    
	    layName.addComponent(labName);
	    layName.addComponent(tfName);
	    
	    layFName.addComponent(labFName);
	    layFName.addComponent(tfFName);
	    
	    layId.addComponent(labId);
	    layId.addComponent(tfId);
	    
	    layBDate.addComponent(labBDate);
	    layBDate.addComponent(dfBDate);
	    
	    layAddr.addComponent(layAddr1);
	    layAddr.addComponent(layAddr2);
	    
	    layAddr1.addComponent(labAddr);
	    
	    layAddr2.addComponent(tfAddr1);
	    layAddr2.addComponent(tfAddr2);
	    
	    layTel.addComponent(labTel);
	    layTel.addComponent(tfTel);
	    
	    layState.addComponent(labState);
	    layState.addComponent(cmbState);
	    
	    layCom.addComponent(labCom);
	    layCom.addComponent(tfCom);
	    
	    layBut.addComponent(butSave);
	    layBut.addComponent(butCancel);
	    
	    layAll.addComponent(layName);
	    layAll.addComponent(layFName);
	    layAll.addComponent(layId);
	    layAll.addComponent(layBDate);
	    layAll.addComponent(layAddr);
	    layAll.addComponent(layTel);
	    layAll.addComponent(layState);
	    layAll.addComponent(layCom);
	    layAll.addComponent(layBut);
	    
		return layAll;
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
	 * create combobox for state with list states
	 */
	private void createCombobox() {
		cmbState.setInvalidAllowed(false);
	    cmbState.setWidth(COMPWIDTH);
	    cmbState.setNullSelectionAllowed(false);
	    cmbState.setNewItemsAllowed(false); 
	    
	    cmbState.addItems(new PatientStateNew(),
	    				  new PatientStateAmbulant(), 
	    				  new PatientStateStationary(), 
	    				  new PatientStateArchived());
	    cmbState.setValue(new PatientStateNew());
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
	 * @param patHandler: PatientButtonClickHandler
	 */
	private void createButton(Button button, String buttonName, String width, PatientButtonClickHandler appHandler) {
		button.setCaption(buttonName);
		button.setWidth(width);
		button.addClickListener(appHandler);
	}
	
	/**
	 * create window for pop-up layout
	 */
	private void createWindow() {
		window = new Window("Add new patient");
//				window.setModal(true);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
//				window.center();
	}
}
