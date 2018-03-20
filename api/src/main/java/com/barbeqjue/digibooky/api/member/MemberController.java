package com.barbeqjue.digibooky.api.member;

import com.barbeqjue.digibooky.services.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping (path = "/members")
public class MemberController {
    private MemberService memberService;
    private MemberMapper memberMapper;

    @Inject
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember (MemberDto memberDto){
        return memberMapper.toDto(memberService.createMember(memberMapper.toDomain(memberDto)));
    }
}
