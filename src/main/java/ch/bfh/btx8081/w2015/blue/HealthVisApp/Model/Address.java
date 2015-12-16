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
public class Address {
	
	//================================================================================
    // Address Data
    //================================================================================

	private String aStreet;
	private int aStreetNr;
	private int aZIP;
	private String aCity;
	
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
	 * Setter for the ZIP
	 * @param zip The ZIP of the city /integer
	 */
	public void setZIP(int zip) {
		aZIP = zip;
	}
	
	/**
	 * The setter for the city
	 * @param city The name of the city /string
	 */
	public void setCity(String city) {
		aCity = city;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================

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
	 * The getter of the ZIP
	 * @return PLZ: integer
	 */
	public int getZIP() {
		return aZIP;
	}
	
	/**
	 * The getter of the city
	 * @return City: string
	 */
	public String getCity() {
		return aCity;
	}
	

	/**
	 * The string representation is "aStreet aStreetNr aZIP aCity"
	 * @return the string representation of the person /String
	 */
	@Override
	public String toString() {
		String aString = "";
		
		if (!aStreet.equals(null))
			{aString = aString + ", " + aStreet;}
		
		if (!(aStreetNr==0))
		{aString = aString + ", " + aStreetNr;}
		
		if (!(aZIP==0))
		{aString = aString + " ," + aZIP;}
		
		if (!aCity.equals(null))
		{aString = aString + ", " + aCity;}
		
		return aString;
	}
}
