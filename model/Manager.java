package model;
import java.util.Stack;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 28, 2024
 */
public class Manager {
	private Stack<Employee> allLayoffs;
	
	public Manager() {
		allLayoffs = new Stack<>();
	}
	
	public void layOff(Employee employee) {
		employee.setCurrentStatus("Laid Off");
		allLayoffs.push(employee);
	}
	
	public Employee rehire() {
		if(!allLayoffs.isEmpty()) {
			Employee rehiredEmployee = allLayoffs.pop();
			rehiredEmployee.setCurrentStatus("Employed");
			return rehiredEmployee;
		}
		return null;
	}
	
	public Stack<Employee> getLayoffs(){
		return allLayoffs;
	}
}
