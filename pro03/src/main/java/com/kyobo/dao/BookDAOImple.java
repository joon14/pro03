package com.kyobo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyobo.dto.Book;

@Repository
public class BookDAOImple implements BookDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("book.getTotalCount");
	}

	@Override
	public List<Book> getBookList() {
		return sqlSession.selectList("book.getBookList");
	}

	@Override
	public List<Book> getBookGenreList(String genre) {
		return sqlSession.selectList("book.getBookGenreList", genre);
	}

	@Override
	public Book getBook(int no) {
		return sqlSession.selectOne("book.getBook", no);
	}

	@Override
	public void insBook(Book book) {
		sqlSession.insert("book.insBook", book);
	}

	@Override
	public void upBook(Book book) {
		sqlSession.update("book.upBook", book);
	}

	@Override
	public void delBook(int no) {
		sqlSession.delete("book.delBook", no);
	}
	
}
