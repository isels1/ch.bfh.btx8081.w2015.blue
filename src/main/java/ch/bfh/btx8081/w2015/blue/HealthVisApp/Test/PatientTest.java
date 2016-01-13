package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Note;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Treatment;

public class PatientTest {

	@Test
	public void InitialisePatientTest() {
		String name = "Hans";
		String fName = "Peter";
		Date date = new Date();
		Address address = new Address("Strasse",1,1111,"Stadt");
		String phone = "123123123";
		int id = 5;
		Note comm = new Note();
		Treatment treatm = new Treatment();
		Appointment appnt = new Appointment(new GregorianCalendar(), new GregorianCalendar(), "Bern", new Patient(name, fName, date, address, phone));
		HealthVisitor hv = new HealthVisitor("Muster", "Max", new Date(), new Address("Strasse",2,2222,"Stadt"), "0987654321");
	
		Patient pat = new Patient(name, fName, date, address, phone);
		assertEquals(name, pat.getName());
		assertEquals(fName, pat.getFirstName());
		assertEquals(date, pat.getBirthdate());
		assertEquals(address, pat.getAddress());
		assertEquals(phone, pat.getPhone());
		assertEquals(id, pat.getId());
		assertEquals(comm, pat.getComment());
		assertEquals(treatm, pat.getTreatment());
		assertEquals(appnt, pat.getAppointment());
		assertEquals(hv, pat.getHealthvisitor());
				
	}
	
	

}
