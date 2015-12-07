package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

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
		Address address = new Address();
		String phone = "123123123";
		int id = 5;
		Note comm = new Note();
		Treatment treatm = new Treatment();
		Appointment appnt = new Appointment();
		HealthVisitor hv = new HealthVisitor(" ", " ", null, null, " ");
	
		Patient pat = new Patient(name, fName, date, address, phone, id, comm, treatm, appnt, hv);
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
