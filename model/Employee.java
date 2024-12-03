package model;
import java.time.LocalDate;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 5, 2024
 */

/*
 * This class is the Employees class which allows for the creation of an employee object which will
 * then later be stored in the Staff linked list to be used to determine which employee should be laid off 
 */

public class Employee {
	private String name;
	private LocalDate hireDate;
	private int employeeNumber;
	private String currentStatus;
	
	public Employee(String name, LocalDate hireDate, int employeeNumber, String currentStatus) {
		this.name = name;
		this.hireDate = hireDate;
		this.employeeNumber = employeeNumber;
		this.currentStatus = currentStatus;
	}

	public String getName() {
		return name;
	}


	public LocalDate getHireDate() {
		return hireDate;
	}


	public int getEmployeeNumber() {
		return employeeNumber;
	}


	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return "Employee Info\n Name: " + name + "\n Date Hired: " + hireDate + "\n Employee Number: " + employeeNumber
				+ "\n Status of Employment: " + currentStatus;
	}
	
	
	
	
}
