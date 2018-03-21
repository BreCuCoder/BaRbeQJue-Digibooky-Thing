package com.barbeqjue.digibooky.services.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import com.barbeqjue.digibooky.domain.actor.moderator.ModeratorRepository;
import com.barbeqjue.digibooky.domain.actor.moderator.Status;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class ModeratorServiceTest {

    @Mock
    private ModeratorRepository moderatorRepository;

    @InjectMocks
    private ModeratorService moderatorService;

    @Test
    public void createLibrarian_HappyPath() {
        Moderator providedModerator = Moderator.ModeratorBuilder.moderator()
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withLastName("Rens")
                        .withEmail("quentinrens@hotmail.com")
                        .build())
                .build();

        Moderator expectedModerator = Moderator.ModeratorBuilder.moderator()
                .withId(UUID.randomUUID())
                .withHumanInfo(providedModerator.getHumanInfo())
                .withStatus(Status.LIBRARIAN)
                .build();

        Mockito.when(moderatorRepository.storeModerator(providedModerator)).thenReturn(expectedModerator);

        Moderator actualModerator = moderatorService.createLibrarian(providedModerator);

        Assertions.assertThat(actualModerator).isEqualToComparingFieldByField(expectedModerator);
    }

}
