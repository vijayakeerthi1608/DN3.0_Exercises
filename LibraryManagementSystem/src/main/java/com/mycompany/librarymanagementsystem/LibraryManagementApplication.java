package com.mycompany.librarymanagementsystem;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context from the Java configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the BookService bean
        BookService bookService = context.getBean(BookService.class);

        // Create and add some books
        Book book1 = new Book(1L, "Spring Boot in Action", "Craig Walls");
        Book book2 = new Book(2L, "Effective Java", "Joshua Bloch");

        bookService.addBook(book1);
        bookService.addBook(book2);

        // List all books
        System.out.println("All Books:");
        bookService.getAllBooks().forEach(System.out::println);

        // Retrieve a book by ID
        System.out.println("\nRetrieve Book with ID 1:");
        bookService.getBookById(1L).ifPresent(System.out::println);

        // Update a book
        Book updatedBook = new Book(1L, "Spring Boot in Action (Updated)", "Craig Walls");
        bookService.updateBook(updatedBook);

        System.out.println("\nUpdated Book with ID 1:");
        bookService.getBookById(1L).ifPresent(System.out::println);

        // Delete a book
        bookService.deleteBook(2L);

        System.out.println("\nAll Books after deleting book with ID 2:");
        bookService.getAllBooks().forEach(System.out::println);
    }
}
