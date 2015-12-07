package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;

public class AppointmentTest {

	@Test
	public void InitialiseAppointmentTest() {
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end = new GregorianCalendar();
		HealthVisitor hv = new HealthVisitor(" ", " ", null, null, " ");
		
		Appointment app = new Appointment(start, end, hv);
		assertEquals(start, app.getStartTime());
		assertEquals(end, app.getEndTime());
		assertEquals(hv, app.getHealthvisitor());
		
	}

}
