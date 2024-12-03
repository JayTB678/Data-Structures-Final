package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Employee;
import model.Staff;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Dec 3, 2024
 */
class StaffClassTest {

	@Test
	void testAddEmployee() {
		Staff test = new Staff();
		Employee testEmp = new Employee("James", LocalDate.of(2021, 2, 7), 103, "Employed");
		
		test.addEmployee(testEmp);
		
		assertEquals(1, test.getEmployees().size());
		assertEquals(testEmp, test.getEmployees().get(0));
	}

	@Test
	void testEmployeesByHire() {
		Staff test = new Staff();
		Employee testEmp1 = new Employee("James", LocalDate.of(2021, 2, 7), 103, "Employed");
		Employee testEmp2 = new Employee("Charolette", LocalDate.of(2020, 8, 16), 94, "Employed");
		
		test.addEmployee(testEmp1);
		test.addEmployee(testEmp2);
		
		test.employeesByHire();
		
		assertEquals("Charolette", test.getEmployees().get(0).getName());
		assertEquals("James", test.getEmployees().get(1).getName());
	}

}
