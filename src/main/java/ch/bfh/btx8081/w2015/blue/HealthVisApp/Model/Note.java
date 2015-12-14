package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

public class Note {
	
	//================================================================================
    // Note Data
    //================================================================================
	
	String comment;
	//================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor is used for testing.
	 */
	
	public Note() {
	}
	//================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the comment
	 * @param comment The Comment /String
	 */
	
	public void setComment(String com) {
		this.comment = com;
	}
	//================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter the comment
	 * @return comment The Comment /String
	 */
	
	public String getComment() {
		return comment;
	}
}
