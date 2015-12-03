package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

public class PatientListPopUpView {

	private static PatientListPopUpView patListPopUpView = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListPopUpView() {
		
	}
	
	public static PatientListPopUpView getInstance() {
		if (patListPopUpView == null) {
			patListPopUpView = new PatientListPopUpView();
		}
		return patListPopUpView;
	}
}
