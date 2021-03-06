package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberMapperTest {
    private MemberMapper memberMapper;

    @Before
    public void instantiateMapper() {
        memberMapper = new MemberMapper();
    }

    @Test
    public void toDto_givenMember_thenMapAllFieldsToMemberDto() {
        Member member = Member.MemberBuilder.member()
                .withId(UUID.randomUUID())
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withEmail("rensquentin@hotmail.com")
                        .withFirstName("Quentin")
                        .withLastName("Rens")
                        .build())
                .withInss("54546")
                .withStreetName("Saint-Feuillen")
                .withStreetNumber("3")
                .withCity("Charleroi")
                .withPostalCode("6120")
                .build();

        MemberDto memberDto = memberMapper.toDto(member);

        assertThat(memberDto)
                .isEqualToComparingFieldByField(member);
    }

    @Test
    public void toDtoWithoutInss_givenMemberWithInss_ThenMapAllFieldsButInssToMemberDto(){
        Member member = Member.MemberBuilder.member()
                .withId(UUID.randomUUID())
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withEmail("rensquentin@hotmail.com")
                        .withFirstName("Quentin")
                        .withLastName("Rens")
                        .build())
                .withInss("54546")
                .withStreetName("Saint-Feuillen")
                .withStreetNumber("3")
                .withCity("Charleroi")
                .withPostalCode("6120")
                .build();

        MemberDto memberDto = memberMapper.toDtoWithoutInss(member);

        assertThat(memberDto).isEqualToIgnoringGivenFields(member, "inss");
        assertThat(memberDto.getInss()).isEqualTo(null);
    }

    @Test
    public void toDomain_givenMemberDto_thenMapAllFieldsToMember() {
        MemberDto memberDto = MemberDto.memberDto()
                .withId(UUID.randomUUID())
                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                        .withEmail("rensquentin@hotmail.com")
                        .withFirstName("Quentin")
                        .withLastName("Rens")
                        .build())
                .withInss("54546")
                .withStreetName("Saint-Feuillen")
                .withStreetNumber("3")
                .withCity("Charleroi")
                .withPostalCode("6120");

        Member member = memberMapper.toDomain(memberDto);

        assertThat(member)
                .isEqualToComparingFieldByField(memberDto);
    }

}
