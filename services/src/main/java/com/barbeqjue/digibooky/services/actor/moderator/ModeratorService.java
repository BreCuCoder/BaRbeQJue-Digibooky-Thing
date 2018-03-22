package com.barbeqjue.digibooky.services.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import com.barbeqjue.digibooky.domain.actor.moderator.ModeratorRepository;
import com.barbeqjue.digibooky.domain.actor.moderator.Status;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ModeratorService {

    private final ModeratorRepository moderatorRepository;

    @Inject
    public ModeratorService(ModeratorRepository moderatorRepository) {
        this.moderatorRepository = moderatorRepository;
    }

    public Moderator createLibrarian(Moderator providedModerator){
        providedModerator.setStatus(Status.LIBRARIAN);
        return moderatorRepository.storeModerator(providedModerator);
    }
}
