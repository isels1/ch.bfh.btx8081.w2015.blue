package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

/**
 * Abstract Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientState
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a patient state.
 * </span>
 * <br>
 * <br>
 * The PatientState contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				css:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the custom css for the bg-color
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				id:
 * 			</font> 
 * 			<i>integer</i>
 * 			- For the identification of the sate
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				name:
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
public abstract class PatientState {
	
	//================================================================================
    // PatientState Data
    //================================================================================
	
	private String css = "";
	private int id;
	private String name = "";
	
	//================================================================================
    // State Event Section
    //================================================================================
	
	/**
	 * Function which is called on enter the state.
	 * @return css: The name of the custom css for the bg-color
	 */
	public String doEnter(){
		return css;
	}
	
	/**
	 * Function which is executed while in state
	 * --DO: NOTHING
	 */
	public void doWhile(){}
	
	/**
	 * Function which is executed on exit the state
	 * --DO: NOTHING
	 */
	public void doExit(){}
	
	//================================================================================
    // Setter Section
    //================================================================================
	
	/**
	 * The function to set the css string
	 * @param c: String for the bg-color (css property)
	 */
	public void setColor(String c){
		css = c;
	}
	
	/**
	 * The function to set the id (int)
	 * @param id: int for the identification of the sate
	 */
	public void setPatientStateId(int id){
		this.id = id;
	}

	/**
	 * The function to set the name string
	 * @param n: String for the name of the state (to show in gui)
	 */
	public void setPatientStateName(String n){
		name = n;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================	
	
	/**
	 * The function to get the id (int)
	 * @return id: int for the identification of the sate
	 */
	public int getPatientStateId(){
		return id;
	}
	
	/**
	 * The function to get the name string
	 * @return name: String for the name of the state (to show in gui)
	 */
	public String getPatientStateName(){
		return name;
	}
	
	
	@Override
	public String toString(){
		return name;
		
	}
}
