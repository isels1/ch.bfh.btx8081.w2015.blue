package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public class PatientStateNew extends PatientState{
	
	private final String CSS = "patientStateNew";
	private final int STATE_ID = 1;
	
	public PatientStateNew() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
	}
}
