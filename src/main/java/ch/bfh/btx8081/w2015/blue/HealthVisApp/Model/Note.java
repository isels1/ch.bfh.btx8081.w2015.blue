package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Note
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a note. 
 * </span>
 * <br>
 * <br>
 * The Note contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				comment:
 * 			</font> 
 * 			<i>String</i>
 * 			- The comment in the note
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new Note you need necessary at least following informations:
 * 	<ul>
 * 		<li>comment</li>
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
 * @author hugil1, nosec1
 * @version 0.0
 */	
@Entity
@Table(name="note")
public class Note {

	//================================================================================
    // Note Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String comment;
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
