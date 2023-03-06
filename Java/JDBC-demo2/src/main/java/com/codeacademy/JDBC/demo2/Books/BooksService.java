package com.codeacademy.JDBC.demo2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private BooksRepository repository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.repository = booksRepository;
    }

    public Book getById(Long id) {
        return repository.getById(id);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Book updateBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBook(long id) {
        return repository.findById(id).get();
    }

    public Book getByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Book getByAuthor (String author) {
        return repository.findByAuthor(author);
    }

    public void removeFromLibrary(Book book) {
        repository.delete(book);
    }

    public void removeAllFromLibrary() {
        repository.deleteAll();
    }

    public Page<Book> page(int currentPage) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, 3);
        return repository.findAll(pageRequest);
    }
}
