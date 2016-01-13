package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Appointment;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

public class CalendarTest {

	@Test
	public void InitialiseCalendarTest() {
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		HealthVisitor hv = new HealthVisitor("Muster", "Max", new Date(), new Address("Strasse",2,2222,"Stadt"), "0987654321");
		
		Calendar cal = new Calendar(app, hv);
		assertEquals(app, cal.getAppointments());
		assertEquals(hv, cal.getHealthVisitor());
	}

	
	@Test
	public void AppointmentAddingTest(){
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		HealthVisitor hv = new HealthVisitor(null, null, null, null, null);
		Calendar cal = new Calendar(app, hv);
		Appointment a = new Appointment(new GregorianCalendar(), new GregorianCalendar(), "Bern", new Patient("Meister", "Ueli", new Date(), new Address("ds",1,2,"ds"), "0987654321"));
		Appointment b = new Appointment(new GregorianCalendar(), new GregorianCalendar(), "Biel", new Patient("Meister", "Ueli", new Date(), new Address("ds",1,2,"ds"), "0987654321"));
		Appointment c = new Appointment(new GregorianCalendar(), new GregorianCalendar(), "Basel", new Patient("Meister", "Ueli", new Date(), new Address("ds",1,2,"ds"), "0987654321"));
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
