package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;


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
}
