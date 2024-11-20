package model;
import java.io.Serializable;
public class Book implements Serializable {

        private static final long serialVersionUID = 1L;

        private String id;
        private String title;
        private String author;
        private double price;

        // Constructor, Getters, Setters, and toString remain unchanged
        // Constructor
        public Book(String id, String title, String author, double price) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        // toString for display
        @Override
        public String toString() {
            return String.format("Book [ID: %s, Title: %s, Author: %s, Price: %.2f]", id, title, author, price);
        }
    }



