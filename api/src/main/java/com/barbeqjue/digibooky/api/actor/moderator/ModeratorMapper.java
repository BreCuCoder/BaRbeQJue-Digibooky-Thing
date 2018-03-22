package com.barbeqjue.digibooky.api.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;

import javax.inject.Named;

@Named
public class ModeratorMapper {
    ModeratorDto toDto (Moderator moderator){
        return ModeratorDto.moderatorDto()
                .withId(moderator.getId())
                .withHumanInfo(moderator.getHumanInfo())
                .withStatus(moderator.getStatus());
    }

    Moderator toDomain (ModeratorDto moderatorDto){
        return Moderator.ModeratorBuilder.moderator()
                .withId(moderatorDto.getId())
                .withHumanInfo(moderatorDto.getHumanInfo())
                .withStatus(moderatorDto.getStatus())
                .build();
    }
}
