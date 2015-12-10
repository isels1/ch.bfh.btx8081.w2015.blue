package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

import java.util.Date;

public class Person {
	
	//================================================================================
    // Person Data
    //================================================================================
	
    private String name;
    private String firstName;
    private Date birthdate;
    private Address address; 
    private String phone;

    //================================================================================
    // Constructor Section
    //================================================================================
    
    public Person(String name, String firstName, Date birthdate, Address address, String phone){
        this.name = name;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.phone = phone;
   
    }
    
    public Person()
    {
    	
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
		this.birthdate = birthdate;
	}
	/**
	 * The setter for the address
	 * @param address The Address /Address
	 */
	public void setAddress(Address address) {
		this.address = address;
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
		return birthdate;
	}
	/**
	 * The getter for the address
	 * @return The Address /Address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * The getter for the phone
	 * @return The Phone Number /String
	 */
	public String getPhone() {
		return phone;
	}
}
