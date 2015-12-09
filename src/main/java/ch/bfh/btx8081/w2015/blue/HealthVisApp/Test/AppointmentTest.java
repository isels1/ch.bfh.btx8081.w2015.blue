package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;

public class AppointmentTest {

	@Test
	public void InitialiseAppointmentTest() {
		Calendar cal = new Calendar(null, null);
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end = new GregorianCalendar();
		
		Appointment app = new Appointment(start, end, cal);
		assertEquals(start, app.getStartTime());
		assertEquals(end, app.getEndTime());
		
	}

}
