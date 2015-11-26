package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;
import java.util.Date;




public class Person {
	
    private String name;
    private String firstName;
    private Date birthdate;
    private Address address; 
    private String phone;

    public Person(String name, String firstName, Date birthdate, Address address, String phone){
        this.name = name;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.phone = phone;
   
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
