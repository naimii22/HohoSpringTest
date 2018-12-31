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
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	RegexHelper regex;
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("user/hohoStory/noticeView.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		web.init();

		/** (5) 글 번호 파라미터 받기 */
		int noticeId = web.getInt("notice_id");
		if (noticeId == 0) {
			return web.redirect(null, "글 번호가 지정되지 않았습니다.");
		}

		// 파라미터를 Beans로 묶기
		Notice notice = new Notice();
		notice.setId(noticeId);

		/** (6) 게시물 일련번호를 사용한 데이터 조회 */
		// 지금 읽고 있는 게시물이 저장될 객체
		Notice readNotice = null;
		// 이전글이 저장될 객체
		Notice prevNotice = null;
		// 다음글이 저장될 객체
		Notice nextNotice = null;

		/** 조회수 중복 갱신 방지 처리 */
		// 카테고리와 게시물 일련번호를 조합한 문자열을 생성
		// ex) document_notice_15
		String cookieKey = "notice_" + noticeId;
		// 준비한 문자열에 대응되는 쿠키값 조회
		String cookieVar = web.getCookie(cookieKey);

		try {
			// 쿠키값이 없다면 조회수 갱신
			if (cookieVar == null) {
				noticeService.updateNotice(notice);
				// 준비한 문자열에 대한 쿠키를 24시간동안 저장
				web.setCookie(cookieKey, "Y", 60 * 60 * 24);
			}
			readNotice = noticeService.selectNotice(notice);
			prevNotice = noticeService.selectPrevNotice(notice);
			nextNotice = noticeService.selectNextNotice(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());	
		}

		/** (7) 읽은 데이터를 View에게 전달한다. */
		model.addAttribute("readNotice", readNotice);
		model.addAttribute("prevNotice", prevNotice);
		model.addAttribute("nextNotice", nextNotice);

		return new ModelAndView("user/hohoStory/noticeView");
	}
}
