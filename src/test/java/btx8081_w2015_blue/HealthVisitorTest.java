package btx8081_w2015_blue;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

public class HealthVisitorTest {

	@Test
	public void InitializeHealthVisitorTest() {
		String usern = "Hans";
		String pw = "Peter";
		Date date = new Date();
		Address address = new Address("Strasse",1,1111,"Stadt");
		String phone = "123123123";
		
		HealthVisitor hv = new HealthVisitor(usern, pw);
		assertEquals(usern, hv.getName());
		assertEquals(pw, hv.getFirstName());
		assertEquals(date, hv.getBirthdate());
		assertEquals(address, hv.getAddress());
		assertEquals(phone, hv.getPhone());
	}

	
	@Test
	public void AddToHealthVisitorTest(){
		String username = "User";
		String pw = "PW";
		Calendar calendar = new Calendar();
		ArrayList<Patient> pList = new ArrayList<Patient>();
		Patient patient = new Patient();
		HealthVisitor hv = new HealthVisitor();
		
		hv.setUserName(username);
		assertEquals(username, hv.getUserName());
		
		hv.setPassword(pw);
		assertEquals(pw, hv.getPassword());
		
		hv.setCalendar(calendar);
		assertEquals(calendar, hv.getCalendar());
		
		hv.setAllPatients(pList);
		assertEquals(pList, hv.getPatient());
		
		hv.setPatient(patient);
		pList.add(patient);
		assertEquals(pList, hv.getPatient());
		
	}
}
