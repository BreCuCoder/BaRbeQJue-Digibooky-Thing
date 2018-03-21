package com.barbeqjue.digibooky.services.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.actor.member.MemberRepository;
import com.barbeqjue.digibooky.domain.actor.person.Person;
import com.barbeqjue.digibooky.services.actor.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMember_HappyPath() {
        Member providedMember = Member.MemberBuilder.member()
                .withPerson(Person.PersonBuilder.person()
                        .withId(1)
                        .withLastName("Rens")
                        .withEmail("quentinrens@hotmail.com")
                        .build())
                .withInss("duhe")
                .withCity("Charleroi")
                .build();

        Member expectedMember = Member.MemberBuilder.member()
                .withPerson(providedMember.getPerson())
                .withInss(providedMember.getInss())
                .withCity(providedMember.getCity())
                .build();

        Mockito.when(memberRepository.storeMember(providedMember)).thenReturn(expectedMember);

        Member actualMember = memberService.createMember(providedMember);

        Assertions.assertThat(actualMember).isEqualToComparingFieldByField(expectedMember);
        }
}
