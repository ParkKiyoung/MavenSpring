package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	//��ü����
	List<BoardDTO> ListView(HashMap<String, String> map);
	//�߰�
	void insertBoard(String sqlid, BoardDTO dto);
	//����
	void updateBoard(BoardDTO dto);
	//����
	void deleteBoard(int seq);
	//�󼼺���
	BoardDTO ViewBoard(int seq);
	//�н�����üũ
	int passwordCheck(int seq, String password);
	//�Խñۼ�
	int CountBoard(HashMap<String, String> map);

}
