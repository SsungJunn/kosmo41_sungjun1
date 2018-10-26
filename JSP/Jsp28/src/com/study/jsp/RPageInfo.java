package com.study.jsp;

public class RPageInfo {
	
	int rtotalCount;			// 총 게시물의 갯수
	int rlistCount;	// 한 페이지당 보여줄 게시물의 갯수
	int rtotalPage;			// 총 페이지의 수
	int rcurPage;			// 현재 페이지
	int rpageCount;			// 하단에 보여줄 페이지 리스트의 갯수
	int rstartPage;			// 시작 페이지
	int rendPage;			// 마지막 페이지
	
	public int getRtotalCount() {
		return rtotalCount;
	}
	public void setRtotalCount(int rtotalCount) {
		this.rtotalCount = rtotalCount;
	}
	public int getRlistCount() {
		return rlistCount;
	}
	public void setRlistCount(int rlistCount) {
		this.rlistCount = rlistCount;
	}
	public int getRtotalPage() {
		return rtotalPage;
	}
	public void setRtotalPage(int rtotalPage) {
		this.rtotalPage = rtotalPage;
	}
	public int getRcurPage() {
		return rcurPage;
	}
	public void setRcurPage(int rcurPage) {
		this.rcurPage = rcurPage;
	}
	public int getRpageCount() {
		return rpageCount;
	}
	public void setRpageCount(int rpageCount) {
		this.rpageCount = rpageCount;
	}
	public int getRstartPage() {
		return rstartPage;
	}
	public void setRstartPage(int rstartPage) {
		this.rstartPage = rstartPage;
	}
	public int getRendPage() {
		return rendPage;
	}
	public void setRendPage(int rendPage) {
		this.rendPage = rendPage;
	}
	
	
	
}
