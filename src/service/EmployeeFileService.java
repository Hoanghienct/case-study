package service;
import model.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeFileService {

        private static final String FILE_NAME = "src/data/employees.txt";

        // Save employees to file
        public void saveEmployeesToFile(List<Employee> employees) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(employees);
                System.out.println("Employees saved to file successfully!");
            } catch (IOException e) {
                System.err.println("Error saving employees to file: " + e.getMessage());
            }
        }

        // Load employees from file
        @SuppressWarnings("unchecked")
        public List<Employee> loadEmployeesFromFile() {
            List<Employee> employees = new ArrayList<>();
            File file = new File(FILE_NAME);

            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    employees = (List<Employee>) ois.readObject();
                    System.out.println("Employees loaded from file successfully!");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading employees from file: " + e.getMessage());
                }
            }

            return employees;
        }
    }


