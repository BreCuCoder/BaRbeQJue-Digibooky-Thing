package com.barbeqjue.digibooky.api.book;

import com.barbeqjue.digibooky.services.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;

    @Inject
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBook(@RequestParam(required = false) Map<String, String> queryParameters) {
        return bookService.getAllBooks(queryParameters).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }


    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable("id") Integer id) {
        return bookMapper
                .toDto(bookService.getBookById(id));
    }


    @GetMapping(path = "/enhancedBook/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookWithDetails(@PathVariable("id") Integer id) {
        return bookMapper
                .toDtoWithDetails(bookService.getBookById(id));
    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto book) {
        return bookMapper
                .toDto(bookService
                        .createBook(bookMapper.toDomain(book)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable Integer id, @RequestBody BookDto book) {
        return bookMapper
                .toDto(bookService
                        .updateBook(id, bookMapper.toDomain(book)));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}