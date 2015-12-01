package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;

public class CalendarTest {

	@Test
	public void InitialiseCalendarTest() {
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		HealthVisitor hv = new HealthVisitor(null, null, null, null, null);
		
		Calendar cal = new Calendar(app, hv);
		assertEquals(app, cal.getAppointments());
		assertEquals(app, cal.getHealthVisitor());
	}

	
	
}
