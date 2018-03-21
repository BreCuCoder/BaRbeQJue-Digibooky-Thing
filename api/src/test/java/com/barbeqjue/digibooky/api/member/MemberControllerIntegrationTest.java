package com.barbeqjue.digibooky.api.member;


import com.barbeqjue.digibooky.api.DigibookyRunner;
import com.barbeqjue.digibooky.domain.member.MemberRepository;
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
    public void registerMember (){
        MemberDto memberDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "members"),
                        MemberDto.memberDto()
                                .withInss("44444")
                                .withEmail("rensquentin@hotmail.com")
                                .withLastName("Rens")
                                .withCity("Charleroi"),
                        MemberDto.class );

        Assertions.assertThat(memberDto.getInss()).isEqualTo("44444");
        Assertions.assertThat(memberDto.getEmail()).isEqualTo("rensquentin@hotmail.com");
        Assertions.assertThat(memberDto.getLastName()).isEqualTo("Rens");
        Assertions.assertThat(memberDto.getCity()).isEqualTo("Charleroi");

    }

}
