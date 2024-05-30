package com.kyobo.service;

import java.util.List;

import com.kyobo.dto.Book;

public interface BookService {
	public int getTotalCount();
	public List<Book> getBookList();
	public List<Book> getBookGenreList(String genre);
	public Book getBook(int no);
	public void insBook(Book book);
	public void upBook(Book book);
	public void delBook(int no);
}
