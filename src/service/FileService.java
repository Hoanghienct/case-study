package service;
import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileService {
        private static final String FILE_NAME = "src/data/books.txt";

        // Save books to file
        public void saveBooksToFile(List<Book> books) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(books);
                System.out.println("Books saved to file successfully!");
            } catch (IOException e) {
                System.err.println("Error saving books to file: " + e.getMessage());
            }
        }

        // Load books from file
        @SuppressWarnings("unchecked")
        public List<Book> loadBooksFromFile() {
            List<Book> books = new ArrayList<>();
            File file = new File(FILE_NAME);

            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    books = (List<Book>) ois.readObject();
                    System.out.println("Books loaded from file successfully!");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading books from file: " + e.getMessage());
                }
            }

            return books;
        }

    }
