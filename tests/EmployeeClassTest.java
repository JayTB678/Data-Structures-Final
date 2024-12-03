package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Employee;

class EmployeeClassTest {
	
	Employee test = new Employee("Test Subject", LocalDate.of(2020, 3, 12), 102, "Employed");
	
	@Test
	void testEmployee() {
		
		assertEquals("Test Subject", test.getName());
		assertEquals(LocalDate.of(2020, 3, 12), test.getHireDate());
		assertEquals(102, test.getEmployeeNumber());
		assertEquals("Employed", test.getCurrentStatus());
	}

	@Test
	void testGetName() {
		assertEquals("Test Subject", test.getName());
	}

	@Test
	void testGetHireDate() {
		assertEquals(LocalDate.of(2020, 3, 12), test.getHireDate());
	}

	@Test
	void testGetEmployeeNumber() {
		assertEquals(102, test.getEmployeeNumber());
	}

	@Test
	void testGetCurrentStatus() {
		assertEquals("Employed", test.getCurrentStatus());
	}

	@Test
	void testSetCurrentStatus() {
		test.setCurrentStatus("Laid Off");
		assertEquals("Laid Off", test.getCurrentStatus());
	}

	@Test
	void testToString() {
		String expected = "Employee Info\n Name: " + test.getName() + "\n Date Hired: " + test.getHireDate() + "\n Employee Number: " + test.getEmployeeNumber()
				+ "\n Status of Employment: " + test.getCurrentStatus();
		assertEquals(expected, test.toString());
	}

}
