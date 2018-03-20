package com.barbeqjue.digibooky.api.member;

import com.barbeqjue.digibooky.domain.member.Member;

import javax.inject.Named;

@Named
public class MemberMapper {
    MemberDto toDto (Member member){
        return MemberDto.memberDto()
                .withId(member.getId())
                .withInss(member.getInss())
                .withEmail(member.getEmail())
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .withStreetNumber(member.getStreetNumber())
                .withStreetName(member.getStreetName())
                .withCity(member.getCity())
                .withPostalCode(member.getPostalCode());
    }

    Member toDomain (MemberDto memberDto){
        return Member.MemberBuilder.member()
                .withId(memberDto.getId())
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
