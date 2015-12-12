package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

/**
 * 
 * @author Stefan Iseli
 *
 */
public class PatientStateAmbulant extends PatientState {

	private final String CSS = "patientStateAmbulant";
	private final int STATE_ID = 2;
	private final String NAME = "Ambulant";

	/**
	 * 
	 */
	public PatientStateAmbulant() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}

}
