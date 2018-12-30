package project.spring.hohotest.controller.hohostory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.PageHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Notice;
import project.spring.hohotest.service.NoticeService;

@Controller
public class NoticeController {
	
//	@Autowired
//	WebHelper web;
//	@Autowired
//	Notice notice;
//	@Autowired
//	NoticeService noticeService;
//	@Autowired
//	PageHelper pageHelper;

	@RequestMapping(value="/user/hohoStory/notice.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		/*web.init();

		int page = web.getInt("page", 1);
		int totalCount = 0;
		int maxPageNo;
		List<Notice> noticeList = null;
		
		try {
			// 전체 게시물 수
			totalCount = noticeService.selectNoticeCount(notice);
			
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 12, 5);

			// 페이지 번호 계산 결과에서 Limit절에 필요한 값을 Beans에 추가
			notice.setLimitStart(pageHelper.getLimitStart());
			notice.setListCount(pageHelper.getListCount());
			
			noticeList = noticeService.selectNoticeList(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		maxPageNo = pageHelper.getTotalCount() - (pageHelper.getPage() - 1)
				* pageHelper.getListCount();

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageHelper", pageHelper);
		model.addAttribute("maxPageNo", maxPageNo);*/

		// noticeList, pageHelper, maxPageNo addAttribute함
		return new ModelAndView("user/hohoStory/notice");
	}
}