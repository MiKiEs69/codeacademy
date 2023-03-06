package com.codeacademy.JDBC.demo2.Books;

public class BooksPageNotFoundException extends RuntimeException{
    public BooksPageNotFoundException(String message) {
        super(message);
    }
}
