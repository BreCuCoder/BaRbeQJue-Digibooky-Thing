package com.barbeqjue.digibooky.api;

import com.barbeqjue.digibooky.domain.Book;

import javax.inject.Named;

import static com.barbeqjue.digibooky.domain.Book.BookBuilder.book;

@Named
public class BookMapper {

    BookDto toDto(Book book) {
        return BookDto.bookDto()
                .withId(book.getId())
                .withIsbn(book.getIsbn())
                .withTitle(book.getTitle())
                .withAuthor(book.getAuthor());
    }

    Book toDomain(BookDto bookDto) {
        return book()
                .withId(bookDto.getId())
                .withIsbn(bookDto.getIsbn())
                .withTitle(bookDto.getTitle())
                .withAuthor(bookDto.getAuthor())
                .build();
    }

}
