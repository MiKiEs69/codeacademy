package com.codeacademy.JDBC.demo2.Books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;

//@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //@ExceptionHandler({BooksPageNotFoundException.class})
    public final String handleBooksPageException(Exception ex, WebRequest request, Model model) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        model.addAttribute("errors", errors);
        if (ex instanceof BooksPageNotFoundException) {
            return "error/page.html";
        } else {
            return "error";
        }
    }
}
