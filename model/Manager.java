package model;
import java.util.Stack;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 5, 2024
 */

/*
 * This class is the Manager class which is a stack which allows the employees hired in the Linked List Staff class to
 * be laid off and rehired, this class takes the employee with the most recent hire date and lays them off, but it can also
 * allow them to be rehired.
 */

public class Manager {
	private Stack<Employee> allLayoffs;
	// Creates the stack of all the employees who have been laid off
	public Manager() {
		allLayoffs = new Stack<>();
	}
	//This method lays an employee off
	public void layOff(Employee employee) {
		employee.setCurrentStatus("Laid Off");
		allLayoffs.push(employee);
	}
	//This method allows laid off employees to be rehired
	public Employee rehire() {
		if(!allLayoffs.isEmpty()) {
			Employee rehiredEmployee = allLayoffs.pop();
			rehiredEmployee.setCurrentStatus("Employed");
			return rehiredEmployee;
		}
		return null;
	}
	//This method returns all employees currently laid off
	public Stack<Employee> getLayoffs(){
		return allLayoffs;
	}
}
