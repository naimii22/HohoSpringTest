package project.spring.hohotest.controller.hohostory;

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
public class NoticeViewController {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	RegexHelper regex;
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value="/user/hohostory/noticeView.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		web.init();

		/** 글 번호 파라미터 받기 */
		int noticeId = web.getInt("notice_id");
		model.addAttribute("noticeId", noticeId);
		if (noticeId == 0) {
			return web.redirect(null, "글 번호가 지정되지 않았습니다.");
		}

		// 파라미터를 Beans로 묶기
		Notice notice = new Notice();
		notice.setId(noticeId);

		/** 게시물 일련번호를 사용한 데이터 조회 */
		// 지금 읽고 있는 게시물이 저장될 객체
		Notice readNotice = null;
		// 이전글이 저장될 객체
		Notice prevNotice = null;
		// 다음글이 저장될 객체
		Notice nextNotice = null;

		try {
			noticeService.updateNoticeHit(notice);
			readNotice = noticeService.selectNotice(notice);
			prevNotice = noticeService.selectPrevNotice(notice);
			nextNotice = noticeService.selectNextNotice(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());	
		}

		model.addAttribute("readNotice", readNotice);
		model.addAttribute("prevNotice", prevNotice);
		model.addAttribute("nextNotice", nextNotice);

		return new ModelAndView("user/hohostory/noticeView");
	}
}
