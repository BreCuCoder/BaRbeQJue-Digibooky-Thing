package com.barbeqjue.digibooky.domain.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.Book.BookBuilder;

public class BookTestBuilder {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private BookStatus bookStatus;

    private BookTestBuilder() {
        id = 0;
        isbn = "987-987564321";
        title = "The Holy Bible";
        author = new Author("John", "Doe");

    }

    public static BookTestBuilder aBook() {
        return new BookTestBuilder();
    }

    public Book build() {
        return BookBuilder.book()
                .withId(id)
                .withIsbn(isbn)
                .withTitle(title)
                .withAuthor(author)
                .build();
    }

    public BookTestBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public BookTestBuilder withoutId() {
        this.id = null;
        return this;
    }

    public BookTestBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookTestBuilder withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public BookTestBuilder withBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
        return this;
    }
}
