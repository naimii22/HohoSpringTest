package project.spring.hohotest.controller.admin.notice;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.FileInfo;
import project.spring.hohotest.helper.RegexHelper;
import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
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
		int noticeId = web.getInt("notice_id");
		String noticeTitle = web.getString("notice_title");
		String noticeContent = web.getString("notice_content");

		model.addAttribute("noticeId", noticeId);
		model.addAttribute("noticeTitle", noticeTitle);
		model.addAttribute("noticeContent", noticeContent);

		/** (4) UploadHelper에서 텍스트 형식의 값을 추출 */
//		Map<String, String> paramMap = upload.getParamMap();
//		String title = paramMap.get("title");
//		String content = paramMap.get("content");
//
//		// 전달된 파라미터는 로그로 확인한다.
//		logger.debug("title=" + title);
//		logger.debug("content=" + content);
//
//		/** (5) 게시판 카테고리 값을 받아서 View에 전달 */
//		// 파일이 첨부된 경우 WebHelper를 사용할 수 없다.
//		// String category = web.getString("category");
//
//		/** (7) 입력 받은 파라미터에 대한 유효성 검사 */
//		// 제목 및 내용 검사
//		if (!regex.isValue(title)) {
//			return web.redirect(null, "글 제목을 입력하세요.");
//		}
//
//		if (!regex.isValue(content)) {
//			return web.redirect(null, "내용을 입력하세요.");
//		}
//
//		/** (8) 입력 받은 파라미터를 Beans로 묶기 */
//		Notice notice = new Notice();
//		notice.setTitle(title);
//		notice.setContent(content);
//		logger.debug("notice >> " + notice.toString());
//
//		/** (9) Service를 통한 게시물 저장 */
//		try {
//				notice.setTitle(title);
//				noticeService.insertNotice(notice);
//				
//		} catch (Exception e) {
//			return web.redirect(null, e.getLocalizedMessage());
//		}
//		
//		/** 저장 완료 후 읽기 페이지로 이동하기 */
//		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
//		String url = "%s/admin/notice/adminNoticeView.do?notice_id=%d";
//		url = String.format(url, web.getRootPath(), notice.getId());
///	
//		return web.redirect(url, null);
		
		return null;
	}
}
