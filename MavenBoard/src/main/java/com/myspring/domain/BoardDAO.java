package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	//전체보기
	List<BoardDTO> ListView(HashMap<String, String> map);
	//추가
	void insertBoard(String sqlid, BoardDTO dto);
	//수정
	void updateBoard(BoardDTO dto);
	//삭제
	void deleteBoard(int seq);
	//상세보기
	BoardDTO ViewBoard(int seq);
	//패스워드체크
	int passwordCheck(int seq, String password);
	//게시글수
	int CountBoard(HashMap<String, String> map);

}
