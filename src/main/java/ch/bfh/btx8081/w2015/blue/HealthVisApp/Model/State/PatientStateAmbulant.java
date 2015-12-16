package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientStateAmbulant
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>extends</b> PatientState
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a patient state.
 * </span>
 * <br>
 * <br>
 * The PatientStateAmbulant contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				final CSS:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the custom css for the bg-color
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				final STATE_ID:
 * 			</font> 
 * 			<i>integer</i>
 * 			- For the identification of the sate
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				final NAME:
 * 			</font> 
 * 			<i>String</i>
 * 			- For the name of the state (to show in gui)
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		09.12.2015
 * </span>
 * <br><br>
 * @author isels1
 * @version 1.0
 */
public class PatientStateAmbulant extends PatientState {

	//================================================================================
    // PatientStateAmbulant Data
    //================================================================================
	
	private final String CSS = "patientStateAmbulant";
	private final int STATE_ID = 2;
	private final String NAME = "Ambulant";

	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * The constructor for the state "ambulant"
	 * Sets the css, the id and the state name to abstract parent class.
	 */
	public PatientStateAmbulant() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}

}
