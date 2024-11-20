package view;
import model.Book;
import java.util.List;
public class BookView {
        public void showAllBooks(List<Book> books) {
            if (books.isEmpty()) {
                System.out.println("No books available.");
            } else {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        }

        public void showMessage(String message) {
            System.out.println(message);
        }

}
