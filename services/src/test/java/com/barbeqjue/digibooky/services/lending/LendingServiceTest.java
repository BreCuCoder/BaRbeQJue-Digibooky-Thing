package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookTestBuilder;
import com.barbeqjue.digibooky.domain.lending.Lending;
import com.barbeqjue.digibooky.domain.lending.LendingRepository;
import com.barbeqjue.digibooky.services.actor.member.MemberService;
import com.barbeqjue.digibooky.services.book.BookService;
import com.sun.javafx.collections.UnmodifiableObservableMap;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Test
    public void getLentBooksByMember_happyPath() {
        Book expextedBook1 = BookTestBuilder.aBook().withTitle("ta").build();
        Book expextedBook2 = BookTestBuilder.aBook().withTitle("ti").build();
        Book expextedBook3 = BookTestBuilder.aBook().withTitle("visual").build();

        Member expectedMember1 = Member.MemberBuilder.member().build();
        Member expectedMember2 = Member.MemberBuilder.member().build();
        Lending expectedLending1 = Lending.LendingBuilder.lending().withBook(expextedBook1).withMember(expectedMember1).build();
        Lending expectedLending2 = Lending.LendingBuilder.lending().withBook(expextedBook2).withMember(expectedMember2).build();
        Lending expectedLending3 = Lending.LendingBuilder.lending().withBook(expextedBook3).withMember(expectedMember1).build();

        Map<Integer, Lending> expectedLendings = new HashMap<>();
        expectedLendings.put(1, expectedLending1);
        expectedLendings.put(2, expectedLending2);
        expectedLendings.put(3, expectedLending3);

        Mockito.when(lendingRepositoryMock.getLendings()).thenReturn(expectedLendings);

        List<Book> actualResult = lendingService.getLentBooksByMember(expectedMember1);
        Assertions.assertThat(actualResult).containsExactly(expextedBook1, expextedBook3);
    }

    @Test
    public void getAllOverdueBooks() {
        Book expextedBook1 = BookTestBuilder.aBook().withTitle("ta").build();
        Book expextedBook2 = BookTestBuilder.aBook().withTitle("ti").build();
        Book expextedBook3 = BookTestBuilder.aBook().withTitle("visual").build();

        Lending expectedLending1 = Lending.LendingBuilder.lending()
                .withBook(expextedBook1).withDueDate(LocalDate.now().minusDays(1)).build();
        Lending expectedLending2 = Lending.LendingBuilder.lending()
                .withBook(expextedBook2).withDueDate(LocalDate.now().plusWeeks(4)).build();
        Lending expectedLending3 = Lending.LendingBuilder.lending()
                .withBook(expextedBook3).withDueDate(LocalDate.now().minusWeeks(1)).build();

        Map<Integer, Lending> expectedLendings = new HashMap<>();
        expectedLendings.put(1, expectedLending1);
        expectedLendings.put(2, expectedLending2);
        expectedLendings.put(3, expectedLending3);

        Mockito.when(lendingRepositoryMock.getLendings()).thenReturn(expectedLendings);

        List<Book> actualResult = lendingService.getAllOverdueBooks();
        Assertions.assertThat(actualResult).containsExactly(expextedBook1, expextedBook3);


    }
}