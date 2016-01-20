package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.PatientDetailButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Class TODO
 * <span class="courier">
 * <font face="courier new">
 * 		PatietnListView
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		creates an instance of a PatientListView.
 * </span>
 * <br>
 * <br>
 * the PatietnListView contains following Vaadin Elements:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Combobox:</b>
 * 			</font> 
 * 			<i>Combobox</i>
 * 			 - whit a Filter for each Patient State
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Table:</b>
 * 			</font> 
 * 			<i>Table</i>
 * 			- List whit all patients
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Button:</b>
 * 			</font> 
 * 			<i>Button</i>
 * 			- add a new patient Button
 * 		</li>
 *	 </ul>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		01.12.2015
 * </span>
 * <br><br>
 * @author zwahf1
 * @version 1.0
 */
public class PatientDetailView {

	private static PatientDetailView patDetailView = null;
	
	//================================================================================
    // PatietnDetail  Data
    //================================================================================
		
	final static String WIDTH = "318";
	final static String HEIGHT_COMP = "40";	//396 full
	final static String HEIGHT_TAB = "376";	//396 full
	
	private VerticalLayout patientViewTab;//the whole patient View is on this Layout
	
	private Patient pat;
	private Label patientName;
	private TabSheet patientTabSheet;
	private Button b_edit = new Button("Edit");
	private Button b_quit = new Button("Quit");
	
	private PatientDetailInfoView patDetInfoView = null;
	private PatientDetailOverviewView patDetOverView = null;
	private PatientDetailAppointmentView patDetAppView = null;
	
	
	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * Constructor for the Patient Detail View
	 * Initializes...
	 * ... the Table View
	 * ... the edit Button
	 * ... the quit Button
	 */
	private PatientDetailView() {
		//add all components to the patientViewTab
		patientViewTab = new VerticalLayout();
		
		initPatientName();	//add label with name
		initTabSheet();		//add Tab sheet with all patient infos
		initEditButton();	//finally add button with edit
		initQuitButton();	//finally add button with quit

		patientViewTab.addComponent(patientName);
		patientViewTab.addComponent(patientTabSheet);	
		patientViewTab.addComponent(b_edit);
		patientViewTab.addComponent(b_quit);
	}
	
	/**
	 * Set the patient
	 * @param pat: Patient
	 */
	public void setPatient(Patient pat) {
		this.pat = pat;
		refreshView(pat);
		
	}
	
	/**
	 * Get the patient
	 * @return pat: Patient
	 */
	public Patient getPatient() {
		return pat;
	}
	
	/**
	 * @return patientViewTab 
	 * return this for the PatientView
	 */
	public VerticalLayout getPatientDetail(){	
		return patientViewTab;
	}
	
	/**
	 * @return the b_edit
	 */
	public Button getB_edit() {
		return b_edit;
	}
	
	/**
	 * @return the b_quit
	 */
	public Button getB_quit() {
		return b_quit;
	}
	
	/**
	 * @return the name label
	 */
	public Label getLabelName() {
		return patientName;
	}
	
	/**
	 * @return the instance of the Class
	 */
	public static PatientDetailView getInstance() {
		if (patDetailView == null) {
			patDetailView = new PatientDetailView();
		}		
		return patDetailView;
	}
	
	/**TODO
	 * refresh the Table whit the patient list
	 * 
	 * 	 * Filters the PatientList to the Status
	 * 
	 * 	- Ambulant
	 *  - Stationary
	 *  - New
	 *  - Archived
	 *  - All Patinet
	 *  
	 */
	public void refreshView(Patient pat){
		this.pat = pat;
		patDetInfoView.setPatient(pat);
		patDetOverView.setPatient(pat);
		patDetAppView.setPatient(pat);
		Label caption = new Label("" + pat.getFirstName() + " " + pat.getName());
		patientTabSheet.setCaption(caption.getValue());
	}
	
	//================================================================================
    // Private Helper Section
    //================================================================================
    
	/**
	 * init the Label for the Patient name and add it to the Vertical Layout
	 * 
	 */
	private void initPatientName(){
		patientName = new Label();
		patientName.setWidth(WIDTH);
		patientName.setHeight(HEIGHT_COMP);
	}
	
	/**
	 * init the Table for the Patient list and add it to the Vertical Layout
	 * 
	 */
	private void initTabSheet(){
//		
        patientTabSheet = new TabSheet();
        patientTabSheet.setHeight(HEIGHT_TAB);
        patientTabSheet.setWidth(WIDTH);
        patientTabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        patientTabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        patDetInfoView = new PatientDetailInfoView();
        patientTabSheet.addTab(patDetInfoView.getLayout(), "Infos");
        
        patDetOverView = new PatientDetailOverviewView();
        patientTabSheet.addTab(patDetOverView.getLayout(), "Treatments");

        patDetAppView = new PatientDetailAppointmentView();
        patientTabSheet.addTab(patDetAppView.getLayout(), "Appointments");
	}
	
	/**
	 * init the edit Button for the Patient detail and add it to the Vertical Layout
	 * 
	 */
	private void initEditButton (){
		b_edit = new Button("Edit");
		b_edit.setWidth(WIDTH);
		b_edit.setHeight(HEIGHT_COMP);
		b_edit.addClickListener(new PatientDetailButtonClickHandler());
	}
	
	/**
	 * init the quit Button for the Patient detail and add it to the Vertical Layout
	 * 
	 */
	private void initQuitButton (){
		b_quit = new Button("Quit");
		b_quit.setWidth(WIDTH);
		b_quit.setHeight(HEIGHT_COMP);
		b_quit.addClickListener(new PatientDetailButtonClickHandler());
	}
}
