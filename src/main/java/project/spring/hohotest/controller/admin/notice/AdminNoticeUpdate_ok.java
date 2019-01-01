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
public class AdminNoticeUpdate_ok {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	RegexHelper regex;
	@Autowired
	NoticeService bbsDocumentService;
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value="/admin/notice/adminNoticeUpdate_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		/** 파라미터 받기 */
		int noticeId = web.getInt("notice_id");
		String title = web.getString("title");
		String content = web.getString("content");

		/** 입력 받은 파라미터에 대한 유효성 검사 */
		// 제목 및 내용 검사
		if (!regex.isValue(title)) {
			return web.redirect(null, "글 제목을 입력하세요.");
		}

		if (!regex.isValue(content)) {
			return web.redirect(null, "내용을 입력하세요.");
		}

		/** 입력 받은 파라미터를 Beans로 묶기 */
		Notice notice = new Notice();
		// UPDATE문의 WHERE절에서 사용해야 하므로 글 번호 추가
		notice.setId(noticeId);
		notice.setTitle(title);
		notice.setContent(content);

		/** 게시물 변경을 위한 Service 기능을 호출 */
		try {
			noticeService.updateNotice(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		String url = "%s/admin/notice/adminNoticeView.do?notice_id=%d";
		url = String.format(url, web.getRootPath(), noticeId);
		
		return web.redirect(url, null);
	}
}