package com.myspring.domain;

public class BoardDTO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int hitcount;
	private String password;
	private int groups;
	private int boardlevel;
	private int steps;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGroups() {
		return groups;
	}
	public void setGroups(int groups) {
		this.groups = groups;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public int getBoardlevel() {
		return boardlevel;
	}
	public void setBoardlevel(int boardlevel) {
		this.boardlevel = boardlevel;
	}
	
	

}
