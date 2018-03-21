package com.barbeqjue.digibooky.domain.book;

import javax.inject.Named;
import java.util.*;

@Named
public class BookRepository {
    private Map<Integer, Book> books;
    private static int bookIndex = 0;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public Book storeBook(Book book) {
        book.setId(bookIndex++);
        books.put(book.getId(), book);
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> allActiveBooks = new ArrayList<>();
        for(int id : books.keySet()) {
            if(books.get(id).getBookStatus().equals(BookStatus.ACTIVE)) {
                allActiveBooks.add(books.get(id));
            }
        }
        return Collections.unmodifiableList(allActiveBooks);
    }

    public Book getBookById(Integer id) {
        return books.get(id);
    }

    public Book updateBook(int id, Book updatedbook) {
        books.put(id, updatedbook);
        return updatedbook;
    }

    public void deleteBook(int id) {
        books.get(id).setBookStatus(BookStatus.DECOMMISSIONED);
//        books.remove(id);
    }

    public List<Book> getBookByIsbn(String isbnRegex) {
        List<Book> bookSearchResults = new ArrayList<>();
        for (int id : books.keySet()) {
            if (books.get(id).getIsbn().contains(isbnRegex)) {
                bookSearchResults.add(books.get(id));
            }
        }
        return Collections.unmodifiableList(bookSearchResults);
    }

    public List<Book> getBookByTitle(String titleRegex) {
        List<Book> bookSearchResults = new ArrayList<>();
        for (int id : books.keySet()) {
            if (books.get(id).getTitle().contains(titleRegex)) {
                bookSearchResults.add(books.get(id));
            }
        }
        return Collections.unmodifiableList(bookSearchResults);
    }

    public List<Book> getBookByAuthor(String authorFirstNameRegex, String authorLastNameRegex) {
        List<Book> bookSearchResults = new ArrayList<>();
        for (int id : books.keySet()) {
            if (books.get(id).getAuthor().getLastName().contains(authorLastNameRegex)) {
                bookSearchResults.add(books.get(id));
            }
        }
        return Collections.unmodifiableList(bookSearchResults);
    }

    public List<Book> getBookByAuthor(String authorLastNameRegex) {
        List<Book> bookSearchResults = new ArrayList<>();
        for (int id : books.keySet()) {
            if (books.get(id).getAuthor().getLastName().contains(authorLastNameRegex)) {
                bookSearchResults.add(books.get(id));
            }
        }
        return Collections.unmodifiableList(bookSearchResults);
    }
}
