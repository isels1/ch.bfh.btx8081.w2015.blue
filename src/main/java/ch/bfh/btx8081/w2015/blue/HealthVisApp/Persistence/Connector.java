package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		Connetcor
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...singleton class to handle the entity manager.
 * </span>
 * <br>
 * <br>
 * The Connector contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				PERSISTENCE_UNIT_NAME:
 * 			</font> 
 * 			<i>String</i>
 * 			- The persistence unit name healthVisAppDB
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				em:
 * 			</font> 
 * 			<i>EntityManager</i>
 * 			- The entity manager
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				c:
 * 			</font> 
 * 			<i>Connector</i>
 * 			- The singleton connector
 * 		</li>
 *	 </ul>
 * <br>
 * <span style="margin-left:60px;">
 * 		20.01.2016
 * </span>
 * <br><br>
 * @author isels1
 * @version 1.0
 */
public class Connector {

	//================================================================================
    // Connector Data
    //================================================================================

	private static final String PERSISTENCE_UNIT_NAME = "healthVisAppDB";
	private EntityManager em;
			
	private static Connector c = null;
	
	//================================================================================
    // Construction Section
    //================================================================================
	
	/**
	 * The private constructor for the connector
	 */
	private Connector(){
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * The public static get Connection function
	 * to retrieve the connector object
	 * @return Connector, to handle the entity manager
	 */
	public static Connector getConnection(){
		if (c == null) {
			c = new Connector();
		}
		return c;
	}
	
	/**
	 * The function to retrieve the entity manager
	 * @return em, the entity manager
	 */
	public EntityManager getEM(){
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		return em;
	}
	
	/**
	 * The function to close the entity manager
	 */
	public void close(){
		em.close();
	}
}
