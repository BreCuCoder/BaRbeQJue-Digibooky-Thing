package com.barbeqjue.digibooky.domain;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<Integer, Book> books;
    private static int bookIndex = 0;

    public BookRepository() {

        this.books = new HashMap<>();

    }

    public Book getBookByIsbn(int id){
    return null;
    }


}
