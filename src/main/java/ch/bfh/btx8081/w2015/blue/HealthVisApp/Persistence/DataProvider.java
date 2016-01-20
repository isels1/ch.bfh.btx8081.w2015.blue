package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;

public class DataProvider {
	
	//================================================================================
    // DataProvider Data
    //================================================================================
	
	private static DataProvider dp = null;
	
	private HealthVisitor hv;
	private Calendar c;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private DataProvider(){
		
	}
	
	public static DataProvider getInstance(){
		if(dp == null) {
			dp = new DataProvider();
		}
		return dp;
	}
	
	public void setHealthVisitor(HealthVisitor hv) {
		this.hv = hv;
	}
	
	public HealthVisitor getHealthVisitor() {
		return hv;
	}
	
	public void initCalendar() {
		c = new Calendar();
		c.setHealthVisitor(hv);
		hv.setCalendar(c);
	}
	
	public void fillCalendar() {
		ArrayList<Appointment> ap = new ArrayList<Appointment>(hv.getAppointment());
		c.setAppointments(ap);
	}
	
	public Calendar getCalendar(){
		return hv.getCalendar();
	}
	
	public ArrayList<PatientState> getPatientStates(){
		Connector c = Connector.getConnection();
		EntityManager em = c.getEM();
				
		PatientState stateNew = em.find(PatientState.class, 1); 
		PatientState stateAmbulant = em.find(PatientState.class, 2);
		PatientState stateStatonary = em.find(PatientState.class, 3);
		PatientState stateArchived = em.find(PatientState.class, 4);
		
		em.close();
		
		ArrayList<PatientState> psl = new ArrayList<PatientState>();
		psl.add(stateNew); 
		psl.add(stateAmbulant); 
		psl.add(stateStatonary);
		psl.add(stateArchived);
		
		return psl;
	}

	public HealthVisitor login(String un, String pw) {
		Connector c = Connector.getConnection();
		EntityManager em = c.getEM();
    	
    	EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
    	Query q = em.createQuery("select h from HealthVisitor h where h.username = :name and h.password = :pw");
	    q.setParameter("name", un);
	    q.setParameter("pw", pw);
	    
	    List<HealthVisitor> hvs = new Vector<HealthVisitor>();
	    hvs = q.getResultList();
	    HealthVisitor hv = null;
	    if (hvs.size() != 0) {
	    	hv = hvs.get(0);
	    }
	    
	    em.close();
	    
		return hv;
	}
	
}
