package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateAmbulant;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateArchived;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateNew;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateStationary;

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
	
	public void setAppointment() {
//		c.newAppointment(startTime, endTime, location, patient);
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
		c = new Calendar();
		
		hv = new HealthVisitor("Meier", "Hans", new Date(), new Address(), "0910291212");
		hv.setAllPatients(createPatients());
		hv.setCalendar(c);
		
		
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
		a1.setPatient(hv.getPatient().get(0));
		
		al.add(a1);
		
		Appointment a2 = new Appointment();
		
		GregorianCalendar start2 = new GregorianCalendar();
		start2.add(java.util.Calendar.HOUR, 5);
		a2.setStartTime(start2);
		GregorianCalendar end2 = new GregorianCalendar();
		end2.add(java.util.Calendar.HOUR, 6);
		a2.setEndTime(end2);
		a2.setlocation("Hier2");
		a2.setPatient(hv.getPatient().get(1));
		
		al.add(a2);
		
		Appointment a3 = new Appointment();
		
		GregorianCalendar start3 = new GregorianCalendar();
		start3.add(java.util.Calendar.HOUR, 12);
		a3.setStartTime(start3);
		GregorianCalendar end3 = new GregorianCalendar();
		end3.add(java.util.Calendar.HOUR, 15);
		a3.setEndTime(end3);
		a3.setlocation("Hie3");
		a3.setPatient(hv.getPatient().get(2));
		
		al.add(a3);
		
		return al;
	}	
	
	private ArrayList<Patient> createPatients(){
		ArrayList<Patient> pl = new ArrayList<Patient>();
		
		Patient p1 = new Patient("Meier", 
								"Anna", 
								new Date(), 
								new Address("Str1", 1, 3001, "City1"), 
								"056782924", 
								1);
		p1.setPatientState(new PatientStateNew());
		pl.add(p1);
		
		Patient p2 = new Patient("Müller", 
								"Peter", 
								new Date(), 
								new Address("Str2", 2, 3002, "City2"), 
								"0567678552", 
								2);
		p2.setPatientState(new PatientStateAmbulant());
		pl.add(p2);
		
		Patient p3 = new Patient("Keller", 
								"Maria", 
								new Date(), 
								new Address("Str3", 3, 3003, "City3"), 
								"0567877892", 
								3);
		p3.setPatientState(new PatientStateStationary());
		pl.add(p3);
		
		Patient p4 = new Patient("Suter", 
								"Stefanie", 
								new Date(), 
								new Address("Str4", 7, 2500, "City3"), 
								"0567777898", 
								4);
						
		p4.setPatientState(new PatientStateArchived());
		pl.add(p4);
		
		Patient p5 = new Patient("Scheurer", 
								"Markus", 
								new Date(), 
								new Address("Str4", 6, 3050, "City3"), 
								"0562477898", 
								5);
		p5.setPatientState(new PatientStateNew());
		pl.add(p5);
		
		Patient p6 = new Patient("Meier", 
								"Hans-Peter", 
								new Date(), 
								new Address("Str4", 4, 3353, "City3"), 
								"0562477848", 
								6);
		p6.setPatientState(new PatientStateNew());
		pl.add(p6);
		
		
		
		return pl;
	}
}
