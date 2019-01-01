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

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Notice;
import project.spring.hohotest.service.NoticeService;

@Controller
public class AdminNoticeUpdateController {
	/** Helper 객체 선언 */
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value="/admin/notice/adminNoticeUpdate.do")
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

		try {
			readNotice = noticeService.selectNotice(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** (7) 읽은 데이터를 View에게 전달한다. */
		model.addAttribute("readNotice", readNotice);
		
		return new ModelAndView("admin/notice/adminNoticeUpdate");
	}
}
