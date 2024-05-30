package com.kyobo.dao;

import java.util.List;

import com.kyobo.dto.Member;

public interface MemberDAO {
	public List<Member> getMemberList();
	public Member getMember(String id);
	public int maxNum();
	public void insMember(Member member);
	public void upMember(Member member);
	public void delMember(String id);
}
