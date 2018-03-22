package com.barbeqjue.digibooky.api.book;

import com.barbeqjue.digibooky.domain.book.Book;

import javax.inject.Named;

import static com.barbeqjue.digibooky.domain.book.Book.BookBuilder.book;

@Named
public class BookMapper {

    public BookDto toDto(Book book) {
        return BookDto.bookDto()
                .withId(book.getId())
                .withIsbn(book.getIsbn())
                .withTitle(book.getTitle())
                .withAuthor(book.getAuthor())
                .withBookStatus(book.getBookStatus());

    }

    public BookDto toDtoWithDetails (Book book){
        return BookDto.bookDto()
                .withId(book.getId())
                .withIsbn(book.getIsbn())
                .withTitle(book.getTitle())
                .withAuthor(book.getAuthor())
                .withBookStatus(book.getBookStatus())
                .withIsLended(book.isLended())
                .withMemberName(book.getMemberName());
    }

    public Book toDomain(BookDto bookDto) {
        return book()
                .withId(bookDto.getId())
                .withIsbn(bookDto.getIsbn())
                .withTitle(bookDto.getTitle())
                .withAuthor(bookDto.getAuthor())
                .withBookStatus(bookDto.getBookStatus())
                .build();
    }

}
