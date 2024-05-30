package com.kyobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyobo.dao.BookDAO;
import com.kyobo.dto.Book;

@Service
public class BookServiceImple implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	@Override
	public int getTotalCount() {
		return bookDAO.getTotalCount();
	}

	@Override
	public List<Book> getBookList() {
		return bookDAO.getBookList();
	}

	@Override
	public List<Book> getBookGenreList(String genre) {
		return bookDAO.getBookGenreList(genre);
	}

	@Override
	public Book getBook(int no) {
		return bookDAO.getBook(no);
	}

	@Override
	public void insBook(Book book) {
		bookDAO.insBook(book);
	}

	@Override
	public void upBook(Book book) {
		bookDAO.upBook(book);
	}

	@Override
	public void delBook(int no) {
		bookDAO.delBook(no);
	}
	
}
