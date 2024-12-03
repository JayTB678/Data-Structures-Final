package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Employee;
import model.Manager;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Dec 3, 2024
 */
class ManagerClassTest {


	@Test
	void testLayOff() {
		Manager testManager = new Manager();
		Employee testEmp = new Employee("Dean", LocalDate.of(2021, 7, 2), 40, "Employed");
		
		testManager.layOff(testEmp);
		
		assertEquals(1, testManager.getLayoffs().size());
		assertEquals("Laid Off", testEmp.getCurrentStatus());
	}


	@Test
	void testRehire() {
		Manager testManager = new Manager();
		Employee testEmp = new Employee("Dean", LocalDate.of(2021, 7, 2), 40, "Employed");
		
		testManager.layOff(testEmp);
		Employee testRehire = testManager.rehire();
		
		assertNotNull(testRehire);
		assertEquals("Employed", testRehire.getCurrentStatus());
		assertTrue(testManager.getLayoffs().isEmpty());
	}


	@Test
	void testGetLayoffs() {
		Manager testManager = new Manager();
		Employee testEmp = new Employee("Dean", LocalDate.of(2021, 7, 2), 40, "Employed");
		
		testManager.layOff(testEmp);
		
		assertFalse(testManager.getLayoffs().isEmpty());
	}

}
