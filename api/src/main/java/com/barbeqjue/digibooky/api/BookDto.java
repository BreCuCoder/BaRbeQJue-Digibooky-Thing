package com.barbeqjue.digibooky.api;

import com.barbeqjue.digibooky.domain.Author;

public class BookDto {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;


    public static BookDto bookDto() {
        return new BookDto();
    }

    public BookDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public BookDto withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookDto withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookDto withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}