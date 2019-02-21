package com.myspring.page;

import org.springframework.stereotype.Component;

@Component("page")
public class Paging {

	public String paging(int count, int pageSize, int currentPage) {
		
		int totPage = count/pageSize+(count%pageSize==0?0:1);
		int blockPage = 3;
		int startPage = ((currentPage-1)/blockPage)*blockPage+1;
		int endPage = startPage + blockPage-1;
		if(endPage>totPage)endPage=totPage;
		
		StringBuffer sb = new StringBuffer();
		if(count>0) {
			if(startPage>blockPage) {
				sb.append("<a href=ListBoard?pageNum=");
				sb.append((startPage-blockPage));
				sb.append(">[이전]</a>");
			}
			for(int i = startPage ; i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href=ListBoard?pageNum=");
					sb.append(i);
					sb.append(">["+i+"]</a>");
				}
			}
			if(endPage<totPage) {
				sb.append("<a href=ListBoard?pageNum=");
				sb.append((startPage+blockPage));
				sb.append(">[다음]</a>");
			}
		}
		
		return sb.toString();
	}

	public String searchpaging(int count, int pageSize, int currentPage, String field, String word) {
		
		int totPage = count/pageSize+(count%pageSize==0?0:1);
		int blockPage = 3;
		int startPage = ((currentPage-1)/blockPage)*blockPage+1;
		int endPage = startPage + blockPage-1;
		if(endPage>totPage)endPage=totPage;
		
		StringBuffer sb = new StringBuffer();
		if(count>0) {
			if(startPage>blockPage) {
				sb.append("<a href=ListBoard?pageNum=");
				sb.append((startPage-blockPage));
				sb.append("&field="+field+"&word="+word+">[이전]</a>");
			}
			for(int i = startPage ; i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href=ListBoard?pageNum=");
					sb.append(i);
					sb.append("&field="+field+"&word="+word+">["+i+"]</a>");
				}
			}
			if(endPage<totPage) {
				sb.append("<a href=ListBoard?pageNum=");
				sb.append((startPage+blockPage));
				sb.append("&field="+field+"&word="+word+">[다음]</a>");
			}
		}
		
		return sb.toString();
	}

}
