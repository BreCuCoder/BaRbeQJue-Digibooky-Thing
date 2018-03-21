package com.barbeqjue.digibooky.services.lending;

import com.barbeqjue.digibooky.domain.lending.Lending;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LendingServiceTest {

    @Test
    public void INSERTNAMEHERE() {

        //GIVEN
        Lending providedLending = Lending.LendingBuilder.lending()
                .withUuid(3543)
                .withDueDate(LocalDate.now().plusWeeks(3))
                .withMember(null)
                .withBook(null)
                .build();
        Lending expectecLending = Lending.LendingBuilder.lending()
                .withUuid(3543)
                .withDueDate(LocalDate.now().plusWeeks(3))
                .withMember(null)
                .withBook(null)
                .build();

    }
}