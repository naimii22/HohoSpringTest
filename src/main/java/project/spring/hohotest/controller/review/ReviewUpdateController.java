package project.spring.hohotest.controller.review;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ReviewUpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value="/user/review/reviewUpdate.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="id", defaultValue="0") int review_id,
			@RequestParam(value="user_id", defaultValue="0") String user_id) {
		
		web.init();
		
		//로그인된 id와 작성자 id확인
		//Member loginInfo = (Member) web.getSession("loginInfo");
		 
		
		//로그인된 id와 확인
		//if (loginInfo.getUser_id() == user_id) {
			Review review = new Review();
			review.setId(review_id);
			
			try {
				review = reviewService.selectReviewById(review);
				logger.debug(review.toString());
			} catch (Exception e) {
				return web.redirect(null, e.getLocalizedMessage());
			}//try-catch
			
			model.addAttribute("review", review);
			
			return new ModelAndView("user/review/reviewUpdate");
			
		//}
		
		//return web.redirect(null, "수정불가능한 게시물입니다.");
	}
}
