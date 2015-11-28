package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Address
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...creates an address. For example an address of a patient.
 * </span>
 * <br>
 * <br>
 * The Address contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				aGender:
 * 			</font>
 * 			<i>char</i>
 * 			- The gender of the person as m or w
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aName:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aSurname:
 * 			</font>
 * 			<i>String</i>
 * 			- The surname of the person
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aStreet:
 * 			</font> 
 * 			<i>String</i>
 * 			- The street name where the person lives
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aStreetNr:
 * 			</font> 
 * 			<i>integer</i>
 * 			- The house number
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aPlz:
 * 			</font> 
 * 			<i>integer</i>
 * 			- The plz of the city
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aCity:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the city where the person lives in
 * 		</li>
 *		<li>
 *			<font face="courier new">
 *				aCountry:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the country
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aTel:
 * 			</font> 
 * 			<i>String</i>
 * 			- The phone number
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aMobile:
 * 			</font> 
 * 			<i>String</i>
 * 			- The mobile phone number
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aFax:
 * 			</font> 
 * 			<i>String</i>
 * 			- The fax number
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new address you need necessary at least following informations:
 * 	<ul>
 * 		<li>aGender</li>
 * 		<li>aSurname</li>
 * 		<li>aStreet</li>
 * 		<li>aStreetNr</li>
 * 		<li>aPlz</li>
 *		 <li>aCity</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		30.09.2014
 * </span>
 * <br><br>
 * @author Stefan Iseli
 * @version 1.0
 */
public class Address {
	
	//================================================================================
    // Address Data
    //================================================================================

	private char aGender;
	private String aName;
	private String aSurname;
	private String aStreet;
	private int aStreetNr;
	private int aPlz;
	private String aCity;
	private String aCountry;
	private String aTel;
	private String aMobile;
	private String aFax;
	
	//================================================================================
    // Constructor
    //================================================================================

	/**
	 * Default constructor for create new addresses
	 * <br>
	 * This constructor should be used only when creating a new address from the gui
	 */
	public Address() {
		
	}
	
	/**
	 * This constructor initialize the address with the necessary information
	 * <br>
	 * <br>
	 * @param gender The gender of the person /char
	 * @param surname The surname of the person /string
	 * @param street The street name /string
	 * @param streetNr The house number /integer
	 * @param plz The plz of the city /integer
	 * @param city The city in which the person lives in /string
	 */
	public Address(char gender, 
			String surname, 
			String street, 
			int streetNr, 
			int plz, 
			String city) {

		setGender(gender);
		setSurname(surname);
		setStreet(street);
		setStreetNr(streetNr);
		setPlz(plz);
		setCity(city);
	}
	
	/**
	 * This constructor initialize the address with additional information
	 * <br>
	 * <br>
	 * @param gender The gender of the person /char
	 * @param name The surname of the person /string
	 * @param surname The surname of the person /string
	 * @param street The street name /string
	 * @param streetNr The house number /integer
	 * @param plz The plz of the city /integer
	 * @param city The city in which the person lives in /string
	 * @param country The city in which the person lives in /string
	 */
	public Address(char gender, 
			String name,
			String surname, 
			String street, 
			int streetNr, 
			int plz, 
			String city,
			String country) {
		
		setGender(gender);
		setName(name);
		setSurname(surname);
		setStreet(street);
		setStreetNr(streetNr);
		setPlz(plz);
		setCity(city);
		setCountry(country);
	}
	
	/**
	 * This constructor initialize the address with full information
	 * <br>
	 * <br>
	 * @param gender The gender of the person /char
	 * @param name The surname of the person /string
	 * @param surname The surname of the person /string
	 * @param street The street name /string
	 * @param streetNr The house number /integer
	 * @param plz The plz of the city /integer
	 * @param city The city in which the person lives in /string
	 * @param country The city in which the person lives in /string
	 * @param tel The phone number /String
	 * @param mobile The mobile phone number /String
	 * @param fax The fax number /String
	 */
	public Address(char gender, 
			String name,
			String surname, 
			String street, 
			int streetNr, 
			int plz, 
			String city,
			String country,
			String tel,
			String mobile,
			String fax) {
		
		setGender(gender);
		setName(name);
		setSurname(surname);
		setStreet(street);
		setStreetNr(streetNr);
		setPlz(plz);
		setCity(city);
		setCountry(country);
		setTel(tel);
		setMobile(mobile);
		setFax(fax);
	}
	
	//================================================================================
    // Setter Section
    //================================================================================
	
	/**
	 * Setter for the gender
	 * @param gender The gender of a person (m = 0/w = 1) /char
	 */
	public void setGender(char gender) {
		aGender = gender;
	}
	
	/**
	 * Setter for the name
	 * @param name The name of a person /string
	 */
	public void setName(String name) {
		aName = name;
	}
	
	/**
	 * Setter for the surname
	 * @param surname The surname of a person /string
	 */
	public void setSurname(String surname) {
		aSurname = surname;
	}
	
	/**
	 * Setter for the street
	 * @param street The street /string
	 */
	public void setStreet(String street) {
		aStreet = street;
	}
	
	/**
	 * Setter for the street number (house number)
	 * @param streetNr The street number (house number) /integer
	 */
	public void setStreetNr(int streetNr) {
		aStreetNr = streetNr;
	}
	
	/**
	 * Setter for the plz
	 * @param plz The plz of the city /integer
	 */
	public void setPlz(int plz) {
		aPlz = plz;
	}
	
	/**
	 * The setter for the city
	 * @param city The name of the city /string
	 */
	public void setCity(String city) {
		aCity = city;
	}
	
	/**
	 * The setter for the country
	 * @param country The name of the country /string
	 */
	public void setCountry(String country) {
		aCountry = country;
	}
	
	/**
	 * The setter for the phone number
	 * @param tel The phone number /String
	 */
	public void setTel(String tel) {
		aTel = tel;
	}
	
	/**
	 * The setter for the mobile phone number
	 * @param mobile The mobile phone number /String
	 */
	public void setMobile(String mobile) {
		aMobile = mobile;
	}
	
	/**
	 * The setter for the fax number
	 * @param fax The fax number /String
	 */
	public void setFax(String fax) {
		aFax = fax;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * The getter of the gender
	 * @return Gender (m = 0/w = 1): char
	 */
	public char getGender() {
		return aGender;
	}
	
	/**
	 * The getter of the name
	 * @return Name: string
	 */
	public String getName() {
		return aName;
	}
	
	/**
	 * The getter of the surname
	 * @return Surname: string
	 */
	public String getSurname() {
		return aSurname;
	}
	
	/**
	 * The getter of the street
	 * @return Street: string
	 */
	public String getStreet() {
		return aStreet;
	}
	
	/**
	 * The getter of the street number (house number)
	 * @return StreetNr: integer
	 */
	public int getStreetNr() {
		return aStreetNr;
	}
	
	/**
	 * The getter of the plz
	 * @return PLZ: integer
	 */
	public int getPlz() {
		return aPlz;
	}
	
	/**
	 * The getter of the city
	 * @return City: string
	 */
	public String getCity() {
		return aCity;
	}
	
	/**
	 * The getter of the country
	 * @return Country: string
	 */
	public String getCountry() {
		return aCountry;
	}
	
	/**
	 * The getter of the phone number
	 * @return Telephone: String
	 */
	public String getTel() {
		return aTel;
	}
	
	/**
	 * The getter of the mobile phone number
	 * @return Mobile: String
	 */
	public String getMobile() {
		return aMobile;
	}
	
	/**
	 * The getter of the fax number
	 * @return Fax: String
	 */
	public String getFax() {
		return aFax;
	}
}
