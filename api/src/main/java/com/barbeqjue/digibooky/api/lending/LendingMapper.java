package com.barbeqjue.digibooky.api.lending;

import com.barbeqjue.digibooky.domain.lending.Lending;

public class LendingMapper {

    LendingDto toDto (Lending lending){
        return LendingDto.lendingDto()
                .withUuid(lending.getuuid())
                .withDueDate(lending.getDueDate())
                .withBook(lending.getBook())
                .withMember(lending.getMember());
    }

    Lending toDomain (LendingDto lendingDto){
        return Lending.LendingBuilder.lending()
                .withUuid(lendingDto.getUuid())
                .withDueDate(lendingDto.getDueDate())
                .withBook(lendingDto.getBook())
                .withMember(lendingDto.getMember())
                .build();
    }
}
