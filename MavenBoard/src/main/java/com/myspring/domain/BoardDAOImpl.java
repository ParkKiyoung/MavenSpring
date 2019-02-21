package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bDao")
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlMap;

	@Override
	public List<BoardDTO> ListView(HashMap<String, String> map) {
		List<BoardDTO> arr = sqlMap.selectList("selectList",map);
		return arr;
	}

	@Override
	public void insertBoard(String sqlid, BoardDTO dto) {
		sqlMap.insert(sqlid,dto);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		sqlMap.update("updateBoard",dto);
		
	}

	@Override
	public void deleteBoard(int seq) {
		sqlMap.delete("deleteBoard",seq);
		
	}

	@Override
	public BoardDTO ViewBoard(int seq) {
		BoardDTO dto = sqlMap.selectOne("viewBoard", seq); 
		return dto;
	}

	@Override
	public int passwordCheck(int seq,String password) {
		if(sqlMap.selectOne("passcheck", seq).equals(password)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int CountBoard(HashMap<String, String> map) {
		int count = sqlMap.selectOne("boardCount",map);
		return count;
	}

	public void plusHitcount(int seq) {
		sqlMap.update("plusHitcount",seq);
		
	}

	public void insertOpinion(BoardDTO dto) {
		dto.setBoardlevel(dto.getBoardlevel()+1);
		dto.setSteps(dto.getSteps()+1);
		sqlMap.insert("insertOpinion", dto);	
	}

	public void updateOpinion(BoardDTO dto) {
		sqlMap.update("UpdateOpinion",dto);
	}
}
