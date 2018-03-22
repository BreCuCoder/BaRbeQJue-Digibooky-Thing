package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.api.actor.member.MemberDto;
import com.barbeqjue.digibooky.api.actor.member.MemberMapper;
import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.actor.person.Person;
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
                .withPerson(Person.PersonBuilder.person()
                        .withId(1)
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
    public void toDomain_givenMemberDto_thenMapAllFieldsToMember() {
        MemberDto memberDto = MemberDto.memberDto()
                .withPerson(Person.PersonBuilder.person()
                        .withId(1)
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
