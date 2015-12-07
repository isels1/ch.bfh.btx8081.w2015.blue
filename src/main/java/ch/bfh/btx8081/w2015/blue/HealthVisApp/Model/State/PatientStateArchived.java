package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public class PatientStateArchived extends PatientState {

	private final String COLOR = "LightRed";
	
	public PatientStateArchived() {
		super.setColor(COLOR);
	}
}
