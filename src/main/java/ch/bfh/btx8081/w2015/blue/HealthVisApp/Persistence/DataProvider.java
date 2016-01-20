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

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		DataProvider
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...singleton class to handle the retrieve data requests (select from db).
 * </span>
 * <br>
 * <br>
 * The DataProvider contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				dp:
 * 			</font> 
 * 			<i>DataProvider</i>
 * 			- The singleton DataProvider
 * 		</li>
 *		<li>
 * 			<font face="courier new">
 * 				hv:
 * 			</font> 
 * 			<i>HealthVisitor</i>
 * 			- The logged in HealthVisitor
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				c:
 * 			</font> 
 * 			<i>Calendar</i>
 * 			- The Calendar of the logged in HealthVisitor
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
	
	/**
	 * The private constructor for the data provider
	 */
	private DataProvider(){
		
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * The public static get DataProvider function
	 * to retrieve the DataProvider object
	 * @return DataProvider, to handle the retrieve data requests
	 */
	public static DataProvider getInstance(){
		if(dp == null) {
			dp = new DataProvider();
		}
		return dp;
	}
	
	/**
	 * The function to get the calendar
	 * @return Calendar
	 */
	public Calendar getCalendar(){
		return hv.getCalendar();
	}
	
	/**
	 * The function to retrieve the four patient states
	 * @return ArrayList, to handle the PatientStates
	 */
	public ArrayList<PatientState> getPatientStates(){
		
		ArrayList<PatientState> psl = new ArrayList<PatientState>();

		try {
			Connector c = Connector.getConnection();
			
			EntityManager em = c.getEM();
			
			PatientState stateNew = em.find(PatientState.class, 1); 
			PatientState stateAmbulant = em.find(PatientState.class, 2);
			PatientState stateStatonary = em.find(PatientState.class, 3);
			PatientState stateArchived = em.find(PatientState.class, 4);
			
			psl.add(stateNew); 
			psl.add(stateAmbulant); 
			psl.add(stateStatonary);
			psl.add(stateArchived);
			
			em.close();
		} catch (Exception e){
			System.out.println("ERROR IN GET PATIENT STATE: " + e.getMessage());	
		}			

		return psl;
	}
	
	/**
	 * Getter to retrieve the logged in health visitor
	 * @return HealthVisitor, the logged in health visitor
	 */
	public HealthVisitor getHealthVisitor() {
		return hv;
	}
	
	//================================================================================
    // Setter Section
    //================================================================================
	
	/**
	 * Setter to set the logged in health visitor
	 * @param hv the logged in health visitor
	 */
	public void setHealthVisitor(HealthVisitor hv) {
		this.hv = hv;
	}
	
	/**
	 * Initializes the calendar with the logged in health visitor
	 */
	public void initCalendar() {
		c = new Calendar();
		c.setHealthVisitor(hv);
		hv.setCalendar(c);
	}
	
	/**
	 * Fills the calendar with the appointments of the logged in health visitor
	 */
	public void fillCalendar() {
		ArrayList<Appointment> ap = new ArrayList<Appointment>(hv.getAppointment());
		c.setAppointments(ap);
	}
	
	//================================================================================
    // Login Section
    //================================================================================
	
	/**
	 * The function for the login
	 * @param un user name to login with
	 * @param pw password of the user to login with
	 * @return HealthVisitor object if login success, else null
	 */
	public HealthVisitor login(String un, String pw) {
		HealthVisitor hv = null;
		    
		try {
			Connector c = Connector.getConnection();
			EntityManager em = c.getEM();
	    	
	    	EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
	    	Query q = em.createQuery("select h from HealthVisitor h where h.username = :name and h.password = :pw");
		    q.setParameter("name", un);
		    q.setParameter("pw", pw);
		    
		    List<HealthVisitor> hvs = new Vector<HealthVisitor>();
		    hvs = q.getResultList();
		   
		    if (hvs.size() != 0) {
		    	hv = hvs.get(0);
		    }
		    
		    em.close();
		} catch (Exception e){
			System.out.println("ERROR IN LOGIN: " + e.getMessage());
		}
	    
		return hv;
	}
	
}
