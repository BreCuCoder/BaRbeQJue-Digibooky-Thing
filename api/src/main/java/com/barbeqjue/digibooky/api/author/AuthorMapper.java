package com.barbeqjue.digibooky.api.author;

import com.barbeqjue.digibooky.domain.Author;

import javax.inject.Named;

@Named
public class AuthorMapper {
    public AuthorDto toDto(Author author) {
        return AuthorDto.authorDto()
                .withFirstName(author.getFirstName())
                .withLastName(author.getLastName());

    }
}
