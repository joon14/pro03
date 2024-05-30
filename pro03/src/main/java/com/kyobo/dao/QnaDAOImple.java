package com.kyobo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyobo.dto.Qna;

@Repository
public class QnaDAOImple implements QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Qna> getQnaList() {
		return sqlSession.selectList("qna.getQnaList");
	}

	@Override
	public Qna getQna(int no) {
		return sqlSession.selectOne("qna.getQna", no);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("qna.maxNum");
	}

	@Override
	public void insQuestion(Qna qna) {
		sqlSession.insert("qna.insQuestion", qna);	
	}

	@Override
	public void insAnswer(Qna qna) {
		sqlSession.insert("qna.insAnswer", qna);
	}

	@Override
	public void delQna(int parno) {
		sqlSession.delete("qna.delQna", parno);
	}
	
}
