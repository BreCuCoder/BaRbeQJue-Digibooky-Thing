package com.barbeqjue.digibooky.domain.actor.member;

import javax.inject.Named;
import java.util.*;


@Named
public class MemberRepository {
    private Map<UUID, Member> members;

    public MemberRepository(){
        members = new HashMap<>();
    }

    public Member storeMember(Member member){
        members.put(member.getId(), member);
        return member;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(new ArrayList<>(members.values()));
    }

    public Member getMember(Integer id) {
        return members.get(id);
    }

    public Member updateMember(Member updatedMember) {
        members.put(updatedMember.getId(), updatedMember);
        return updatedMember;
    }

    public void deleteMember(Integer idToRemove) {
        members.remove(idToRemove);
    }
}
