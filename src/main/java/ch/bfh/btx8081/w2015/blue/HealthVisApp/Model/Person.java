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

    //================================================================================
    // Setter Section
    //================================================================================

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
        
    //================================================================================
    // Getter Section
    //================================================================================
	
    public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
}
