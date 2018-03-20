package com.barbeqjue.digibooky.api;

import com.barbeqjue.digibooky.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/professors")
public class BookController {

    private BookService professorService;
    private BookMapper professorMapper;

    @Inject
    public BookController(BookService professorService, BookMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBook() {
        return professorService.getAllBooks().stream()
                .map(professorMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable("id") Integer id) {
        return professorMapper
                .toDto(professorService.getBookById(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto professor) {
        return professorMapper
                .toDto(professorService
                        .createBook(professorMapper.toDomain(professor)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable Integer id, @RequestBody BookDto professor) {
        return professorMapper
                .toDto(professorService
                        .updateBook(id, professorMapper.toDomain(professor)));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        professorService.deleteBook(id);
    }

}