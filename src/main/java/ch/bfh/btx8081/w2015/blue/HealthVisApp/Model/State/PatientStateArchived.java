package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientStateArchived
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
 * The PatientStateArchived contains following information:
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
@Entity
@DiscriminatorValue("archived")
@Table(name="stateArchived")
public class PatientStateArchived extends PatientState {

	//================================================================================
    // PatientStateArchived Data
    //================================================================================
	
	@Id
	private int id;
	
	private String colourCode;
	private String name;

	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * The constructor for the state "archived"
	 * Sets the css, the id and the state name to abstract parent class.
	 */
	public PatientStateArchived() {
		if (id == 0) {
			id = 4;
		}
	}
	
	public String getColorCode(){
		return colourCode;
	}
	
	public String getPatientStateName(){
		return name;
	}
	
	public void setColorCode(String cc){
		colourCode = cc;
	}

	public void setPatientStateName(String n){
		name = n;
	}
	
	@Override
	public String toString(){
		return name;
		
	}
}
