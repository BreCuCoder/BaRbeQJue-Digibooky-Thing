package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.api.actor.member.MemberDto;
import com.barbeqjue.digibooky.domain.actor.member.Member;

import javax.inject.Named;

@Named
public class MemberMapper {
    MemberDto toDto(Member member) {
        return MemberDto.memberDto()
                .withPerson(member.getPerson())
                .withInss(member.getInss())
                .withStreetNumber(member.getStreetNumber())
                .withStreetName(member.getStreetName())
                .withCity(member.getCity())
                .withPostalCode(member.getPostalCode());
    }

    Member toDomain(MemberDto memberDto) {
        return Member.MemberBuilder.member()
                .withPerson(memberDto.getPerson())
                .withInss(memberDto.getInss())
                .withStreetNumber(memberDto.getStreetNumber())
                .withStreetName(memberDto.getStreetName())
                .withCity(memberDto.getCity())
                .withPostalCode(memberDto.getPostalCode())
                .build();
    }
}
