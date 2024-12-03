package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Employee;
import model.Manager;
import model.Staff;

/**
 * Jared Brannen - jtbrannen
 * CIS152 13545
 * Nov 23, 2024
 */

/*
 * This is where the creation of the GUI is and everything below allows for the user to see what is displayed to them
 * It allows for them to type information in and add it to the display and also view that information.
 * It also allows for the user to click on certain buttons such as sort, add, lay off, and rehire an employee.
 * Data Validation is included in the GUI so if you try to type any information that isn't formatted correctly
 * it will display an error message in the box where the list of employees telling you it isn't allowed. 
 */

public class EmployeeManagementGUI {
	private Staff staff;
	private Manager manager;
	
	private JFrame frame;
	private JTextArea displayArea;
	private JTextField employeeName, employeeNumber, employeeHireDate;
	private JButton addEmployee, sortEmployees, layoffEmployee, rehireEmployee;
	
	public EmployeeManagementGUI() {
		staff = new Staff();
		manager = new Manager();
		listOfEmployees();
		initializeGUI();
	}
	//This allows for the pre-population of employees in case there were previous employees in the company
	private void listOfEmployees() {
		staff.addEmployee(new Employee("Sylvia Lenard", LocalDate.of(2015, 2, 7), 1, "Employed"));
		staff.addEmployee(new Employee("Joshua Smith", LocalDate.of(2015, 2, 16), 2, "Employed"));
		staff.addEmployee(new Employee("Robert Patton", LocalDate.of(2016, 5, 4), 3, "Employed"));
		staff.addEmployee(new Employee("Belinda Parks", LocalDate.of(2019, 8, 25), 4, "Employed"));
		staff.addEmployee(new Employee("Jared Brannen", LocalDate.of(2017, 12, 8), 5, "Employed"));
		staff.addEmployee(new Employee("Stevie Wonder", LocalDate.of(2018, 9, 19), 1, "Employed"));
	}
	//This method creates the parts for the GUI
	private void initializeGUI() {
		frame = new JFrame("Employee Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLayout(new BorderLayout());
		
		JPanel employeeInput = new JPanel(new GridLayout(4, 2, 10, 10));
		employeeInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10 ,10));
		employeeInput.add(new JLabel("Employee Name: "));
		employeeName = new JTextField();
		employeeInput.add(employeeName);
		employeeInput.add(new JLabel("Employee ID Number: "));
		employeeNumber = new JTextField();
		employeeInput.add(employeeNumber);
		employeeInput.add(new JLabel("Date of Hire (YYYY-MM-DD): "));
		employeeHireDate = new JTextField();
		employeeInput.add(employeeHireDate);
		
		addEmployee = new JButton("Add Employee");
		employeeInput.add(addEmployee);
		
		sortEmployees = new JButton("Sort Employees");
		employeeInput.add(sortEmployees);
		
		frame.add(employeeInput, BorderLayout.NORTH);
		
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		JPanel actionPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		layoffEmployee = new JButton("Layoff Employee");
		rehireEmployee = new JButton("Rehire Employee");
		actionPanel.add(layoffEmployee);
		actionPanel.add(rehireEmployee);
		
		frame.add(actionPanel, BorderLayout.SOUTH);
		
		addEmployee.addActionListener(new AddEmployeeListener());
		sortEmployees.addActionListener(new SortEmployeesListener());
		layoffEmployee.addActionListener(new LayoffEmployeeListener());
		rehireEmployee.addActionListener(new RehireEmployeeListener());
		
		frame.setVisible(true);
	}
	
	private void displayMessage(String message) {
		displayArea.setText(message);
	}
	//Below are buttons that allow for actions to happen when clicked such as sort, add, lay off, and rehire an employee
	private class AddEmployeeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String name = employeeName.getText().trim();
				int employeeNumberId = Integer.parseInt(employeeNumber.getText().trim());
				LocalDate hireDate = LocalDate.parse(employeeHireDate.getText().trim());
				Employee newEmployee = new Employee(name, hireDate, employeeNumberId, "Employed");
				staff.addEmployee(newEmployee);
				displayMessage("New Employee added:\n" + newEmployee);
			} catch (Exception ex) {
				displayMessage("Error! Double check employee information is correct.");
			}
		}
	}
	
	private class SortEmployeesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			staff.employeesByHire();
			displayMessage("Employees Sorted by Date of Hire:\n" + staff);
		}
	}
	
	private class LayoffEmployeeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!staff.getEmployees().isEmpty()) {
				Employee lastEmployee = staff.getEmployees().removeLast();
				manager.layOff(lastEmployee);
				displayMessage("Employee Laid off:\n" + lastEmployee);
			} else {
				displayMessage("No employee can be laid off at the moment.");
			}
		}
	}
	
	private class RehireEmployeeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Employee rehired = manager.rehire();
			if(rehired != null) {
				staff.addEmployee(rehired);
				displayMessage("Rehired:\n" + rehired);
			} else {
				displayMessage("No employees can be rehired at the moment.");
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(EmployeeManagementGUI::new);
	}
}
