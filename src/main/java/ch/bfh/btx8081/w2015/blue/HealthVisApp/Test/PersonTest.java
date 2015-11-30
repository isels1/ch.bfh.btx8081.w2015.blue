package ch.bfh.btx8081.w2015.blue.HealthVisApp.Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Address;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Person;

public class PersonTest {

	@Test
	public void InitialisePersonTest() {
		String name = "Hans";
		String fName = "Peter";
		Date date = new Date();
		Address address = new Address();
		String phone = "123123123";
		
		Person person = new Person(name, fName, date, address, phone);
		assertEquals(name, person.getName());
		assertEquals(fName, person.getFirstName());
		assertEquals(date, person.getBirthdate());
		assertEquals(address, person.getAddress());
		assertEquals(phone, person.getPhone());
		
	}

}
