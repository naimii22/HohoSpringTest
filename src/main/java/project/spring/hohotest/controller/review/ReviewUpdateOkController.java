package project.spring.hohotest.controller.review;

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

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ReviewUpdateOkController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	UploadHelper upload;
	@Autowired
	ReviewService reviewService;
	
/*	@RequestMapping(value="/user/review/reviewUpdateOk.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		try {
			upload.multipartRequest();
		} catch (Exception e) {
			return web.redirect(null, "multipart 데이터가 아닙니다.");
		}
		
		Map<String, String> paramMap = upload.getParamMap();
		
	}*/
}
