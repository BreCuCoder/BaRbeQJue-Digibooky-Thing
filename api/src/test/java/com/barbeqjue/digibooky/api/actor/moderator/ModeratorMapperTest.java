package com.barbeqjue.digibooky.api.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import com.barbeqjue.digibooky.domain.actor.moderator.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ModeratorMapperTest {

    private ModeratorMapper moderatorMapper;

    @Before
    public void instantiateMapper() {
        moderatorMapper = new ModeratorMapper();
    }

    @Test
    public void toDto_givenModerator_thenMapAllFieldsToModeratorDto() {
        Moderator moderator = Moderator.ModeratorBuilder.moderator()
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withEmail("rensquentin@hotmail.com")
                        .withFirstName("Quentin")
                        .withLastName("Rens")
                        .build())
                .withId(UUID.randomUUID())
                .withStatus(Status.ADMIN)
                .build();

        ModeratorDto actualModeratorDto = moderatorMapper.toDto(moderator);
        assertThat(actualModeratorDto).isEqualToComparingFieldByField(moderator);
    }

    @Test
    public void toDomain_givenModeratorDto_thenMapAllFieldsToModerator() {
        ModeratorDto moderatorDto = ModeratorDto.moderatorDto()
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withEmail("rensquentin@hotmail.com")
                        .withFirstName("Quentin")
                        .withLastName("Rens")
                        .build())
                .withId(UUID.randomUUID())
                .withStatus(Status.ADMIN);


        Moderator actualModerator = moderatorMapper.toDomain(moderatorDto);

        assertThat(actualModerator).isEqualToComparingFieldByField(moderatorDto);
    }

}
