package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Person
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates a Person. For example a patient.
 * </span>
 * <br>
 * <br>
 * The Person contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				name:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the Person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				comment:
 * 			</font> 
 * 			<i>firstName</i>
 * 			-  The first name of the Person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				birthdate:
 * 			</font> 
 * 			<i>Date</i>
 * 			- The birthdate of the Person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				address:
 * 			</font> 
 * 			<i>Address</i>
 * 			- The address of the Person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				phone:
 * 			</font> 
 * 			<i>String</i>
 * 			- The phone number of the Person
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new person you need necessary at least following informations:
 * 	<ul>
 * 		<li>name</li>
 * 		<li>firstName</li>
 * 		<li>birthdate</li>
 *		<li>address</li>
 *		<li>phone</li>
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
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERSON_TYPE")
@Table(name = "person")
public class Person {
	
	//================================================================================
    // Person Data
    //================================================================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @OneToOne
    private Address addressID; 
    
    private String name;
    private String firstName;
    private String phone;

    //================================================================================
    // Constructor Section
    //================================================================================
	/**
	 * This constructor is used for testing.
	 */
	
    public Person()
    {
    	
    }
    
	/**
	 * This constructor initialize the Person with the necessary information
	 * <br>
	 * <br>
	 * @param name the Name of the Person /String
	 * @param firstName the first Name of the Person /String
	 * @param address the Address of the Person /Address
	 * @param birthdate the Birthdate of the Person /Date
	 * @param phone the Phone Number of the Person /String
	 */
    public Person(String name, String firstName, Date birthdate, Address address, String phone){
        this.name = name;
        this.firstName = firstName;
        this.addressID = address;
        this.birthDate = birthdate;
        this.phone = phone;
   
    }
    

    //================================================================================
    // Setter Section
    //================================================================================
	/**
	 * The setter for the name
	 * @param name The Name (last Name) /String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * The setter for the firstName
	 * @param firstName The Name (first Name) /String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * The setter for the birthdate
	 * @param birtdate The birthdate /Date
	 */
	public void setBirthdate(Date birthdate) {
		this.birthDate = birthdate;
	}
	/**
	 * The setter for the address
	 * @param address The Address /Address
	 */
	public void setAddress(Address address) {
		this.addressID = address;
	}
	/**
	 * The setter for the phone
	 * @param phone The Phone Number /String
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
        
    //================================================================================
    // Getter Section
    //================================================================================
	/**
	 * The getter for the name
	 * @return The Name (last Name) /String
	 */
    public String getName() {
		return name;
	}
	/**
	 * The getter for the firstName
	 * @return firstName The Name (first Name) /String
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * The getter for the birthdate
	 * @return The birthdate /Date
	 */
	public Date getBirthdate() {
		return birthDate;
	}
	/**
	 * The getter for the address
	 * @return The Address /Address
	 */
	public Address getAddress() {
		return addressID;
	}
	/**
	 * The getter for the phone
	 * @return The Phone Number /String
	 */
	public String getPhone() {
		return phone;
	}
	

	/**
	 * The string representation is "name firstName birthdate aStreet aStreetNr aZIP aCity phone"
	 * @return the string representation of the person /String
	 */
	@Override
	public String toString() {
		String addr = addressID.toString();
		String aString = "";
		
		if (!(name==null))
		{aString = aString + ", " + name;}
		
		if (!(firstName==null))
		{aString = aString + ", " + firstName;}
		
		if (!(birthDate==null))
		{aString = aString + ", " + birthDate;}
		
		aString = aString + ", " + addr;
		
		if (!(phone==null))
		{aString = aString + ", " + phone;}
		
		return aString;
	}
	
	 /**
	  * Compares two Persons and tests if they are the same
	  * @return if the name, firstName, birthdate, address, phone of the Person objects are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if(obj != null) {
			Person pers = (Person) obj;
			boolean names = this.name.equals(pers.name);
			boolean firstNames = this.firstName.equals(pers.firstName);
			boolean birthdates = this.birthDate.equals(pers.birthDate);
			boolean address = this.addressID.equals(pers.addressID);
			boolean phones = this.phone.equals(pers.phone);
			
			return (names && firstNames && birthdates && address && phones);
		}
		return false;
	}

	public int getId() {
		return id;
	}
}
