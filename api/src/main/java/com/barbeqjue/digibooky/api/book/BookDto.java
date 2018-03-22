package com.barbeqjue.digibooky.api.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.BookStatus;

public class BookDto {

    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private BookStatus bookStatus;
    private boolean isLended;
    private String memberName;

    public boolean isLended() {
        return isLended;
    }

    public String getMemberName() {
        return memberName;
    }

    public static BookDto bookDto() {
        return new BookDto();
    }

    public BookDto withIsLended(boolean isLended){
        this.isLended = isLended;
        return this;
    }

    public BookDto withMemberName(String memberName){
        this.memberName = memberName;
        return this;
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

    public BookDto withBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
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

    public BookStatus getBookStatus() { return bookStatus; }


}