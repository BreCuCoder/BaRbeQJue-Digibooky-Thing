package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.lending.Lending;
import com.barbeqjue.digibooky.domain.lending.LendingRepository;
import com.barbeqjue.digibooky.services.book.BookService;
import com.barbeqjue.digibooky.services.actor.member.MemberService;
import com.barbeqjue.digibooky.services.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
public class LendingService {
    private LendingRepository lendingRepository;
    private MemberService memberService;
    private BookService bookService;

    @Inject
    public LendingService(LendingRepository lendingRepository, BookService bookService, MemberService memberService) {
        this.lendingRepository = lendingRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public Lending lendABook(Integer userId, String isbn) {
        return lendingRepository.storeLending(Lending.LendingBuilder.lending()
                .withDueDate(LocalDate.now().plusWeeks(3))
                .withMember(memberService.getMember(userId))
                .withBook(bookService.getBookByIsbn(isbn))
                .build());
    }

    public void returnBook(Integer uuid) {
        assertLendingIsPresent(lendingRepository.getLending(uuid));
        if (lendingRepository.getLending(uuid).getDueDate().isBefore(LocalDate.now())) {
            System.out.println("You should have returned it earlier, damn you");
        }
        lendingRepository.deleteLending(uuid);

    }

    public List<Book> getLendingsByMember (Member member){
        Map<Member, List<Lending>> membersByLending = lendingRepository.getLendings().values().stream()
                .collect(Collectors.groupingBy(lending -> lending.getMember()));

        return membersByLending.get(member).stream().map(lending -> lending.getBook()).collect(Collectors.toList());

    }

    private void assertLendingIsPresent(Lending queriedLendingById) {
        if (queriedLendingById == null) {
            throw new UnknownResourceException("ID", Lending.class.getSimpleName());
        }
    }

}
