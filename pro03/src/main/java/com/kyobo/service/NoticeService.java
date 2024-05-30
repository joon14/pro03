package com.kyobo.service;

import java.util.List;

import com.kyobo.dto.Notice;

public interface NoticeService {
	public List<Notice> getNoticeList();
	public Notice getNotice(int no);
	public int maxNum();
	public void insNotice(Notice notice);
	public void upNotice(Notice notice);
	public void countUpCnt(int no);
	public void delNotice(int no);
}
