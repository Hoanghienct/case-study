package controller;
import model.Book;
import model.Employee;
import service.EmployeeFileService;
import view.EmployeeView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController {

        private List<Employee> employees;
        private EmployeeView view;
        private EmployeeFileService fileService;

        // Constructor
        public EmployeeController(EmployeeView view) {
            this.fileService = new EmployeeFileService();
            this.employees = fileService.loadEmployeesFromFile(); // Load data on startup
            this.view = view;
        }

        // Add an employee
        public void addEmployee(Employee employee) {
            employees.add(employee);
            fileService.saveEmployeesToFile(employees); // Save to file
            view.showMessage("Employee added successfully!");
        }

        // Remove an employee by ID
        public void removeEmployee(String id) {
            Employee employeeToRemove = null;
            for (Employee employee : employees) {
                if (employee.getId().equals(id)) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
                employees.remove(employeeToRemove);
                fileService.saveEmployeesToFile(employees); // Save to file
                view.showMessage("Employee removed successfully!");
            } else {
                view.showMessage("Employee not found!");
            }
        }
    public void searchBooks(String keyword) {
        List<Employee> results = employees.stream()
                .filter(employee -> employee.getName().toLowerCase().contains(keyword.toLowerCase())
                        || employee.getId().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            view.showMessage("No books found with the keyword: " + keyword);
        } else {
            view.showAllEmployees(results);
        }
    }

        // Display all employees
        public void displayEmployees() {
            view.showAllEmployees(employees);
        }
    }

