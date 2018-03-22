package com.barbeqjue.digibooky.services.book;

import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookRepository;
import com.barbeqjue.digibooky.utitlities.exceptions.IllegalFieldFoundException;
import com.barbeqjue.digibooky.utitlities.exceptions.IllegalFieldFoundException.CrudAction;
import com.barbeqjue.digibooky.utitlities.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static com.barbeqjue.digibooky.utitlities.exceptions.IllegalFieldFoundException;
import static com.barbeqjue.digibooky.utitlities.exceptions.IllegalFieldFoundException;

@Named
public class BookService {

    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(Integer id) {
        assertBookIsPresent(bookRepository.getBookById(id));
        return bookRepository.getBookById(id);
    }

    public Book getBookByIsbn(String isbn) {
        assertBookIsPresent(bookRepository.getBookByIsbn(isbn));
        return bookRepository.getBookByIsbn(isbn);
    }

    public List<Book> getBooksByPartialIsbn(String isbn) {
        assertBooksArePresent(bookRepository.getBooksByPartialIsbn(isbn));
        return bookRepository.getBooksByPartialIsbn(isbn);
    }

    private void assertBooksArePresent(List<Book> queriedBooksById) {
        if (queriedBooksById.size() == 0) {
            throw new UnknownResourceException("ID", Book.class.getSimpleName());
        }
    }

    public Book createBook(Book book) {
        assertBookIdIsNotPresent(book, CREATE);
        return bookRepository.storeBook(book);
    }

    public Book updateBook(Integer id, Book updatedBook) {
        assertBookIdIsNotPresent(updatedBook, UPDATE);
        assertBookIsPresent(bookRepository.getBookById(id));
        updatedBook.setId(id);
        return updatedBook;
    }

    public void deleteBook(Integer id) {
        assertBookIsPresent(bookRepository.getBookById(id));
        bookRepository.deleteBook(id);
    }

    private void assertBookIsPresent(Book queriedBookById) {
        if (queriedBookById == null) {
            throw new UnknownResourceException("ID", Book.class.getSimpleName());
        }
    }

    private void assertBookIdIsNotPresent(Book providedBook, CrudAction action) {
        if (providedBook.getId() != null) {
            throw new IllegalFieldFoundException("ID", Book.class.getSimpleName(), action);
        }
    }
}
