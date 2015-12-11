package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public class PatientStateArchived extends PatientState {

	private final String CSS = "patientStateArchived";
	private final int STATE_ID = 4;

	
	public PatientStateArchived() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
	}
}
