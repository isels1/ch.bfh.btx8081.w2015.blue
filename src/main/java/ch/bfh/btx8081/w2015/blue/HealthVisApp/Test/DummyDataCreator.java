package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

public class DummyDataCreator {
	
	//================================================================================
    // DummyDataCreator Data
    //================================================================================
	
	private static DummyDataCreator ddc = null;
	
	private HealthVisitor hv; 
	private Calendar c;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private DummyDataCreator(){
		initializeData();
	}
	
	public static DummyDataCreator getInstance(){
		if(ddc == null) {
			ddc = new DummyDataCreator();
		}
		return ddc;
	}
	
	//================================================================================
    // Setter Section
    //================================================================================
	
	public void setHealthVisitor(HealthVisitor hv){
		this.hv = hv;
	}
	
	public void setCalendar(Calendar c){
		this.c = c;
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	public HealthVisitor getHealthVisitor(){
		return hv;
	}
	
	public Calendar getCalendar(){
		return c;
	}
	
	//================================================================================
    // Private Section
    //================================================================================
	
	private void initializeData(){
		hv = new HealthVisitor("Meier", "Hans", new Date(), new Address(), "0910291212");
		hv.setAllPatients(createPatients());
		
		c = new Calendar();
		c.setHealthVisitor(hv);
		
		c.setAppointments(createAppointments());
	}
	
	private ArrayList<Appointment> createAppointments(){
		
		ArrayList<Appointment> al = new ArrayList<Appointment>();
		
		Appointment a1 = new Appointment();
		
		GregorianCalendar start1 = new GregorianCalendar();
		start1.add(java.util.Calendar.HOUR, 2);
		a1.setStartTime(start1);
		GregorianCalendar end1 = new GregorianCalendar();
		end1.add(java.util.Calendar.HOUR, 4);
		a1.setEndTime(end1);
		a1.setlocation("Hier");
		a1.setHealthvisitor(hv);
		
		al.add(a1);
		
		Appointment a2 = new Appointment();
		
		GregorianCalendar start2 = new GregorianCalendar();
		start2.add(java.util.Calendar.HOUR, 5);
		a2.setStartTime(start2);
		GregorianCalendar end2 = new GregorianCalendar();
		end2.add(java.util.Calendar.HOUR, 6);
		a2.setEndTime(end2);
		a2.setlocation("Hier2");
		a2.setHealthvisitor(hv);
		
		al.add(a2);
		
		Appointment a3 = new Appointment();
		
		GregorianCalendar start3 = new GregorianCalendar();
		start3.add(java.util.Calendar.HOUR, 12);
		a3.setStartTime(start3);
		GregorianCalendar end3 = new GregorianCalendar();
		end3.add(java.util.Calendar.HOUR, 15);
		a3.setEndTime(end3);
		a3.setlocation("Hie3");
		a3.setHealthvisitor(hv);
		
		al.add(a3);
		
		return al;
	}
	
	
	
	
	private ArrayList<Patient> createPatients(){
		ArrayList<Patient> pl = new ArrayList<Patient>();
		
//		Address add1 = new Address('f', "Anna", "Meier", "Str1", 1, 3001, "City1", "CH");
//		Date bd1 = new Date();
//		Patient p1 = new Patient("Meier", "Anna", bd1, add1, "05678294", 1);
//		pl.add(p1);
//		
//		Address add2 = new Address('m', "Peter", "Müller", "Str2", 2, 3002, "City2", "CH");
//		Date bd2 = new Date();
//		Patient p2 = new Patient("Müller", "Peter", bd2, add2, "056767855", 2);
//		pl.add(p2);
//		
//		Address add3 = new Address('f', "Maria", "Keller", "Str3", 3, 3003, "City3", "CH");
//		Date bd3 = new Date();
//		Patient p3 = new Patient("Keller", "Maria", bd3, add3, "056787789", 3);
//		pl.add(p3);
		
		
		
		return pl;
	}
}
