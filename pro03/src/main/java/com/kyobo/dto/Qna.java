package com.kyobo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qna {
	private int no;
	private int plevel;
	private int parno;
	private String title;
	private String content;
	private String resdate;
	private String aid;
}
