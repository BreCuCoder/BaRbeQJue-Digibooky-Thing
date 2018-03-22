package com.barbeqjue.digibooky.api.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookStatus;
import org.junit.Before;
import org.junit.Test;

import static com.barbeqjue.digibooky.api.book.BookDto.bookDto;
import static com.barbeqjue.digibooky.domain.book.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;

public class BookMapperTest {

    private BookMapper bookMapper;

    @Before
    public void instantiateMapper() {
        bookMapper = new BookMapper();
    }

    @Test
    public void toDto_givenBook_thenMapAllFieldsToBookDto() {
        Book book = book()
                .withId(5)
                .withIsbn("987-654321-01")
                .withTitle("This is a title")
                .withAuthor(new Author("John", "Doe"))
                .build();

        BookDto bookDto = bookMapper.toDto(book);

        assertThat(bookDto)
                .isEqualToComparingFieldByField(book);
    }

    @Test
    public void toDomain_givenBookDto_thenMapAllFieldsToBook() {
        BookDto bookDto = bookDto()
                .withId(2)
                .withIsbn("123-456789-10")
                .withTitle("Spring for Dummies")
                .withAuthor(new Author("Jane", "Doe"))
                .withBookStatus(BookStatus.ACTIVE);

        Book book = bookMapper.toDomain(bookDto);

        assertThat(book)
                .isEqualToComparingFieldByField(bookDto);
    }

}