package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

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
