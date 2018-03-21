package com.barbeqjue.digibooky.api.member;

import com.barbeqjue.digibooky.domain.member.Member;
import org.junit.Before;
import org.junit.Test;

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
                .withId(1)
                .withInss("54546")
                .withEmail("rensquentin@hotmail.com")
                .withFirstName("Quentin")
                .withLastName("Rens")
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
    public void toDomain_givenMemberDto_thenMapAllFieldsToMember() {
        MemberDto memberDto = MemberDto.memberDto()
                .withId(1)
                .withInss("54546")
                .withEmail("rensquentin@hotmail.com")
                .withFirstName("Quentin")
                .withLastName("Rens")
                .withStreetName("Saint-Feuillen")
                .withStreetNumber("3")
                .withCity("Charleroi")
                .withPostalCode("6120");

        Member member = memberMapper.toDomain(memberDto);

        assertThat(member)
                .isEqualToComparingFieldByField(memberDto);
    }
}
