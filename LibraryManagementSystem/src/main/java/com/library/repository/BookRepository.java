package com.library.repository;

import com.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    // Add a book to the repository
    public void addBook(Book book) {
        books.add(book);
    }

    // Retrieve a book by ID
    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    // List all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Update a book in the repository
    public void updateBook(Book book) {
        getBookById(book.getId()).ifPresent(existingBook -> {
            books.remove(existingBook);
            books.add(book);
        });
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
