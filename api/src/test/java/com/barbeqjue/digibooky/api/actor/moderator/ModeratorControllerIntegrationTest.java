package com.barbeqjue.digibooky.api.actor.moderator;


import com.barbeqjue.digibooky.api.DigibookyRunner;
import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.member.MemberRepository;
import com.barbeqjue.digibooky.domain.actor.moderator.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DigibookyRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ModeratorControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Inject
    private MemberRepository memberRepository;

    @Test
    public void registerLibrarian() {
        ModeratorDto moderatorDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "moderators/register_librarian"),
                        ModeratorDto.moderatorDto().
                                withHumanInfo(HumanInfo.HumanInfoBuilder.humanInfo()
                                        .withEmail("rensquentin@hotmail.com")
                                        .withFirstName("Quentin")
                                        .withLastName("Rens")
                                        .build()),
                        ModeratorDto.class);

        assertThat(moderatorDto.getHumanInfo().getEmail()).isEqualTo("rensquentin@hotmail.com");
        assertThat(moderatorDto.getHumanInfo().getFirstName()).isEqualTo("Quentin");
        assertThat(moderatorDto.getHumanInfo().getLastName()).isEqualTo("Rens");
        assertThat(moderatorDto.getId()).isNotNull();
        assertThat(moderatorDto.getStatus()).isEqualTo(Status.LIBRARIAN);
    }


}
