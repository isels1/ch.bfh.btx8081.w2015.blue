package btx8081_w2015_blue;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.Connector;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataPersister;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;

/**
 * Testing the DB Interaction
 * --> Login Success and Failure
 * --> Retrieve Patient State
 * --> Add Patient
 * 
 * @author isels1
 *
 */
public class DataBaseTest {

	@Test
	public void LoginSuccessTest() {		
		String username = "muelh";
		String password = "muelh";
		
		DataProvider dp = DataProvider.getInstance();
		
		HealthVisitor hv = dp.login(username, password);
		
		assertEquals(username, hv.getUserName());
		assertEquals(password, hv.getPassword());
	}
	
	@Test
	public void LoginFailedTest(){
		String username = "asd";
		String password = "efg";
		
		DataProvider dp = DataProvider.getInstance();
		
		HealthVisitor hv = dp.login(username, password);
		
		assertNull(hv);
	}
	
	@Test
	public void GetPatientStateTest(){
		DataProvider dp = DataProvider.getInstance();
		
		ArrayList<PatientState> psl = dp.getPatientStates();
		
		assertEquals(4, psl.size());
		
		PatientState stateNew = psl.get(0);
		PatientState stateAmbulant = psl.get(1);
		PatientState stateStationary = psl.get(2);
		PatientState stateArchived = psl.get(3);
		
		assertEquals(1, stateNew.getPatientStateId());
		assertEquals(2, stateAmbulant.getPatientStateId());
		assertEquals(3, stateStationary.getPatientStateId());
		assertEquals(4, stateArchived.getPatientStateId());
	}

	@Test
	public void InsertingTest(){
		String username = "muelh";
		String password = "muelh";
		
		DataProvider dp = DataProvider.getInstance();
		
		HealthVisitor hv = dp.login(username, password);
		ArrayList<PatientState> psl = dp.getPatientStates();
		Note n = new Note();
		n.setComment("JUnit Test Patient");
		
		Patient p = new Patient();
		p.setName("TestPatient");
		p.setFirstName("InsertingTest");
		p.setAddress(new Address("Teststrasse", 1, 1111, "Testerhausen"));
		p.setBirthdate(new Date(1993, 6, 12));
		p.setPhone("4111");
		p.setPatientState(psl.get(0));
		p.setComment(n);
		p.setHealthvisitor(hv);
		
		DataPersister dpers = DataPersister.getInstance();
		
		dpers.addNewPatient(p);
		
		//Patient Added To DB
		//Now Check if rlly inserted
		Connector c = Connector.getConnection();
		EntityManager em = c.getEM();
		EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    
	    Query q = em.createQuery("select p from Patient p");
	    
	    Patient actualPatient = null;
	    List<Patient> actualPatientList = new Vector<Patient>();
	    actualPatientList = q.getResultList();
	    
	    for(Patient pat : actualPatientList) {
	    	if(pat.getName().equals(p.getName())
	    		&& pat.getFirstName().equals(p.getFirstName()))
	    		{
	    			actualPatient = pat;
	    		}
	    }
	    
	    if (actualPatient == null) {
	    	fail("No Patient in DB");
	    }
		
	    assertEquals("TestPatient", actualPatient.getName());
	    assertEquals("InsertingTest", actualPatient.getFirstName());
	    assertEquals("4111", actualPatient.getPhone());
	    
	    //DELETE INSERTET PATIENT FROM DB
	    em.remove(actualPatient);
	    em.flush();
	    transaction.commit();
	    c.close();
	}
}
