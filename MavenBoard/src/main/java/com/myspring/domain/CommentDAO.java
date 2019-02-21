package com.myspring.domain;

import java.util.List;

public interface CommentDAO {
	
	void com_insert(CommentDTO cdto);
	List<CommentDTO> com_list(int boardnum);
	void com_del(int com_seq);
	
}
