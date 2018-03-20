package com.barbeqjue.digibooky.domain;

import java.util.*;

public class MemberRepository {
    private static int databaseIndex = 0;
    private Map<Integer, Member> members;

    public MemberRepository(){
        members = new HashMap<>();
    }

    public Member storeMember(Member member){
        member.setId(databaseIndex++);
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
