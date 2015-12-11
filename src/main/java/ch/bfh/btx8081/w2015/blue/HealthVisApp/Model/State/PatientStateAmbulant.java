package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public class PatientStateAmbulant extends PatientState {

	private final String CSS = "patientStateAmbulant";
	private final int STATE_ID = 2;

	
	public PatientStateAmbulant() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
	}

}
