package com.peake.webseed.feature.member.dto;

import com.peake.webseed.feature.member.model.Member;

public class MemberDTO {
    Member member;
    boolean isNew;

    public MemberDTO(Member member, boolean isNew) {
        this.member = member;
        this.isNew = isNew;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
