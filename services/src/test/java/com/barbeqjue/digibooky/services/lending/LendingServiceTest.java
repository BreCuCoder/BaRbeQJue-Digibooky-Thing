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
        Member expectedMember = Member.MemberBuilder.member().build();

        Mockito.when(bookServiceMock.getBookByIsbn(givenIsbn)).thenReturn(expectedBook);
        Mockito.when(memberServiceMock.getMember(givenId)).thenReturn(expectedMember);

        Lending expectedLending = Lending.LendingBuilder.lending()
                .withMember(expectedMember)
                .withBook(expectedBook)
                .withDueDate(LocalDate.now().plusWeeks(3))
                .build();
        Mockito.when(lendingRepositoryMock.storeLending(Mockito.any())).thenReturn(expectedLending);

        Lending actualLending = lendingService.lendABook(givenId, givenIsbn);

        Assertions.assertThat(actualLending.getBook()).isEqualTo(expectedLending.getBook());

    }

    @Test
    public void returnBook_HappyPath() {
        int testUuid = 45;

        Mockito.when(lendingRepositoryMock.getLending(testUuid)).thenReturn(Lending.LendingBuilder.lending().withUuid(testUuid).withDueDate(LocalDate.now().minusDays(2)).build());

        lendingService.returnBook(testUuid);

        Mockito.verify(lendingRepositoryMock).deleteLending(testUuid);
    }
}