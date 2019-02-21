package com.myspring.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.domain.BoardDTO;
import com.myspring.domain.BoardService;
import com.myspring.domain.CommentDTO;
import com.myspring.domain.CommentService;
import com.myspring.page.Paging;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name = "bs")
	private BoardService bs;
	@Resource(name = "page")
	private Paging page;
	@Resource(name = "cs")
	private CommentService cs;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("InsertBoard")
	public String insertform() {
		return "BoardInsert";
	}
	@RequestMapping(value="InsertBoard", method=RequestMethod.POST)
	public String insert(BoardDTO dto) {
		bs.insert(dto);
		return "redirect:ListBoard";
		
	}
	@RequestMapping(value = "ListBoard")
	public void list(Model model, String pageNum,String field, String word) {
		String spageNum = pageNum==null?"1":pageNum;
		int currentPage = Integer.parseInt(spageNum);
		int pageSize = 5;
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow",String.valueOf(endRow));
		map.put("field",field);
		map.put("word",word);
		int count = bs.boardCount(map);
		List<BoardDTO> arr = bs.list(map);
		String  pageHtml = page.searchpaging(count,pageSize,currentPage,field,word);		
		
			/* pageHtml = page.paging(count,pageSize,currentPage); */	
		
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("pageHtml",pageHtml);
		model.addAttribute("arr",arr);
		model.addAttribute("count",count);
	}
	@RequestMapping(value = "ViewBoard")
	public void view(Model model, int seq) {
		BoardDTO dto = bs.view(seq);
		List<CommentDTO> arr = cs.list(seq);
		model.addAttribute("dto",dto);
		model.addAttribute("arr",arr);
	}
	
	
	
	
	
	
	@RequestMapping(value = "passcheck", method=RequestMethod.POST)
	public ModelAndView passcheck(int seq, String password) {
		int flag = bs.passcheck(seq,password);
		
		ModelAndView mv = new ModelAndView();
		
		if(flag==0) {
			BoardDTO dto = bs.view(seq);
			mv.addObject("dto",dto);
			mv.addObject("checknum",0);
			mv.setViewName("ViewBoard");
			
		}else if(flag ==1) {
			BoardDTO dto = bs.view(seq);
			mv.addObject("dto",dto);
			mv.setViewName("UpdateForm");
		}
		return mv;
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(BoardDTO dto) {
		bs.update(dto);
		return "redirect:ListBoard";
		
	}
	@RequestMapping("deleteBoard")
	public String delete(int seq) {
		bs.delete(seq);
		return "redirect:ListBoard";
	}
	@RequestMapping(value="opinion")
	public void opinionform(Model model, int seq,String title,String boardlevel, String steps, String groups) {
		model.addAttribute("seq",seq);
		model.addAttribute("title",title);
		model.addAttribute("boardlevel",boardlevel);
		model.addAttribute("steps",steps);
		model.addAttribute("groups",groups);
		
	}
	
	@RequestMapping(value = "InsertOpinion", method=RequestMethod.POST)
	public String insertOpinion(BoardDTO dto) {
		bs.updateOpinion(dto);
		bs.insertOpinion(dto);
		return "redirect:ListBoard";
	}
	@RequestMapping("replyAction")
	public String reply(CommentDTO cdto) {
		cs.com_insert(cdto);
		return "redirect:ViewBoard?seq="+cdto.getBoardnum();
	}
	
}
