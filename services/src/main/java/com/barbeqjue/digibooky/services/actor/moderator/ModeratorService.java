package com.barbeqjue.digibooky.services.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import com.barbeqjue.digibooky.domain.actor.moderator.ModeratorRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ModeratorService {

    private final ModeratorRepository moderatorRepository;

    @Inject
    public ModeratorService(ModeratorRepository moderatorRepository) {
        this.moderatorRepository = moderatorRepository;
    }

    public Moderator createPerson (Moderator providedModerator){
        return moderatorRepository.storeModerator(providedModerator);

    }

}
