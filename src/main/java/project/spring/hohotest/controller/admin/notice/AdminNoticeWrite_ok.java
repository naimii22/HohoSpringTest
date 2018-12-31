package project.spring.hohotest.controller.admin.notice;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.RegexHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Notice;
import project.spring.hohotest.service.NoticeService;

@Controller
public class AdminNoticeWrite_ok {
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	RegexHelper regex;
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/admin/notice/adminNoticeWrite_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
	
		web.init();

		/** 파라미터 받기 */
		String title = web.getString("title");
		String content = web.getString("content");

		model.addAttribute("title", title);
		model.addAttribute("content", content);

		/** 게시판 카테고리 값을 받아서 View에 전달 */
		// 파일이 첨부된 경우 WebHelper를 사용할 수 없다.
		// String category = web.getString("category");

		/** 입력 받은 파라미터를 Beans로 묶기 */
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);

		/** Service를 통한 게시물 저장 */
		try {
			noticeService.insertNotice(notice);
				
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 저장 완료 후 읽기 페이지로 이동하기 */
		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/admin/notice/adminNoticeView.do?notice_id=%d";
		url = String.format(url, web.getRootPath(), notice.getId());
	
		return web.redirect(url, null);
	}
}