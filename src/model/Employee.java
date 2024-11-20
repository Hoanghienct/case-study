package model;
import java.io.Serializable;
public class Employee implements Serializable{
        private static final long serialVersionUID = 1L;

        private String id;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(String id, String name, String position, double salary) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        // toString for display
        @Override
        public String toString() {
            return String.format("Employee [ID: %s, Name: %s, Position: %s, Salary: %.2f]", id, name, position, salary);
        }
    }


