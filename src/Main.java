import java.util.Scanner;
import controller.BookController;
import controller.EmployeeController;
import model.Book;
import model.Employee;
import view.BookView;
import view.EmployeeView;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookView bookView = new BookView();
        EmployeeView employeeView = new EmployeeView();
        BookController bookController = new BookController(bookView);
        EmployeeController employeeController = new EmployeeController(employeeView);

        while (true) {
            try {
                System.out.println("\nManagement System");
                System.out.println("1. Quản Lý sách");
                System.out.println("2. Quản lý nhân viên");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manageBooks(bookController, scanner);
                        break;
                    case 2:
                        manageEmployees(employeeController, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Mời bạn nhập lại ");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static void manageBooks(BookController controller, Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nBook Management");
                System.out.println("1. Hiển thị sách");
                System.out.println("2. Thêm sách");
                System.out.println("3. Xóa");
                System.out.println("4. Sửa sách");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        controller.displayBooks();
                        break;
                    case 2:
                        System.out.print("Enter Book ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Book Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        Book book = new Book(id, title, author, price);
                        controller.addBook(book);
                        break;
                    case 3:
                        System.out.print("Enter Book ID to remove: ");
                        String bookId = scanner.nextLine();
                        controller.removeBook(bookId);
                        break;
                    case 4:
                        System.out.print("Enter Book ID to edit: ");
                        String editId = scanner.nextLine();
                        System.out.print("Enter new Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new Author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter new Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        controller.editBook(editId, newTitle, newAuthor, newPrice);
                        break;
                    case 5:
                        System.out.print("Enter keyword to search: ");
                        String keyword = scanner.nextLine();
                        controller.searchBooks(keyword);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Mời bạn nhập lại ");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static void manageEmployees(EmployeeController controller, Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nEmployee Management");
                System.out.println("1. Thêm nhân viên");
                System.out.println("2. Xóa nhân viên");
                System.out.println("3. Hiển thị");
                System.out.println("4. Tìm kếm");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Employee Position: ");
                        String position = scanner.nextLine();
                        System.out.print("Enter Employee Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();

                        Employee employee = new Employee(id, name, position, salary);
                        controller.addEmployee(employee);
                        break;
                    case 2:
                        System.out.print("Enter Employee ID to remove: ");
                        String empId = scanner.nextLine();
                        controller.removeEmployee(empId);
                        break;
                    case 3:
                        controller.displayEmployees();
                        break;
                    case 4:
                        System.out.print("Enter keyword to search: ");
                        String keyword = scanner.nextLine();
                        controller.searchBooks(keyword);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Mời bạn nhập lại ");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }
}