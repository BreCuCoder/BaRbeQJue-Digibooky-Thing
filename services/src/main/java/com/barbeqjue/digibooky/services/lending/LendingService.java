package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.lending.LendingRepository;
import com.barbeqjue.digibooky.services.book.BookService;
import com.barbeqjue.digibooky.services.member.MemberService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendingService {
    private LendingRepository lendingRepository;
    private MemberService memberService;
    private BookService bookService;
    private static Integer indexLending = 0;

    @Inject
    public LendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    public Book lendABook (Integer userId, String iSbn){
//        lendingRepository.storeLending()
    }

}
