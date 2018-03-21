package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;

import javax.inject.Named;
import java.util.UUID;

@Named
public class MemberMapper {
    MemberDto toDto(Member member) {
        return MemberDto.memberDto()
                .withId(member.getId())
                .withHumanInfo(member.getHumanInfo())
                .withInss(member.getInss())
                .withStreetNumber(member.getStreetNumber())
                .withStreetName(member.getStreetName())
                .withCity(member.getCity())
                .withPostalCode(member.getPostalCode());
    }

    Member toDomain(MemberDto memberDto) {
        return Member.MemberBuilder.member()
                .withId(memberDto.getId())
                .withHumanInfo((memberDto.getHumanInfo()))
                .withInss(memberDto.getInss())
                .withStreetNumber(memberDto.getStreetNumber())
                .withStreetName(memberDto.getStreetName())
                .withCity(memberDto.getCity())
                .withPostalCode(memberDto.getPostalCode())
                .build();
    }
}
