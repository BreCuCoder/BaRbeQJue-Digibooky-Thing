package com.barbeqjue.digibooky.api.lending;

import com.barbeqjue.digibooky.api.book.BookDto;
import com.barbeqjue.digibooky.api.book.BookMapper;
import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.services.lending.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;
    private LendingMapper lendingMapper;
    private BookMapper bookMapper;

    @Inject
    public LendingController(LendingService lendingService, LendingMapper lendingMapper, BookMapper bookMapper) {
        this.lendingService = lendingService;
        this.lendingMapper = lendingMapper;
        this.bookMapper = bookMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LendingDto lendABook(@RequestBody Integer userId, @RequestBody String isbn) {
        return lendingMapper.toDto(lendingService.lendABook(userId, isbn));
    }

    @DeleteMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@RequestBody Integer userId) {
        lendingService.returnBook(userId);
    }

    @GetMapping(path = "/booksByMember", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> lentBooksByMember(@RequestBody Member member) {
        return lendingService.getLentBooksByMember(member).stream().map(book -> bookMapper.toDto(book)).collect(Collectors.toList());
    }

    @GetMapping(path = "/overdueBooks", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllOverdueBooks() {
        return lendingService.getAllOverdueBooks().stream().map(book -> bookMapper.toDto(book)).collect(Collectors.toList());
    }

}
