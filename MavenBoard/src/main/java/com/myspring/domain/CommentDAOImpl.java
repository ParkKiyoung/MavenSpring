package com.myspring.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cDao")
public class CommentDAOImpl implements CommentDAO{
	
	@Autowired
	private SqlSession sqlMap;

	@Override
	public void com_insert(CommentDTO cdto) {
		sqlMap.insert("com_insert",cdto);
		
	}

	@Override
	public List<CommentDTO> com_list(int boardnum) {
		List<CommentDTO> arr = sqlMap.selectList("com_select",boardnum);
		
		return arr;		
	}

	@Override
	public void com_del(int com_seq) {
		// TODO Auto-generated method stub
		
	}
	
	


}
