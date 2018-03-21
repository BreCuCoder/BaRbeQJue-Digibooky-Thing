package com.barbeqjue.digibooky.services.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.actor.member.MemberRepository;
import com.barbeqjue.digibooky.services.exceptions.EmptyFieldException;
import com.barbeqjue.digibooky.services.exceptions.IllegalFieldFormatException;
import com.barbeqjue.digibooky.services.exceptions.ResourceAlreadyPresentException;
import com.barbeqjue.digibooky.services.exceptions.UnknownResourceException;

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
        assertEmailIsValid(providedMember);
        assertLastNameisValid(providedMember);
        assertCityisValid(providedMember);
        return memberRepository.storeMember(providedMember);

    }

    public Member getMember(Integer id) {
        assertMemberIsPresent(memberRepository.getMember(id));
        return memberRepository.getMember(id);
    }

    private void assertMemberIsPresent(Member queriedMemberById) {
        if (queriedMemberById == null) {
            throw new UnknownResourceException("ID", Member.class.getSimpleName());
        }
    }


    private void assertINSSIsValid(Member providedMember){
        if (providedMember.getInss() == null){
            throw new EmptyFieldException("INSS");
        }
        if (!memberRepository
                .getMembers()
                .stream()
                .filter(member -> member.getInss().equals(providedMember.getInss()))
                .collect(Collectors.toList()).isEmpty()){
            throw new ResourceAlreadyPresentException("ID", Member.class.getSimpleName());
        }
    }

    private void assertEmailIsValid(Member providedMember){
        if (providedMember.getHumanInfo().getEmail() == null || providedMember.getHumanInfo().getEmail().length() == 0){
            throw new EmptyFieldException("Email");
        }
        if (!providedMember.getHumanInfo().getEmail().matches("[\\w]{1,}@[\\w]{1,}\\.[\\w]{1,}")){
            throw new IllegalFieldFormatException("email");
        }
    }

    private void assertLastNameisValid (Member providedMember){
        if (providedMember.getHumanInfo().getLastName() == null || providedMember.getHumanInfo().getLastName().length() == 0){
            throw new EmptyFieldException("Last Name");
        }
    }

    private void assertCityisValid (Member providedMember){
        if (providedMember.getCity() == null || providedMember.getCity().length() == 0){
            throw new EmptyFieldException("City");
        }
    }
}
