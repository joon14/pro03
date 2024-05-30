package com.kyobo.dao;

import java.util.List;

import com.kyobo.dto.Qna;

public interface QnaDAO {
	public List<Qna> getQnaList();
	public Qna getQna(int no);
	public int maxNum();
	public void insQuestion(Qna qna);
	public void insAnswer(Qna qna);
	public void delQna(int parno);
}
