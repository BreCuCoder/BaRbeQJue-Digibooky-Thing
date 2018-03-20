package com.barbeqjue.digibooky.api.member;

import com.barbeqjue.digibooky.domain.member.Member;

import javax.inject.Named;

@Named
public class MemberMapper {
    MemberDto toDto (Member member){
        return MemberDto.memberDto()
                .withId(member.getId())
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName());
    }

    Member toDomain (MemberDto memberDto){
        return Member.MemberBuilder.member()
                .withInss(memberDto.getInss())
                .withEmail(memberDto.getEmail())
                .withFirstName(memberDto.getFirstName())
                .withLastName(memberDto.getLastName())
                .withStreetNumber(memberDto.getStreetNumber())
                .withStreetName(memberDto.getStreetName())
                .withCity(memberDto.getCity())
                .withPostalCode(memberDto.getPostalCode())
                .build();
    }
}
