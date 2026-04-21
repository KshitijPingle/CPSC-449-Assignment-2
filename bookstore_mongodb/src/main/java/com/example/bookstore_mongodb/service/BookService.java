package com.example.bookstore_mongodb.service;

import com.example.bookstore_mongodb.entity.Book;
import com.example.bookstore_mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // create a book
    public Book createBook(Book book) {
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    // get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // delete a book by id
    public ResponseEntity<String> deleteBookById(String id) {
        // Check if book exists
        if (!bookRepository.existsById(id)) {
            // Return a 404 error
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);

        // Return a 200 OK
        return ResponseEntity.ok("Book deleted successfully!");
    }

}
