package com.barbeqjue.digibooky.api.lending;

import com.barbeqjue.digibooky.services.lending.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;
    private  LendingMapper lendingMapper;

    @Inject
    public LendingController(LendingService lendingService, LendingMapper lendingMapper) {
        this.lendingService = lendingService;
        this.lendingMapper = lendingMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LendingDto lendABook(@RequestBody Integer userId, @RequestBody String isbn) {
        return lendingMapper.toDto(lendingService.lendABook(userId, isbn));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void returnBook (@RequestBody Integer userId) {
        lendingService.returnBook(userId);
    }

}
