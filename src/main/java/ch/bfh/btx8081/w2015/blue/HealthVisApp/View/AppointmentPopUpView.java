package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.util.Date;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.AppointmentButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AppointmentPopUpView {
	
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
	
	TextField tfPat;
	TextField tfDate;
	TextField tfLoc;
	TextField tfFrom;
	TextField tfTo;
	
	PopupDateField dfDate;
	
	TextArea tfCom;
	
	Button butSave;
	Button butCancel;
	
	final Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	public AppointmentPopUpView() {
		
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
	
	public String getTextFieldPatient() {
		return tfPat.getValue();
	}
	
	public String getTextFieldLocation() {
		return tfLoc.getValue();
	}
	
	public String getTextFieldFrom() {
		return tfFrom.getValue();
	}
	
	public String getTextFieldTo() {
		return tfTo.getValue();
	}
	
	public String getTextFieldComent() {
		return tfCom.getValue();
	}
	
	public Date getPopupDateFieldDate() {
		return dfDate.getValue();
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
		
		//================================================================================
	    // Label Section
	    //================================================================================
		
	    labPat = new Label("Patient");
	    labPat.setWidth(COMPWIDTH);
	    
	    labDate = new Label("Date");
	    labDate.setWidth(COMPWIDTH);
	    
	    labLoc = new Label("Location");
	    labLoc.setWidth(COMPWIDTH);
	    
	    labFrom = new Label("From");
	    labFrom.setWidth(COMPWIDTH);
	    
	    labTo = new Label("To");
	    labTo.setWidth(COMPWIDTH);
	    
	    labCom = new Label("Coment");
	    labCom.setWidth(COMPWIDTH);
	    
	    //================================================================================
	    // Textfield Section
	    //================================================================================
	    
	    tfPat = new TextField();
	    tfPat.setWidth(COMPWIDTH);
	    
	    tfLoc = new TextField();
	    tfLoc.setWidth(COMPWIDTH);
	    
	    tfFrom = new TextField();
	    tfFrom.setWidth(COMPWIDTH);
	    
	    tfTo = new TextField();
	    tfTo.setWidth(COMPWIDTH);
	    
	    tfCom = new TextArea();
	    tfCom.setHeight(COMPHEIGHT);
	    tfCom.setWidth(COMPWIDTH);
	    
	    //================================================================================
	    // Datefield Section
	    //================================================================================

	    dfDate = new PopupDateField();
	    dfDate.setWidth(COMPWIDTH);
	    dfDate.setDateFormat("dd/MM/yyyy");
	    
	    //================================================================================
	    // Button Section
	    //================================================================================
	    
	    butSave = new Button("Save");
	    butSave.setWidth(COMPWIDTH);
	    butSave.addClickListener(new AppointmentButtonClickHandler());

	    butCancel = new Button("Cancel");
	    butCancel.setWidth(COMPWIDTH);
	    butCancel.addClickListener(new AppointmentButtonClickHandler());
	    
	    //================================================================================
	    // Add Section
	    //================================================================================
	    
	    layPat.addComponent(labPat);
	    layPat.addComponent(tfPat);
	    
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
}
