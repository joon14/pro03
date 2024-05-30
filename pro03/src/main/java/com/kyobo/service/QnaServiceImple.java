package com.kyobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyobo.dao.QnaDAO;
import com.kyobo.dto.Qna;

@Service
public class QnaServiceImple implements QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<Qna> getQnaList() {
		return qnaDAO.getQnaList();
	}

	@Override
	public Qna getQna(int no) {
		return qnaDAO.getQna(no);
	}

	@Override
	public int maxNum() {
		return qnaDAO.maxNum();
	}

	@Override
	public void insQuestion(Qna qna) {
		qnaDAO.insQuestion(qna);
	}

	@Override
	public void insAnswer(Qna qna) {
		qnaDAO.insAnswer(qna);
	}

	@Override
	public void delQna(int parno) {
		qnaDAO.delQna(parno);
	}
}
