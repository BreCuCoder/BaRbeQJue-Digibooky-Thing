package com.barbeqjue.digibooky.services.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.actor.member.MemberRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;

@Named
public class MemberService {
    private final MemberRepository memberRepository;

    @Inject
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember (Member providedMember){
        assertINSSIsValid(providedMember);
        assertCityisValid(providedMember);
        return memberRepository.storeMember(providedMember);

    }

    public Member getMember(Integer id) {
        assertMemberIsPresent(memberRepository.getMember(id));
        return memberRepository.getMember(id);
    }

    private void assertMemberIsPresent(Member queriedMemberById) {
        if (queriedMemberById == null) {
            throw new IllegalArgumentException("Member doesn't exist");
        }
    }


    private void assertINSSIsValid(Member providedMember){
        if (providedMember.getInss() == null){
            throw new IllegalArgumentException("You have to provide an INSS number");
        }
        if (!memberRepository
                .getMembers()
                .stream()
                .filter(member -> member.getInss().equals(providedMember.getInss()))
                .collect(Collectors.toList()).isEmpty()){
            throw new IllegalArgumentException("This INSS number is already in the database");
        }
    }

    private void assertCityisValid (Member providedMember){
        if (providedMember.getCity() == null || providedMember.getCity().length() == 0){
            throw new IllegalArgumentException( "You have to provide a last name");
        }
    }
}
