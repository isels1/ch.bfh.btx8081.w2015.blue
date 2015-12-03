package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

public class PatientListView {

	private static PatientListView patListView = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListView() {
		
	}
	
	public static PatientListView getInstance() {
		if (patListView == null) {
			patListView = new PatientListView();
		}
		return patListView;
	}
}
