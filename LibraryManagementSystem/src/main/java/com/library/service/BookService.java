package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a new book
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    // Retrieve a book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    // List all books
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Update an existing book
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}
