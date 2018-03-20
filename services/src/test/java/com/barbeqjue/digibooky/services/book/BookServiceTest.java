package com.barbeqjue.digibooky.services.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookRepository;
import com.barbeqjue.digibooky.services.exceptions.IllegalFieldFoundException;
import com.barbeqjue.digibooky.services.exceptions.UnknownResourceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.barbeqjue.digibooky.domain.book.BookTestBuilder.aBook;
import static com.barbeqjue.digibooky.services.exceptions.IllegalFieldFoundException.CrudAction.CREATE;
import static com.barbeqjue.digibooky.services.exceptions.IllegalFieldFoundException.CrudAction.UPDATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService services;

    @Test
    public void getAllBooks_given3Books_thenReturnListOf3Books() {
        ArrayList<Book> expectedBooks = newArrayList(aBook().build(),
                aBook().build(),
                aBook().build());
        when(repository.getAllBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = services.getAllBooks();

        assertThat(actualBooks)
                .containsExactly(expectedBooks.toArray(new Book[3]));
    }

    @Test
    public void getBook_givenExistingId_thenReturnBook() {
        Book expectedBook = aBook().withId(901).build();
        when(repository.getBookById(901))
                .thenReturn(expectedBook);

        Book actualBook = services.getBookById(901);

        assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @Test
    public void getBook_givenNonExistingId_thenThrowException() {
        when(repository.getBookById(5))
                .thenReturn(null);

        expectedException.expect(UnknownResourceException.class);
        expectedException.expectMessage(String.format("We could not find a %s for the provided ID", Book.class.getSimpleName()));

        services.getBookById(5);
    }

    @Test
    public void createBook_givenABookWithoutIdToCreate_thenCreateBook() {
        Book providedBook = aBook()
                .withoutId()
                .withIsbn("987-654321-10")
                .withTitle("Some Nice title")
                .build();
        Book expectedBook = aBook()
                .withId(1)
                .withIsbn(providedBook.getIsbn())
                .withTitle(providedBook.getTitle())
                .build();
        when(repository.storeBook(providedBook)).thenReturn(expectedBook);

        Book actualBook = services.createBook(providedBook);

        assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @Test
    public void createBook_givenABookWithIdToCreate_thenThrowException() {
        Book providedBook = aBook().withId(4).build();

        expectedException.expect(IllegalFieldFoundException.class);
        expectedException.expectMessage(String.format("No ID can be present on a %s object passed for %s", Book.class.getSimpleName(), CREATE.getLabel()));

        services.createBook(providedBook);
    }

    @Test
    public void updateBook_givenAnExistingIdAndABookWithoutIdToUpdate_thenUpdateTheBook() {
        Author author1 = new Author("John", "Doe");
        Book providedBook = aBook()
                .withoutId()
                .withIsbn("456-789456")
                .withTitle("Galaxy's Guide to the Hitchhiker")
                .withAuthor(author1)
                .build();
        Book expectedBook = aBook()
                .withId(65)
                .withIsbn("456-789456")
                .withTitle("Galaxy's Guide to the Hitchhiker")
                .withAuthor(author1)
                .build();
        when(repository.getBookById(65)).thenReturn(expectedBook);

        Book actualBook = services.updateBook(65, providedBook);

        assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @Test
    public void updateBook_givenANonExistingIdAndABookWithoutIdToUpdate_thenThrowException() {
        when(repository.getBookById(65)).thenReturn(null);

        expectedException.expect(UnknownResourceException.class);
        expectedException.expectMessage(String.format("We could not find a %s for the provided ID", Book.class.getSimpleName()));

        services.updateBook(65, aBook().withoutId().build());
    }

    @Test
    public void updateBook_givenAnExistingIdAndABookWithIdToUpdate_thenThrowException() {
        expectedException.expect(IllegalFieldFoundException.class);
        expectedException.expectMessage(String.format("No ID can be present on a %s object passed for %s", Book.class.getSimpleName(), UPDATE.getLabel()));

        services.updateBook(65, aBook().withId(25).build());
    }

    @Test
    public void deleteBook_givenAnExistingId_thenDeleteBook() {
        when(repository.getBookById(5)).thenReturn(aBook().build());

        services.deleteBook(5);

        verify(repository).deleteBook(5);
    }

    @Test
    public void deleteBook_givenANonExistingId_thenThrowException() {
        when(repository.getBookById(5)).thenReturn(null);

        expectedException.expect(UnknownResourceException.class);
        expectedException.expectMessage(String.format("We could not find a %s for the provided ID", Book.class.getSimpleName()));

        services.deleteBook(5);
    }

}