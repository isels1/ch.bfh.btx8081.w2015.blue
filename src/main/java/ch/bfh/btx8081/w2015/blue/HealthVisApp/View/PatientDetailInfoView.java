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
	Label labTel1;
	Label labTel2;
	
	TextArea taCom1;
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
		
		HorizontalLayout layAddr = new HorizontalLayout();
		layAddr.setHeight(COMPHEIGHT);
		
		HorizontalLayout layTel = new HorizontalLayout();
		layTel.setHeight(COMPHEIGHT);
		
		HorizontalLayout layCom = new HorizontalLayout();
		layCom.setHeight(COMPHEIGHT);
		
		//===============================
	    // create Section
	    //===============================
		labId1 = new Label();
		labId2 = new Label();
		this.createLabel(labId1, "Id", COMPWIDTH);
		
		labState1 = new Label();
		labState2 = new Label();
		this.createLabel(labState1, "Id", COMPWIDTH);
		
		labDate1 = new Label();
		labDate2 = new Label();
		this.createLabel(labDate1, "B-Date", COMPWIDTH);
		
		labAddr1 = new Label();
		labAddr2 = new Label();
		this.createLabel(labAddr1, "Address", COMPWIDTH);
		
		labTel1 = new Label();
		labTel2 = new Label();
		this.createLabel(labTel1, "Phone", COMPWIDTH);
		
		taCom1 = new TextArea();
		taCom2 = new TextArea();
		this.createTextArea(taCom1, COMPWIDTH, TEXTHEIGHT, "Note");
		
		//===============================
	    // Add Section
	    //===============================
	    layId.addComponent(labId1);
	    layId.addComponent(labId2);
	    
	    layState.addComponent(labState1);
	    layState.addComponent(labState2);
	    
	    layDate.addComponent(labDate1);
	    layDate.addComponent(labDate2);
	    
	    layAddr.addComponent(labAddr1);
	    layAddr.addComponent(labAddr2);
	    
	    layTel.addComponent(labTel1);
	    layTel.addComponent(labTel2);
	    
	    layCom.addComponent(taCom1);
	    layCom.addComponent(taCom2);
	    
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
		this.createLabel(labDate2, pat.getBirthdate().toString(), COMPWIDTH);
		this.createLabel(labAddr2, pat.getAddress().getStreet() 
									+ " " + pat.getAddress().getStreetNr()
									+ "\n" + pat.getAddress().getZIP() 
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
