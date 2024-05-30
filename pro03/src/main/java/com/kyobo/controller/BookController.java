package com.kyobo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kyobo.dto.Book;
import com.kyobo.service.BookService;

@Controller
@RequestMapping("/book/")
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private static final String uploadLoc = "/resources/upload/";
	
	@RequestMapping("listAll.do")
	public String getBookList(Model model) {
		model.addAttribute("list", bookService.getBookList());
		return "book/list";
	}
	
	@RequestMapping("list.do")
	public String getBookGenreList(@RequestParam("genre") String genre, Model model) {
		model.addAttribute("list", bookService.getBookGenreList(genre));
		return "book/list";
	}
	
	@RequestMapping("detail.do")
	public String getBook(@RequestParam("no") int no, Model model) {
		model.addAttribute("book", bookService.getBook(no));
		return "book/detail";
	}
	
	@GetMapping("insert.do")
	public String insBook(Book book, Model model) {
		return "book/insert";
	}
	
	@PostMapping("insertPro.do")
	public String insBookPro(@RequestParam("name") String name,
			@RequestParam("genre") String genre,
			@RequestParam("author") String author,
			@RequestParam("pub") String pub,
			@RequestParam("content") String content,
			@RequestParam("pub_date") String pub_date,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		File dir = new File(uploadDir);
		
		String img1Name="", img2Name="", img3Name="";
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			if(!img1.isEmpty()) {
				img1Name = saveFile(img1, uploadDir);
				log.info("업로드 파일1 이름 : {}", img1Name);
			}
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("업로드 파일2 이름 : {}", img2Name);
			}
			if(!img3.isEmpty()) {
				img3Name = saveFile(img3, uploadDir);
				log.info("업로드 파일3 이름 : {}", img3Name);
			}
		} catch (IOException e) {
			log.error("예외 : {}", e);
		}
		
		Book book = new Book();
		book.setName(name);
		book.setGenre(genre);
		book.setAuthor(author);
		book.setPub(pub);
		book.setContent(content);
		book.setPrice(price);
		book.setImg1(img1Name);
		book.setImg2(img2Name);
		book.setImg3(img3Name);
		
		bookService.insBook(book);
		return "redirect:listAll.do";
	}
	
	public String saveFile(MultipartFile file, String uploadDir) throws IOException {
		String originalFilename = file.getOriginalFilename();
		String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;
		File serverFile = new File(uploadDir + newFilename);
		file.transferTo(serverFile);
		return newFilename;
	}
	
	@GetMapping("update.do")
	public String upBook(@RequestParam("no") int no,
			/*
			@RequestParam("name") String name,
			@RequestParam("genre") String genre,
			@RequestParam("author") String author,
			@RequestParam("pub") String pub,
			@RequestParam("content") String content,
			@RequestParam("pub_date") String pub_date,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,*/
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		model.addAttribute("book", bookService.getBook(no));
		return "book/update";
	}
	
	@PostMapping("updatePro.do")
	public String upBookPro(@RequestParam("no") int no,
			@RequestParam("name") String name,
			@RequestParam("genre") String genre,
			@RequestParam("author") String author,
			@RequestParam("pub") String pub,
			@RequestParam("content") String content,
			@RequestParam("pub_date") String pub_date,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		Book before = bookService.getBook(no);
		
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		File dir = new File(uploadDir);
		
		String img1Name="", img2Name="", img3Name="";
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			if(!img1.isEmpty()) {
				img1Name = saveFile(img1, uploadDir);
				log.info("변경 파일1 이름 : {}", img1Name);
			} else {
				img1Name = before.getImg1();
			}
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("변경 파일2 이름 : {}", img2Name);
			} else {
				img2Name = before.getImg2();
			}
			if(!img3.isEmpty()) {
				img3Name = saveFile(img3, uploadDir);
				log.info("변경 파일3 이름 : {}", img3Name);
			} else {
				img3Name = before.getImg3();
			}
		} catch (IOException e) {
			log.error("예외 : {}", e);
		}
		
		Book book = new Book();
		book.setNo(no);
		book.setName(name);
		book.setGenre(genre);
		book.setAuthor(author);
		book.setPub(pub);
		book.setContent(content);
		book.setPub_date(pub_date);
		book.setPrice(price);
		book.setImg1(img1Name);
		book.setImg2(img2Name);
		book.setImg3(img3Name);
		
		bookService.upBook(book);
		return "redirect:listAll.do";
	}
	
	@RequestMapping("delBook.do")
	public String delBook(@RequestParam("no") int no, Model model) {
		bookService.delBook(no);
		return "redirect:listAll.do";
	}
}
