package com.myspring.domain;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("cs")
public class CommentService {
	
	@Resource(name = "cDao")
	private CommentDAOImpl cDao;

	public void com_insert(CommentDTO cdto) {
		cDao.com_insert(cdto);		
	}

	public List<CommentDTO> list(int boardnum) {
		List<CommentDTO> arr = cDao.com_list(boardnum);
		return arr;
	}

}
