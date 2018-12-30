package project.spring.hohotest.controller.admin.notice;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminNoticeListController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeListController.class);
	
	@RequestMapping("admin/notice/adminNoticeList.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("adminNoticeList is running...");
		
		return new ModelAndView("admin/notice/adminNoticeList");
	}
	
	// /admin/notice/adminNoticeWrite_ok.do
	// /admin/notice/adminNoticUpdate_ok.do
}