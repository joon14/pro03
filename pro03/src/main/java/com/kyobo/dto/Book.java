package com.kyobo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private int no;
	private String name;
	private String genre;
	private String author;
	private String pub;
	private String content;
	private String pub_date;
	private int price;
	private String img1;
	private String img2;
	private String img3;
}
