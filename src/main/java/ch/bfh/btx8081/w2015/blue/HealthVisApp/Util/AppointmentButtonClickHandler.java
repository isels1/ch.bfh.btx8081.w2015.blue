package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.AppointmentPopUpController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class AppointmentButtonClickHandler implements Button.ClickListener{

	//================================================================================
    // Handler Data
    //================================================================================
	
	private UIController uiController = UIController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		AppointmentPopUpView appView = uiController.getAppPopUpController().getAppView();
		
		if(appView.getButtonSave() == event.getSource()) {
			uiController.saveAppointment();
			uiController.closeAppointmentPopUp();
		}
		
		if(appView.getButtonCancel() == event.getSource()) {
			uiController.closeAppointmentPopUp();
		}
	}
}
