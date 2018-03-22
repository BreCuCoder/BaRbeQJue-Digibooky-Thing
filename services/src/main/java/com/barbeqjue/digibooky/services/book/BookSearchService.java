package com.barbeqjue.digibooky.services.book;


import com.barbeqjue.digibooky.domain.book.Book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Named
public class BookSearchService {


    public List<Book> searchForBooks(List<Book> allBooks, Map<String, String> searchParametersMap) {
        List<Book> searchResult = new ArrayList<>();
        for(Book book : allBooks) {
            if(searchParametersMap.containsKey("isbn")) {
                if(book.getIsbn().contains(searchParametersMap.get("isbn"))) {
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }

}
