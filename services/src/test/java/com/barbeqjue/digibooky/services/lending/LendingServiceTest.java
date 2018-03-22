package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookTestBuilder;
import com.barbeqjue.digibooky.domain.lending.Lending;
import com.barbeqjue.digibooky.domain.lending.LendingRepository;
import com.barbeqjue.digibooky.services.actor.member.MemberService;
import com.barbeqjue.digibooky.services.book.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static com.barbeqjue.digibooky.domain.book.BookTestBuilder.aBook;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LendingServiceTest {

    @InjectMocks
    LendingService lendingService;

    @Mock
    LendingRepository lendingRepositoryMock;
    @Mock
    BookService bookServiceMock;
    @Mock
    MemberService memberServiceMock;

    @Test
    public void lendingABook() {
        int givenId = 15;
        String givenIsbn = "testIsbn";
        Book expectedBook = aBook().build();
        Mockito.when(bookServiceMock.getBookByIsbn(givenIsbn)).thenReturn(expectedBook);
        Mockito.when(memberServiceMock.getMember(givenId)).thenReturn(Mockito.any(Member.class));

        Book actualBook = lendingService.lendABook(givenId,givenIsbn);

        Mockito.verify(lendingRepositoryMock).storeLending(Mockito.any(Lending.class));
        Assertions.assertThat(actualBook).isEqualTo(expectedBook);

    }
}