package view;
import model.Employee;

import java.util.List;
public class EmployeeView {

        public void showAllEmployees(List<Employee> employees) {
            if (employees.isEmpty()) {
                System.out.println("No employees available.");
            } else {
                for (Employee employee : employees) {
                    System.out.println(employee);
                }
            }
        }

        public void showMessage(String message) {
            System.out.println(message);
        }
    }


