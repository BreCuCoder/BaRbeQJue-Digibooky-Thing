package com.barbeqjue.digibooky.domain;

import java.util.*;

public class BookRepository {
    private Map<Integer, Book> books;
    private static int bookIndex = 0;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public Book getBookById(int id) {
        return books.get(id);
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
