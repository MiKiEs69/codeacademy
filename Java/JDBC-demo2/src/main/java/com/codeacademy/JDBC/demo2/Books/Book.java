package com.codeacademy.JDBC.demo2.Books;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    @NotEmpty(message = "Book has to have title!")
    private String title;

    @Column
    @NonNull
    @NotEmpty(message = "Book has to have author!")
    private String author;

    @Column
    @NonNull
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$",
            message = "ISBN should be 10 or 13 digits")
    String isbn;




    @Override
    public String toString() {
        return String.format("id= %d, title= %s, author= %s, ISBN= %s;", id, title, author, isbn);
    }
}
