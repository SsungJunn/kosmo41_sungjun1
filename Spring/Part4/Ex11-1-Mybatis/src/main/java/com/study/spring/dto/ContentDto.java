package com.study.spring.dto;

public class ContentDto {

	private int nId;
	private String mWriter;

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getmWriter() {
		return mWriter;
	}

	public void setmWriter(String mWriter) {
		this.mWriter = mWriter;
	}

	public String getnCotnet() {
		return nCotnet;
	}

	public void setnCotnet(String nCotnet) {
		this.nCotnet = nCotnet;
	}

	private String nCotnet;

	public ContentDto() {

		// TODO Auto-generated constructor stub
	}

	public ContentDto(int nId, String mWriter, String nCotnet) {
		this.nId = nId;
		this.mWriter = mWriter;
		this.nCotnet = nCotnet;
	}

}
