package com.myspring.domain;

public class CommentDTO {
	private String name;
	private String reply;
	private int com_seq;
	private int boardnum;
	private String re_date;
	private String pass;
	
	
	
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCom_seq() {
		return com_seq;
	}
	public void setCom_seq(int com_seq) {
		this.com_seq = com_seq;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	
	
	

}
