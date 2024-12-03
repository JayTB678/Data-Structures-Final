package model;
import java.util.LinkedList;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 5, 2024
 */

/*
 * This class is the Staff class which allows the creation of a Linked List of employees that can be stored
 * sorted into who has been with the company the longest.
 */
public class Staff {
	private LinkedList<Employee> employees;
	//Creates the new Linked List for employees to be stored with their information
	public Staff() {
		employees = new LinkedList<>();
	}
	//This method adds an employee to the list
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	//This method allows the employees to be sorted by the date that they are hired which is a crucial method to the application
	public void employeesByHire() {
		employees.sort((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate()));
	}
	//This method returns all employees that are employed within the list
	public LinkedList<Employee> getEmployees(){
		return employees;
	}
	
	@Override
	public String toString() {
		StringBuilder allStaff = new StringBuilder("All Staff:\n");
		for (Employee employee: employees) {
			allStaff.append(employee).append("\n");
		}
		return allStaff.toString();
	}
}
