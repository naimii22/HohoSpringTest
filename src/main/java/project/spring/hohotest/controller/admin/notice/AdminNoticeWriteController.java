package project.spring.hohotest.controller.admin.notice;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminNoticeWriteController {

	@RequestMapping(value = "/admin/notice/AdminNoticeWrite.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("admin/notice/AdminNoticeWrite");
	}
}
