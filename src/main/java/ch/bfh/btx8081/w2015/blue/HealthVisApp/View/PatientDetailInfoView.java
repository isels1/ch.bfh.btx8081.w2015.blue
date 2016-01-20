package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;


import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

//TODO

public class PatientDetailInfoView {

	//================================================================================
    // AppointmentPopUpView  Data
    //================================================================================
	final static String HEIGHT = TabView.HEIGHT;
	final static String WIDTH = TabView.WIDTH;
	final static String COMPHEIGHT = "44";				//356 full
	final static String TEXTHEIGHT = "88";				//356 full
	final static String ADDRHEIGHT = "70";				//356 full
	final static String COMPWIDTH = "159";				//318 full
	final static String DATEFORMAT = "dd.MM.yyyy";
	
	VerticalLayout layout = null;

	Label labId1;
	Label labId2;
	Label labState1;
	Label labState2;
	Label labDate1;
	Label labDate2;
	Label labAddr1;
	Label labAddr2;
	Label labAddr3;
	Label labTel1;
	Label labTel2;
	Label labCom1;
	
	TextArea taCom2;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the detail info view for a patient
	 */
	public PatientDetailInfoView() {
		
		//===============================
	    // layout Section
	    //===============================
		layout = new VerticalLayout();
		
		HorizontalLayout layId = new HorizontalLayout();
		layId.setHeight(COMPHEIGHT);
		
		HorizontalLayout layState = new HorizontalLayout();
		layState.setHeight(COMPHEIGHT);
		
		HorizontalLayout layDate = new HorizontalLayout();
		layDate.setHeight(COMPHEIGHT);
		
		HorizontalLayout layAddr1 = new HorizontalLayout();
		layAddr1.setHeight(ADDRHEIGHT);
		
		HorizontalLayout layTel = new HorizontalLayout();
		layTel.setHeight(COMPHEIGHT);
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(TEXTHEIGHT);
		
		VerticalLayout layAddr2 = new VerticalLayout();
		layAddr2.setHeight(ADDRHEIGHT);
		
		//===============================
	    // create Section
	    //===============================
		labId1 = new Label();
		labId2 = new Label();
		this.createLabel(labId1, "Id", COMPWIDTH);
		
		labState1 = new Label();
		labState2 = new Label();
		this.createLabel(labState1, "State", COMPWIDTH);
		
		labDate1 = new Label();
		labDate2 = new Label();
		this.createLabel(labDate1, "B-Date", COMPWIDTH);
		
		labAddr1 = new Label();
		labAddr2 = new Label();
		labAddr3 = new Label();
		this.createLabel(labAddr1, "Address", COMPWIDTH);
		
		labTel1 = new Label();
		labTel2 = new Label();
		this.createLabel(labTel1, "Phone", COMPWIDTH);
		
		labCom1 = new Label();
		taCom2 = new TextArea();
		this.createLabel(labCom1, "Note", COMPWIDTH);
		
		//===============================
	    // Add Section
	    //===============================
	    layId.addComponent(labId1);
	    layId.addComponent(labId2);
	    
	    layState.addComponent(labState1);
	    layState.addComponent(labState2);
	    
	    layDate.addComponent(labDate1);
	    layDate.addComponent(labDate2);
	    
	    layAddr1.addComponent(labAddr1);
	    layAddr1.addComponent(layAddr2);
	    
	    layAddr2.addComponent(labAddr2);
	    layAddr2.addComponent(labAddr3);
	    
	    layTel.addComponent(labTel1);
	    layTel.addComponent(labTel2);
	    
	    layCom.addComponent(labCom1);
	    layCom.addComponent(taCom2);
	    
	    layout.addComponent(layId);
	    layout.addComponent(layState);
	    layout.addComponent(layDate);
	    layout.addComponent(layAddr1);
	    layout.addComponent(layTel);
	    layout.addComponent(layCom);
	    
	}
	
	/**
	 * Get the layout from detail info view
	 * @return layout: VerticalLayout
	 */
	public VerticalLayout getLayout() {
		return layout;
	}
	
	/**
	 * Set the patient of the view an refresh it
	 */
	public void setPatient(Patient pat) {
		this.createLabel(labId2, pat.getId() + "", COMPWIDTH);
		this.createLabel(labState2, pat.getPatientState().toString(), COMPWIDTH);
		this.createLabel(labDate2, pat.getBirthdate().getDate() + "." 
								+ (pat.getBirthdate().getMonth() + 1) + "." 
								+ (pat.getBirthdate().getYear() + 1900), COMPWIDTH);
		this.createLabel(labAddr2, pat.getAddress().getStreet() 
										+ " " + pat.getAddress().getStreetNr(), COMPWIDTH);
		this.createLabel(labAddr3, pat.getAddress().getZIP() 
										+ " " + pat.getAddress().getCity(), COMPWIDTH);
		this.createLabel(labTel2, pat.getPhone(), COMPWIDTH);
		this.createTextArea(taCom2, COMPWIDTH, TEXTHEIGHT, pat.getComment().toString());
	}
	
	/**
	 * create label for detail info view
	 * @param label: Label
	 * @param labelContent: String
	 * @param width: String
	 */
	private void createLabel(Label label, String labelContent, String width) {
		label.setCaption(labelContent);
		label.setWidth(width);
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
}
