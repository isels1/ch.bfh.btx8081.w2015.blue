package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Treatment
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a treatment. 
 * </span>
 * <br>
 * <br>
 * The Treatment contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				treatment:
 * 			</font> 
 * 			<i>String</i>
 * 			- The treatment for the Patient
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new treatment you need necessary at least following informations:
 * 	<ul>
 * 		<li>treatment</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		17.12.2015
 * </span>
 * <br><br>
 * @author hugil1
 * @version 0.0
 */
public class Treatment {
	//================================================================================
    // Treatment Data
    //================================================================================
	
	String treatment;
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor is used for testing.
	 */
	
	public Treatment() {
	}
	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The getter for the treatment
	 * @return treatment the Treatment /String
	 */
	
	public String getComment() {
		return treatment;
	}
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the comment
	 * @return comment the Comment /String
	 */
	
	public String getTreatment() {
		return treatment;
	}
	
	/**
	 * The string representation is "treatment"
	 * @return the string representation of the treatment /String
	 */
	@Override
	public String toString() {
		return treatment;
	}
}
