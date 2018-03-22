package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.lending.Lending;
import com.barbeqjue.digibooky.domain.lending.LendingRepository;
import com.barbeqjue.digibooky.services.book.BookService;
import com.barbeqjue.digibooky.services.actor.member.MemberService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;

@Named
public class LendingService {
    private LendingRepository lendingRepository;
    private MemberService memberService;
    private BookService bookService;
    private static Integer indexLending = 0;

    @Inject
    public LendingService(LendingRepository lendingRepository, BookService bookService, MemberService memberService) {
        this.lendingRepository = lendingRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public Book lendABook(Integer userId, String isbn) {
        lendingRepository.storeLending(
                new Lending(indexLending,
                        LocalDate.now().plusWeeks(3),
                        memberService.getMember(userId),
                        bookService.getBookByIsbn(isbn)));
        return bookService.getBookByIsbn(isbn);
    }

}
