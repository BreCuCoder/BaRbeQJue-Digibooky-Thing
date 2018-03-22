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

    public Book getBookByIsbn(String isbn) {
        for (int id : books.keySet()) {
            if (books.get(id).getIsbn().equals(isbn)) {
                return books.get(id);
            }
        }
        return null;
    }

    public Book updateBook(int id, Book updatedbook) {
        books.put(id, updatedbook);
        return updatedbook;
    }

    public void deleteBook(int id) {
        books.get(id).setBookStatus(BookStatus.DECOMMISSIONED);
//        books.remove(id);
    }








}
