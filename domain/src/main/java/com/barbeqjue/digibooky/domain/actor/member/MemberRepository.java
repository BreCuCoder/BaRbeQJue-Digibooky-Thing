package com.barbeqjue.digibooky.domain.actor.member;

import com.barbeqjue.digibooky.domain.actor.member.Member;

import javax.inject.Named;
import java.util.*;


@Named
public class MemberRepository {
    private Map<Integer, Member> members;

    public MemberRepository(){
        members = new HashMap<>();
    }

    public Member storeMember(Member member){
        members.put(member.getPerson().getId(), member);
        return member;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(new ArrayList<>(members.values()));
    }

    public Member getMember(Integer id) {
        return members.get(id);
    }

    public Member updateMember(Member updatedMember) {
        members.put(updatedMember.getPerson().getId(), updatedMember);
        return updatedMember;
    }

    public void deleteMember(Integer idToRemove) {
        members.remove(idToRemove);
    }
}
