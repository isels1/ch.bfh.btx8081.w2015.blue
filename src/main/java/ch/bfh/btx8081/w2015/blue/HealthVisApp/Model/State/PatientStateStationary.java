package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

/**
 * 
 * @author Stefan Iseli
 *
 */
public class PatientStateStationary extends PatientState {

	private final String CSS = "patientStateStationary";
	private final int STATE_ID = 3;
	private final String NAME = "Stationary";

	/**
	 * 
	 */
	public PatientStateStationary() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}

}
