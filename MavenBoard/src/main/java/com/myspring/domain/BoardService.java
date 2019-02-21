package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("bs")
public class BoardService {
		@Resource(name="bDao")
		private BoardDAOImpl bDao;
		
		
	public void insert(BoardDTO dto) {
		bDao.insertBoard("Insert", dto);
	}
	public List<BoardDTO> list(HashMap<String, String> map) {
		List<BoardDTO> arr = bDao.ListView(map);
		return arr;
	}
	public BoardDTO view(int seq) {
		bDao.plusHitcount(seq);
		BoardDTO dto = bDao.ViewBoard(seq);
		return dto;
	}
	public int passcheck(int seq, String password) {
		
		int flag = bDao.passwordCheck(seq, password);
		
		return flag;
	}
	public void update(BoardDTO dto) {
		bDao.updateBoard(dto);
	}
	public void delete(int seq) {
		bDao.deleteBoard(seq);
	}
	public int boardCount(HashMap<String, String> map ) {
		int count = bDao.CountBoard(map);
		
		return count;
	}
	public void insertOpinion(BoardDTO dto) {
		bDao.insertOpinion(dto);
		
	}
	public void updateOpinion(BoardDTO dto) {
		bDao.updateOpinion(dto);
	}

}
