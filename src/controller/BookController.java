package controller;
import model.Book;
import service.FileService;
import view.BookView;

import java.util.List;
import java.util.stream.Collectors;
public class BookController {
        private List<Book> books;
        private BookView view;
        private FileService fileService;

        // Constructor
        public BookController(BookView view) {
            this.fileService = new FileService();
            this.books = fileService.loadBooksFromFile(); // Load data on startup
            this.view = view;
        }

        // Add a book
        public void addBook(Book book) {
            books.add(book);
            fileService.saveBooksToFile(books); // Save to file
            view.showMessage("Book added successfully!");
        }

        // Remove a book by ID
        public void removeBook(String id) {
            Book bookToRemove = null;
            for (Book book : books) {
                if (book.getId().equals(id)) {
                    bookToRemove = book;
                    break;
                }
            }
            if (bookToRemove != null) {
                books.remove(bookToRemove);
                fileService.saveBooksToFile(books); // Save to file
                view.showMessage("Book removed successfully!");
            } else {
                view.showMessage("Book not found!");
            }
        }

        // Search books by title or author
        public void searchBooks(String keyword) {
            List<Book> results = books.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                            || book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());

            if (results.isEmpty()) {
                view.showMessage("No books found with the keyword: " + keyword);
            } else {
                view.showAllBooks(results);
            }
        }

        // Display all books
        public void displayBooks() {
            view.showAllBooks(books);
        }

        public void editBook(String id, String newTitle, String newAuthor, double newPrice) {
        Book bookToEdit = null;
        for (Book book : books) {
            if (book.getId().equals(id)) {
                bookToEdit = book;
                break;
            }
        }

        if (bookToEdit != null) {
            // Update book information
            bookToEdit.setTitle(newTitle);
            bookToEdit.setAuthor(newAuthor);
            bookToEdit.setPrice(newPrice);

            // Save changes to file
            fileService.saveBooksToFile(books);
            view.showMessage("Book updated successfully!");
        } else {
            view.showMessage("Book not found!");
        }
    }
   }



