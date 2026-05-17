package com.kh.web.common.model.dto;

public class NoticePageInfo {
	private int listCount;
	private int currentPage;
	private int pageLimit;
	private int noticeLimit;
	private int startPage;
	private int endPage;
	private int maxPage;
	private int offset;
	
	public NoticePageInfo() {
		super();
	}
	public NoticePageInfo(int listCount, int currentPage, int pageLimit, int noticeLimit, int startPage, int endPage,
			int maxPage, int offset) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.noticeLimit = noticeLimit;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.offset = offset;
	}
	
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public int getNoticeLimit() {
		return noticeLimit;
	}
	public void setNoticeLimit(int noticeLimit) {
		this.noticeLimit = noticeLimit;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	@Override
	public String toString() {
		return "NoticePageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", noticeLimit=" + noticeLimit + ", startPage=" + startPage + ", endPage=" + endPage + ", maxPage="
				+ maxPage + ", offset=" + offset + "]";
	}
	
}
