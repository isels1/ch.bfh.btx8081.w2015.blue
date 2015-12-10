package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

public class AppointmentPopUpController {
	
	private AppointmentPopUpView appView;

	private DummyDataCreator ddc;
	
	public AppointmentPopUpController(){
		ddc = DummyDataCreator.getInstance();
	}
	
	public void createAppointmentPopUp() {
		appView = new AppointmentPopUpView();
	}
	
	public AppointmentPopUpView getAppView() {
		return appView;
	}
}
