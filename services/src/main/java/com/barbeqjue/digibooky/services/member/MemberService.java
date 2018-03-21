package com.barbeqjue.digibooky.services.member;

import com.barbeqjue.digibooky.domain.member.Member;
import com.barbeqjue.digibooky.domain.member.MemberRepository;

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

    private void assertEmailIsValid(Member providedMember){
        if (providedMember.getEmail() == null || providedMember.getEmail().length() == 0){
            throw new IllegalArgumentException("You have to provide an Email");
        }
        if (!providedMember.getEmail().matches("[\\w]{1,}@[\\w]{1,}\\.[\\w]{1,}")){
            throw new IllegalArgumentException("Your email format is not recognized");
        }
    }

    private void assertLastNameisValid (Member providedMember){
        if (providedMember.getLastName() == null || providedMember.getLastName().length() == 0){
            throw new IllegalArgumentException( "You have to provide a last name");
        }
    }

    private void assertCityisValid (Member providedMember){
        if (providedMember.getCity() == null || providedMember.getCity().length() == 0){
            throw new IllegalArgumentException( "You have to provide a last name");
        }
    }
}
