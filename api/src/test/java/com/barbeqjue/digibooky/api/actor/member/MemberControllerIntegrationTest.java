package com.barbeqjue.digibooky.api.actor.member;


import com.barbeqjue.digibooky.api.DigibookyRunner;
import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.member.MemberRepository;
import com.barbeqjue.digibooky.domain.actor.moderator.Moderator;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DigibookyRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private MemberRepository memberRepository;

    @Test
    public void registerMember() {
        MemberDto memberDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "members"),
                        MemberDto.memberDto()
                                .withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                                        .withEmail("rensquentin@hotmail.com")
                                        .withLastName("Rens")
                                        .build())
                                .withInss("44444")
                                .withCity("Charleroi"),
                        MemberDto.class);

        Assertions.assertThat(memberDto.getHumanInfo().getEmail()).isEqualTo("rensquentin@hotmail.com");
        Assertions.assertThat(memberDto.getHumanInfo().getLastName()).isEqualTo("Rens");
        Assertions.assertThat(memberDto.getInss()).isEqualTo("44444");
        Assertions.assertThat(memberDto.getCity()).isEqualTo("Charleroi");

    }

}
