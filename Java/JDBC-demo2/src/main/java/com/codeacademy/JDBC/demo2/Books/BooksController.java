package com.codeacademy.JDBC.demo2.Books;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping(value = "books")
public class BooksController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BooksService booksService;

    @GetMapping("")
    public String books(Model model) {
//        model.addAttribute("books", booksService.getAllBooks());
//        return "books/books";
        return page(1, model);
    }

    @GetMapping("/new")
    public String createNew(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        Book editableBook = booksService.getById(id);
        model.addAttribute("book", editableBook );
        logger.info("book: {}", editableBook);
        return "books/edit";
    }



    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", booksService.getById(id));
        return "books/delete";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        booksService.deleteById(id);
        return "redirect:/books/pages/1";
    }

    @PostMapping("")
    public String createNewBook(@Valid Book book, BindingResult errors, Model model) {
        if (errors.hasErrors())
            return "books/new";

        Book bookCreated = booksService.addBook(book);
//        model.addAttribute("book", bookCreated);
        return "redirect:/books/" + bookCreated.getId();

    }

    @PostMapping("/edit")
    public String saveEditedBook(@Valid Book book, BindingResult errors, Model model) {
        if (errors.hasErrors())
            return "books/edit";

        Book bookEdited = booksService.updateBook(book);
//        model.addAttribute("book", bookEdited);
        return "redirect:/books/" + bookEdited.getId();

    }

    @GetMapping("/{id}")
    public String bookById(@PathVariable Long id, Model model) {
        model.addAttribute("book", booksService.getById(id));
//        model.addAttribute("id", id);
        return "books/itemView";
    }


    @GetMapping("/title")
    public String bookByTitle(@RequestParam String title, Model model) {
        model.addAttribute("book", booksService.getByTitle(title));
        return "books/itemView";
    }

    @GetMapping("/pages/{currentPage}")
    public String page(@PathVariable int currentPage, Model model) {
        Page<Book> currentPageContent = booksService.page(currentPage);
        int totalPages = currentPageContent.getTotalPages();
        if (currentPage > totalPages) throw new BooksPageNotFoundException("Pages' index out of range!!!");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalElements", currentPageContent.getTotalElements());
        model.addAttribute("books", currentPageContent.getContent());
        return "books/books";
    }

    @ExceptionHandler({BooksPageNotFoundException.class})
    public final String handleBooksPageException(Exception ex, WebRequest request, Model model) {
        model.addAttribute("errors", ex.getMessage());
//        LocalDateTime ldt = LocalDateTime.now();
        model.addAttribute("time", getDateTimeNow());
        if (ex instanceof BooksPageNotFoundException) {
            return "error/page.html";
        } else {
            return "error";
        }
    }

    private Object getDateTimeNow() {
        LocalDateTime ldtNow = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return ldtNow.format(dtf);
    }
}
