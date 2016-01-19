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
 * 				aZIP:
 * 			</font> 
 * 			<i>integer</i>
 * 			- The ZIP of the city
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				aCity:
 * 			</font> 
 * 			<i>String</i>
 * 			- The name of the city where the person lives in
 * 		</li>
 *	 </ul>
 * <br>
 * To create a new address you need necessary at least following informations:
 * 	<ul>
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
 * 		07.12.2015
 * </span>
 * <br><br>
 * @author isels1, zwahf1
 * @version 1.0
 */
@Entity
@Table(name="address")
public class Address {
	
	//================================================================================
    // Address Data
    //================================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String street;
	private int streetNr;
	private int zip;
	private String city;
	
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
	 * @param street The street name /string
	 * @param streetNr The house number /integer
	 * @param zip The ZIP of the city /integer
	 * @param city The city in which the person lives in /string
	 */
	public Address( 
			String street, 
			int streetNr, 
			int zip, 
			String city) {

		setStreet(street);
		setStreetNr(streetNr);
		setZIP(zip);
		setCity(city);
	}
	
	//================================================================================
    // Setter Section
    //================================================================================

	/**
	 * Setter for the street
	 * @param street The street /string
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Setter for the street number (house number)
	 * @param streetNr The street number (house number) /integer
	 */
	public void setStreetNr(int streetNr) {
		this.streetNr = streetNr;
	}
	
	/**
	 * Setter for the ZIP
	 * @param zip The ZIP of the city /integer
	 */
	public void setZIP(int zip) {
		this.zip = zip;
	}
	
	/**
	 * The setter for the city
	 * @param city The name of the city /string
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================

	/**
	 * The getter of the street
	 * @return Street: string
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * The getter of the street number (house number)
	 * @return StreetNr: integer
	 */
	public int getStreetNr() {
		return streetNr;
	}
	
	/**
	 * The getter of the ZIP
	 * @return PLZ: integer
	 */
	public int getZIP() {
		return zip;
	}
	
	/**
	 * The getter of the city
	 * @return City: string
	 */
	public String getCity() {
		return city;
	}
	

	/**
	 * The string representation is "aStreet aStreetNr aZIP aCity"
	 * @return the string representation of the person /String
	 */
	@Override
	public String toString() {
		String aString = "";
		
		if (!(street==null))
			{aString = aString + ", " + street;}
		
		if (!(streetNr==0))
		{aString = aString + ", " + streetNr;}
		
		if (!(zip==0))
		{aString = aString + ", " + zip;}
		
		if (!(city==null))
		{aString = aString + ", " + city;}
		
		return aString;
	}
	
	 /**
	  * Compares two Addresses and tests if they are the same
	  * @return if aStreet, aStreetNr, aZIP and aCity of the Address objects are the same /boolean
	  */
	@Override
	public boolean equals(Object obj){
		if (obj != null) {
			Address addr = (Address) obj;
			boolean str = this.street.equals(addr.street);
			boolean nr = this.streetNr == addr.streetNr;
			boolean zip = this.zip == addr.zip;
			boolean city = this.city.equals(addr.city);
			
			return (str && nr && zip && city);
		}
		return false;
		
	}
}
