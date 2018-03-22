package com.barbeqjue.digibooky.domain.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.BookStatus;

public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private BookStatus bookStatus;

    private Book() {
    }

    Book (String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.bookStatus = BookStatus.ACTIVE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn (String isbn) {
        this.isbn = isbn;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public static class BookBuilder {
        private Integer id;
        private String isbn;
        private String title;
        private Author author;
        private BookStatus bookStatus;

        private BookBuilder(){}

        public static BookBuilder book() {
            return new BookBuilder();
        }

        public Book build() {
            Book book = new Book();
            book.setId(id);
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            book.setBookStatus(BookStatus.ACTIVE);
            return book;
        }

        public BookBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder withAuthor(Author author) {
            this.author = author;
            return this;
        }

        public BookBuilder withBookStatus(BookStatus bookStatus) {
            this.bookStatus = bookStatus;
            return this;
        }


    }
}