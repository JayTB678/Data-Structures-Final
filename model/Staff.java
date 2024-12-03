package model;
import java.util.LinkedList;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 28, 2024
 */
public class Staff {
	private LinkedList<Employee> employees;
	
	public Staff() {
		employees = new LinkedList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void employeesByHire() {
		employees.sort((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate()));
	}
	
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
