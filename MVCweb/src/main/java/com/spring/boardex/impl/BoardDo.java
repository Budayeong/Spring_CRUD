package com.spring.boardex.impl;

public class BoardDo {
	private int seq; 
	private String title;
	private String writer;
	private String content;
	private String id;
	private String name;
	private String password;
	private String number;
	
	
	
	//로그인,회원가입
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	//게시판
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + 
					", title=" + title + 
					", writer=" + writer + 
					", content=" + content + "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
