package com.kyobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyobo.dao.MemberDAO;
import com.kyobo.dto.Member;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<Member> getMemberList() {
		return memberDAO.getMemberList();
	}

	@Override
	public Member getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public int maxNum() {
		return memberDAO.maxNum();
	}

	@Override
	public void insMember(Member member) {
		memberDAO.insMember(member);
	}

	@Override
	public void upMember(Member member) {
		memberDAO.upMember(member);
	}

	@Override
	public void delMember(String id) {
		memberDAO.delMember(id);
	}
	
}
