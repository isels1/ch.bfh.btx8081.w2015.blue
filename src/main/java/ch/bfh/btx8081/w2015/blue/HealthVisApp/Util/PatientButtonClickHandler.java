package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class PatientButtonClickHandler implements Button.ClickListener {

	//================================================================================
    // Handler Data
    //================================================================================
	
	private UIController uiController = UIController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		PatientListPopUpView patView = uiController.getPatPopUpController().getPatView();
		
		if(patView.getButtonSave() == event.getSource()) {
			uiController.savePatient();
			uiController.closePatientPopUp();
		}
		
		if(patView.getButtonCancel() == event.getSource()) {
			uiController.closePatientPopUp();
		}
	}
}
