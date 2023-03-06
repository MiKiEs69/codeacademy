package com.codeacademy.JDBC.demo2;

import com.codeacademy.JDBC.demo2.Books.Book;
import com.codeacademy.JDBC.demo2.Books.BooksService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    BooksService booksService;



    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//		studentsRepository2.getAllStudents().forEach(System.out::println);
//        productsDemo();
        booksDemo();

    }

    private void booksDemo() {
        logger.info("Create book: {}" + booksService.addBook(new Book("Sky at the railroad", "Rawling", "1-56619-909-3")));
        Book snow = new Book("The snow", "Carriage", "9971-5-0210-0");
        logger.info("Create snow: {}" + booksService.addBook(snow));
        logger.info("Create Killing Ieve: {}" + booksService.addBook(new Book("Killing Ieva", "Climbern", "1-56619-909-3")));
        logger.info("Create Roadmap: {}" + booksService.addBook(new Book("The roadmap", "Susan Boil", "9971-5-0210-0")));
        logger.info("Create Climbed: {}" + booksService.addBook(new Book("Climbed Guy", "Creatures", "9971-5-0210-0")));
        logger.info("Create The sun of autumn: {}" + booksService.addBook(new Book("The Sun of autumn", "Darius Malten", "9971-5-0210-0")));


        logger.info("All left products: {}" + booksService.getAllBooks());
//        logger.info("find by title: {}" + booksService.getByTitle("Sky at the railroad"));
    }


}
