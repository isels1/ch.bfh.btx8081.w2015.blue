package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Person;

public class DataPersister {
	
	//================================================================================
    // DataProvider Data
    //================================================================================
	
	private static DataPersister dp = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private DataPersister(){
		
	}
	
	public static DataPersister getInstance(){
		if(dp == null) {
			dp = new DataPersister();
		}
		return dp;
	}
	
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
	
	public void updatePatient(Patient p) {
		Connector c = Connector.getConnection();
		
		EntityManager em = c.getEM();
		
		EntityTransaction transaction = em.getTransaction();
	    
	    Person person = em.find(Person.class, p.getId());
	    
	    transaction.begin();
	    person = p;
	    System.out.println("EEDIT");
	    
	    try {
		    em.merge(person); 
		    em.flush();
		    transaction.commit();
	    } catch (Exception e){
	    	System.out.println("ERROR ON UPDATE PATIENT: " + e.getMessage());
	    }
	    em.close();
	}
	
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
