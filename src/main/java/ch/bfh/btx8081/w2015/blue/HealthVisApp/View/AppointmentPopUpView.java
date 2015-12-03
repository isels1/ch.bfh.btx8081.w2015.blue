package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

public class AppointmentPopUpView {

	private static AppointmentPopUpView appPopUpView = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private AppointmentPopUpView() {
		
	}
	
	public static CalendarView getInstance() {
		if (appPopUpView == null) {
			appPopUpView = new AppointmentPopUpView();
		}
		return appPopUpView;
	}
}
