package project.spring.hohotest.controller.hohostory;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@Autowired
	WebHelper web;
	@Autowired
	NoticeService noticeService;
	@Autowired
	PageHelper pageHelper;

	@RequestMapping(value="/user/hohostory/notice.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		int maxPageNo = 0;
		List<Notice> noticeList = null;
		Notice notice = new Notice();
		
		
		try {
			totalCount = noticeService.selectNoticeCount(notice);

			pageHelper.pageProcess(page, totalCount, 12, 5);

			notice.setLimitStart(pageHelper.getLimitStart());
			notice.setListCount(pageHelper.getListCount());
			
			noticeList = noticeService.selectNoticeList(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		maxPageNo = pageHelper.getTotalCount() - (pageHelper.getPage() - 1)	* pageHelper.getListCount();

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageHelper", pageHelper);
		model.addAttribute("maxPageNo", maxPageNo);

		return new ModelAndView("user/hohostory/notice");
	}
}