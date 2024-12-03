import java.time.LocalDate;

import model.Employee;
import model.Manager;
import model.Staff;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 12, 2024
 */
public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating Staff Linked List and Manager Stack for employees to be added, laid off, and rehired
        Staff staff = new Staff();
        Manager layoffManager = new Manager();

        // Adding employees to the staff class to create a Linked List
        staff.addEmployee(new Employee("John", LocalDate.of(2020, 1, 15), 1, "Employed"));
        staff.addEmployee(new Employee("Claire", LocalDate.of(2021, 3, 10), 2, "Employed"));
        staff.addEmployee(new Employee("Franklin", LocalDate.of(2019, 6, 20), 3, "Employed"));

        System.out.println("Before Sorting:");
        System.out.println(staff);

        // Sorting employees by the date they were hired
        staff.employeesByHire();
        System.out.println("After Sorting:");
        System.out.println(staff);

        // Laying off employees from the stack which will remove the last employee as a Stack is first in and last out data structure
        layoffManager.layOff(staff.getEmployees().removeLast());
        layoffManager.layOff(staff.getEmployees().removeLast());

        System.out.println("After Layoffs:");
        System.out.println(staff);

        System.out.println("Laid Off Employees:");
        for (Employee e : layoffManager.getLayoffs()) {
            System.out.println(e);
        }

        // Rehiring an employee to the the list of employees
        Employee reinstated = layoffManager.rehire();
        if (reinstated != null) {
            staff.addEmployee(reinstated);
        }

        System.out.println("After Reinstatement:");
        System.out.println(staff);
    }
}