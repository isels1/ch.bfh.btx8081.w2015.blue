package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

public class AppointmentTest {

	@Test
	public void InitialiseAppointmentTest() {
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end = new GregorianCalendar();
		String loc = "location";
		Patient pat = new Patient(null, null, null, null, null);
		
		Appointment app = new Appointment(start, end, loc, pat);
		assertEquals(start, app.getStartTime());
		assertEquals(end, app.getEndTime());
		
	}

}
