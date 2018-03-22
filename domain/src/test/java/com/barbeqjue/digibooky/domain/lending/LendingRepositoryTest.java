package com.barbeqjue.digibooky.domain.lending;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
public class LendingRepositoryTest {

    @Test
    public void storeLending_happyPath() {
        //GIVEN
        LendingRepository lendingRepository =new LendingRepository();
        Lending lendingMock = Mockito.mock(Lending.class);

        Lending actualResult = lendingRepository.storeLending(lendingMock);

        Assertions.assertThat(actualResult).isEqualTo(lendingMock);

    }


    @Test
    public void deleteLending_happyPath() {
        //GIVEN
        LendingRepository lendingRepository =new LendingRepository();
        Lending lendingMock = Mockito.mock(Lending.class);
        lendingMock.setUuid(45);

        lendingRepository.storeLending(lendingMock);
        lendingRepository.deleteLending(lendingMock.getuuid());


        Assertions.assertThat(lendingRepository.getLendings()).isEmpty();

    }
}