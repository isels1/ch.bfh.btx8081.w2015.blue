package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

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
		assertEquals(hv, cal.getHealthVisitor());
	}

	
	@Test
	public void AppointmentAddingTest(){
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		HealthVisitor hv = new HealthVisitor(null, null, null, null, null);
		Calendar cal = new Calendar(app, hv);
		Appointment a = new Appointment();
		Appointment b = new Appointment();
		Appointment c = new Appointment();
//		Appointment d = new Appointment();
		ArrayList<Appointment> appList = new ArrayList<Appointment>();
		appList.add(b);
		appList.add(c);
		
		cal.setAppointments(appList);
		assertEquals(appList, cal.getAppointments());
		
		cal.setAppointment(a);
		appList.add(a);
		assertEquals(appList, cal.getAppointments());
	}
}
