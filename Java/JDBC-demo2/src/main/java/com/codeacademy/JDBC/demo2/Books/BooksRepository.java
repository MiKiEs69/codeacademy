package com.codeacademy.JDBC.demo2.Books;

import com.codeacademy.JDBC.demo2.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    Book findByAuthor(String author);

}
