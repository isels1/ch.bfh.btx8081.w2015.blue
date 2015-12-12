package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientListButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class PatientListPopUpView {
	
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "61";				//568 / 9
	final static String HOR_LAY_HEIGHT = "61";			//568 / 9
	final static String VER_LAY_HEIGHT = "122";			//568 / 9 * 2
	final static String COMPWIDTH = "160";				//320 / 2
	
	AppointmentPopUpView appView = null; 
	VerticalLayout layout = null;
	
	Label labName;
	Label labFName;
	Label labId;
	Label labBDate;
	Label labAddr;
	Label labTel;
	Label labCom;
	
	TextField tfName;
	TextField tfFName;
	TextField tfId;
	TextField tfAddr1;
	TextField tfAddr2;
	TextField tfTel;
	
	PopupDateField dfBDate;
	
	TextArea tfCom;
	
	Button butSave;
	Button butCancel;
	
	final Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public PatientListPopUpView() {
		
		//create window
		window = new Window("Add new appointment");
//		window.setModal(true);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
//		window.center();
		
		layout = createPopUpLayout();
		
	    window.setContent(layout);
	    
	    HealthVisAppUI.getCurrent().addWindow(window);
	}
	
	public void close() {
		HealthVisAppUI.getCurrent().removeWindow(window);
	}
	
	public VerticalLayout getPopUpLayout() {
		return layout;
	}
	
	public String getTextFieldName() {
		return tfName.getValue();
	}
	
	public String getTextFieldFirstname() {
		return tfFName.getValue();
	}
	
	public String getTextFieldId() {
		return tfId.getValue();
	}
	
	public String getTextFieldAddress() {
		return tfAddr1.getValue() + " " + tfAddr2.getValue();
	}
	
	public String getTextFieldTel() {
		return tfTel.getValue();
	}
	
	public String getTextFieldComment() {
		return tfCom.getValue();
	}
	
	public Date getPopupDateFieldDate() {
		return dfBDate.getValue();
	}
	
	public Button getButtonSave() {
		return butSave;
	}
	
	public Button getButtonCancel() {
		return butCancel;
	}
	
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
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(HOR_LAY_HEIGHT);
		
		HorizontalLayout layBut = new HorizontalLayout();
		
		//================================================================================
	    // Label Section
	    //================================================================================
		
	    labName = new Label("Name");
	    labName.setWidth(COMPWIDTH);
	    
	    labFName = new Label("Firstname");
	    labFName.setWidth(COMPWIDTH);
	    
	    labId = new Label("Patient-Id");
	    labId.setWidth(COMPWIDTH);
	    
	    labBDate = new Label("Birthdate");
	    labBDate.setWidth(COMPWIDTH);
	    
	    labAddr = new Label("Address");
	    labAddr.setWidth(COMPWIDTH);
	    
	    labTel = new Label("Phone");
	    labTel.setWidth(COMPWIDTH);
	    
	    labCom = new Label("Comment");
	    labCom.setWidth(COMPWIDTH);
	    
	    //================================================================================
	    // Textfield Section
	    //================================================================================
	    
	    tfName = new TextField();
	    tfName.setWidth(COMPWIDTH);
	    
	    tfFName = new TextField();
	    tfFName.setWidth(COMPWIDTH);
	    
	    tfId = new TextField();
	    tfId.setWidth(COMPWIDTH);
	    
	    tfAddr1 = new TextField();
	    tfAddr1.setWidth(COMPWIDTH);
	    
	    tfAddr2 = new TextField();
	    tfAddr2.setWidth(COMPWIDTH);
	    
	    tfTel = new TextField();
	    tfTel.setWidth(COMPWIDTH);
	    
	    tfCom = new TextArea();
	    tfCom.setHeight(COMPHEIGHT);
	    tfCom.setWidth(COMPWIDTH);

	    //================================================================================
	    // DateField Section
	    //================================================================================
	    
	    dfBDate = new PopupDateField();
	    dfBDate.setWidth(COMPWIDTH);
	    dfBDate.setDateFormat("dd/MM/yyyy");
	    
	    //================================================================================
	    // Button Section
	    //================================================================================
	    
	    butSave = new Button("Save");
	    butSave.setWidth(COMPWIDTH);
	    butSave.addClickListener(new PatientButtonClickHandler());

	    butCancel = new Button("Cancel");
	    butCancel.setWidth(COMPWIDTH);
	    butCancel.addClickListener(new PatientButtonClickHandler());
	    
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
	    layAll.addComponent(layCom);
	    layAll.addComponent(layBut);
	    
		return layAll;
	}
}
