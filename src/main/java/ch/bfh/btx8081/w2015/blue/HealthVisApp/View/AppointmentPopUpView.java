package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AppointmentPopUpView {
	
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "92";
	final static String COMPWIDTH = "155";
	
	private static AppointmentPopUpView appView = null; 
	VerticalLayout layout = null;
	
	Label labPat;
	Label labDate;
	Label labFrom;
	Label labTo;
	Label labCom;
	
	TextField tfPat;
	TextField tfDate;
	TextField tfFrom;
	TextField tfTo;
	
	TextArea tfCom;
	
	Button butSave;
	Button butCancel;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private AppointmentPopUpView() {
		
		//create window
		final Window window = new Window("Add new appointment");
//		window.setModal(true);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
//		window.center();
		
		HealthVisAppUI.getCurrent().addWindow(window);
		
		layout = createPopUpLayout();
		
	    window.setContent(layout);
	}
	
	private VerticalLayout createPopUpLayout() {
		
		VerticalLayout layAll = new VerticalLayout();
		
		HorizontalLayout layPat = new HorizontalLayout();
		layPat.setHeight(COMPHEIGHT);
		
		HorizontalLayout layDate = new HorizontalLayout();
		layDate.setHeight(COMPHEIGHT);
		
		HorizontalLayout layFrom = new HorizontalLayout();
		layFrom.setHeight(COMPHEIGHT);
		
		HorizontalLayout layTo = new HorizontalLayout();
		layTo.setHeight(COMPHEIGHT);
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(COMPHEIGHT);
		
		HorizontalLayout layBut = new HorizontalLayout();
		
	    labPat = new Label("Patient");
//	    labPat.setHeight(COMPHEIGHT);
	    labPat.setWidth(COMPWIDTH);
	    
	    labDate = new Label("Date");
//	    labDate.setHeight(COMPHEIGHT);
	    labDate.setWidth(COMPWIDTH);
	    
	    labFrom = new Label("From");
//	    labFrom.setHeight(COMPHEIGHT);
	    labFrom.setWidth(COMPWIDTH);
	    
	    labTo = new Label("To");
//	    labTo.setHeight(COMPHEIGHT);
	    labTo.setWidth(COMPWIDTH);
	    
	    labCom = new Label("Coment");
//	    labCom.setHeight(COMPHEIGHT);
	    labCom.setWidth(COMPWIDTH);
	    
	    tfPat = new TextField();
//	    tfPat.setHeight(COMPHEIGHT);
	    tfPat.setWidth(COMPWIDTH);
	    
	    tfDate = new TextField();
//	    tfDate.setHeight(COMPHEIGHT);
	    tfDate.setWidth(COMPWIDTH);
	    
	    tfFrom = new TextField();
//	    tfFrom.setHeight(COMPHEIGHT);
	    tfFrom.setWidth(COMPWIDTH);
	    
	    tfTo = new TextField();
//	    tfTo.setHeight(COMPHEIGHT);
	    tfTo.setWidth(COMPWIDTH);
	    
	    tfCom = new TextArea();
	    tfCom.setHeight(COMPHEIGHT);
	    tfCom.setWidth(COMPWIDTH);
	    
	    butSave = new Button("Save");
//	    butSave.setHeight(COMPHEIGHT);
	    butSave.setWidth(COMPWIDTH);
	    butSave.addClickListener(new CalendarButtonClickHandler());

	    butCancel = new Button("Cancel");
//	    butCancel.setHeight(COMPHEIGHT);
	    butCancel.setWidth(COMPWIDTH);
	    butCancel.addClickListener(new CalendarButtonClickHandler());
	    
	    layPat.addComponent(labPat);
	    layPat.addComponent(tfPat);
	    
	    layDate.addComponent(labDate);
	    layDate.addComponent(tfDate);
	    
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
	    layAll.addComponent(layFrom);
	    layAll.addComponent(layTo);
	    layAll.addComponent(layCom);
	    layAll.addComponent(layBut);
	    
		return layAll;
	}
	
	public static AppointmentPopUpView getInstance() {
		if (appView == null) {
			appView = new AppointmentPopUpView();
		}
		return appView;
	}
	
	public VerticalLayout getPopUpLayout() {
		return layout;
	}
	
	public String getTextFieldPatient() {
		return tfPat.getValue();
	}
	
	public String getTextFieldDate() {
		return tfDate.getValue();
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
	
	public Button getButtonSave() {
		return butSave;
	}
	
	public Button getButtonCancel() {
		return butCancel;
	}
}
