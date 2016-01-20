package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Person;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		DataPersister
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...singleton class to handle the persist data requests (writing to db).
 * </span>
 * <br>
 * <br>
 * The DataPersister contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				dp:
 * 			</font> 
 * 			<i>DataPersister</i>
 * 			- The singleton DataPersister
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
public class DataPersister {
	
	//================================================================================
    // DataProvider Data
    //================================================================================
	
	private static DataPersister dp = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * The private constructor for the data persister
	 */
	private DataPersister(){
		
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * The public static get DataPersister function
	 * to retrieve the DataPersister object
	 * @return DataPersister to handle the persist data requests
	 */
	public static DataPersister getInstance(){
		if(dp == null) {
			dp = new DataPersister();
		}
		return dp;
	}
	
	//================================================================================
    // Persistance Section
    //================================================================================
	
	/**
	 * Function to persist a newly added patient
	 * @param p Patient object to insert into db
	 */
	public void addNewPatient(Patient p) {
		Connector c = Connector.getConnection();
		
		EntityManager em = c.getEM();
		
		EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    
	    try {
		    em.persist(p);
		    em.flush();
		    transaction.commit();
	    } catch (Exception e){
	    	System.out.println("ERROR ON INSERT PATIENT: " + e.getMessage());
	    }
	    em.close();
	}
	
	/**
	 * Function to update a patient
	 * @param p Patient object to update
	 */
	public void updatePatient(Patient p) {
		Connector c = Connector.getConnection();
		
		EntityManager em = c.getEM();
		
		EntityTransaction transaction = em.getTransaction();
	    
	    Person person = em.find(Person.class, p.getId());
	    
	    transaction.begin();
	    person = p;
	    
	    try {
		    em.merge(person); 
		    em.flush();
		    transaction.commit();
	    } catch (Exception e){
	    	System.out.println("ERROR ON UPDATE PATIENT: " + e.getMessage());
	    }
	    em.close();
	}
	
	/**
	 * Function to persist a newly added appointment
	 * @param a Appointment object to insert into db
	 */
	public void addNewAppointment(Appointment a) {
		Connector c = Connector.getConnection();
		
		EntityManager em = c.getEM();
		
		EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    
	    try {
		    em.persist(a);
		    em.flush();
		    transaction.commit();
	    } catch (Exception e){
	    	System.out.println("ERROR ON INSERT APPOINTMENT: " + e.getMessage());
	    }
	    em.close();
	}
	
}
