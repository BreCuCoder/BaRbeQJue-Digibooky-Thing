package com.barbeqjue.digibooky.api.actor.moderator;


import com.barbeqjue.digibooky.services.actor.moderator.ModeratorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/moderators")
public class ModeratorController {
    private ModeratorService moderatorService;
    private ModeratorMapper moderatorMapper;

    @Inject
    public ModeratorController(ModeratorService moderatorService, ModeratorMapper moderatorMapper) {
        this.moderatorService = moderatorService;
        this.moderatorMapper = moderatorMapper;
    }

    @PostMapping(path = "/register_librarian", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ModeratorDto registerLibrarian (@RequestBody  ModeratorDto moderatorDto){
       return moderatorMapper.toDto(moderatorService.createLibrarian(moderatorMapper.toDomain(moderatorDto)));
    }
}
