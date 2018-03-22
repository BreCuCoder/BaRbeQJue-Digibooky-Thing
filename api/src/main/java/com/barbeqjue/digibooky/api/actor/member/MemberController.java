package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.services.actor.member.MemberService;
import com.barbeqjue.digibooky.services.actor.person.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping (path = "/members")
public class MemberController {
    private PersonService personService;
    private MemberService memberService;
    private MemberMapper memberMapper;

    @Inject
    public MemberController(MemberService memberService, MemberMapper memberMapper, PersonService personService) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.personService = personService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember (@RequestBody MemberDto memberDto){
        personService.createPerson(memberMapper.toDomain(memberDto).getPerson());
        return memberMapper.toDto(memberService.createMember(memberMapper.toDomain(memberDto)));
    }
}
