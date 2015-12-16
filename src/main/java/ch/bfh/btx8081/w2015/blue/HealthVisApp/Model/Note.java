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
	 * The getter for the comment
	 * @return comment the Comment /String
	 */
	
	public String getComment() {
		return comment;
	}
	

	 /**
	  * The string representation is "comment"
	  * @return the string representation of the comment /String
	  */
	@Override
	public String toString() {
		return comment;
	}
}
