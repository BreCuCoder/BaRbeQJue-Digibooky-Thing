package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.services.actor.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
    public MemberDto registerMember (@RequestBody MemberDto memberDto){
        return memberMapper.toDto(memberService.createMember(memberMapper.toDomain(memberDto)));
    }

    @GetMapping (produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDto> getMembers(){
        return memberService.getMembers()
                .stream()
                .map(member -> memberMapper.toDtoWithoutInss(member))
                .collect(Collectors.toList());
    }

}
