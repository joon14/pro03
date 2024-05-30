package com.kyobo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyobo.dto.Member;

@Repository
public class MemberDAOImple implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Member> getMemberList() {
		return sqlSession.selectList("member.getMemberList");
	}

	@Override
	public Member getMember(String id) {
		return sqlSession.selectOne("member.getMember", id);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("member.maxNum");
	}

	@Override
	public void insMember(Member member) {
		sqlSession.insert("member.insMember", member);
	}

	@Override
	public void upMember(Member member) {
		sqlSession.update("member.upMember", member);
	}

	@Override
	public void delMember(String id) {
		sqlSession.delete("member.delMember", id);
	}
}
