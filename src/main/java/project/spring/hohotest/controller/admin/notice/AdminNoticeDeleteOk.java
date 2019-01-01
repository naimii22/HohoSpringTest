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
public class AdminNoticeDeleteOk {
	/** Helper 객체 선언 */
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/admin/notice/adminNoticeDelete_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
	
		web.init();
		
		System.out.println("<<<adminNoticeDelete_ok.do로 들어옴>>>");
		
		/** 게시글 번호 받기 */
		int noticeId = web.getInt("notice_id");
		System.out.println("아이디: " + web.getInt("notice_id"));
		if (noticeId == 0) {
			return web.redirect(null, "글 번호가 없습니다.");
		}
		
		/** 파라미터를 Beans로 묶기 */	
		Notice notice = new Notice();
		notice.setId(noticeId);
			
		try {			
			noticeService.deleteNotice(notice);	// 게시글 삭제
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 페이지 이동 */
		String url = "%s/admin/notice/adminNoticeList.do";
		url = String.format(url, web.getRootPath());
		
		return web.redirect(url, "삭제되었습니다.");
	}
}
