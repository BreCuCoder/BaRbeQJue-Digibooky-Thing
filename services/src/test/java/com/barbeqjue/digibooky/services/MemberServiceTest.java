package com.barbeqjue.digibooky.services;

import com.barbeqjue.digibooky.domain.Member;
import com.barbeqjue.digibooky.domain.MemberRepository;
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
                .withInss("duhe")
                .withEmail("quentinrens@hotmail.com")
                .withLastName("Rens")
                .withCity("Charleroi")
                .build();

        Member expectedMember = Member.MemberBuilder.member()
                .withId(1)
                .withInss(providedMember.getInss())
                .withEmail(providedMember.getEmail())
                .withLastName(providedMember.getLastName())
                .withCity(providedMember.getCity())
                .build();

        Mockito.when(memberRepository.storeMember(providedMember)).thenReturn(expectedMember);

        Member actualMember = memberService.createMember(providedMember);

        Assertions.assertThat(actualMember).isEqualToComparingFieldByField(expectedMember);
        }
}
