package project.spring.hohotest.controller.review;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ReviewDeleteOkController {
	
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	WebHelper web;
	@Autowired
	ReviewService reviewService;
	
	//삭제 후 productView로 가기
	@RequestMapping(value="/user/review/reviewDeleteOk.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="review_id", defaultValue="0") int review_id,
			@RequestParam(value="user_id", defaultValue="0") String user_id,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		
		web.init();
		
		//로그인된 id와 작성자 id확인
		//Member loginInfo = (Member) web.getSession("loginInfo");
		 
		Review review = new Review();
		int productId = 0;
		//로그인된 id와 확인
		//if (loginInfo.getUser_id() == user_id) {
			review.setId(review_id);
			try {
				review = reviewService.selectReviewById(review);
				productId = review.getProduct_id();
				reviewService.deleteReview(review);
			} catch (Exception e) {
				
			}
		//}
/*		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);*/
		
		String url = "%s/user/taste/productView.do?id=%s";
		url = String.format(url, web.getRootPath(), productId);
		return web.redirect(url, null);
	}
}
