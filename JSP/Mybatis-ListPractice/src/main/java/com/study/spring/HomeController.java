package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.dao.IDao;
import com.study.spring.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	ContentDao dao;
//	
//	@Autowired
//	public void setDao(ContentDao dao) {
//		this.dao = dao;
//	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ArrayList<ContentDto> dtos = dao.listDao();
//		model.addAttribute("list", dtos);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String bId = request.getParameter("bId");
	      
		dao.upHit(bId);
		ContentDto content = dao.contentDao(request.getParameter("bId"));
		model.addAttribute("content_view", content);
		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		
		return "/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("bName"), request.getParameter("bTitle"),
				request.getParameter("bContent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view() {
		
		return "/view";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		ContentDto content = dao.contentDao(request.getParameter("bId"));
		model.addAttribute("reply_view", content);
		
		return "/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.replyShape(Integer.parseInt(request.getParameter("bGroup")), Integer.parseInt(request.getParameter("bStep")));
		dao.replyDao(request.getParameter("bName"), request.getParameter("bTitle"),
				request.getParameter("bContent"), Integer.parseInt(request.getParameter("bGroup")), Integer.parseInt(request.getParameter("bStep")+1), Integer.parseInt(request.getParameter("bIndent")+1));
		
		return "redirect:list";
	}
	
	   @RequestMapping("/modify")
	   public String modify(HttpServletRequest request, Model model) {   
	      IDao dao = sqlSession.getMapper(IDao.class);
	      String bName = request.getParameter("bName");
	      String bTitle = request.getParameter("bTitle");
	      String bContent = request.getParameter("bContent");
	      String bId = request.getParameter("bId");
	      
	      dao.modifyDao(bName, bTitle, bContent, bId);
	      ContentDto content = dao.contentDao(bId);
	      model.addAttribute("content_view", content);
	      
	      return "content_view";
	   }
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));
		return "redirect:list";
	}
	
}
