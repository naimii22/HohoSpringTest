package project.spring.hohotest.controller.review;

import java.util.List;
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
import project.spring.hohotest.model.Comment;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ReviewViewController {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value="user/review/reviewView.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="id", defaultValue="0") int review_id,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		System.out.println("review_id=" + review_id + "& user_id=" + user_id);
		if(review_id == 0) {
			web.redirect(null, "해당 제품을 찾아볼 수 없습니다.");
		}
		
		Review review = new Review();
		Comment comment = new Comment();
		review.setId(review_id);
		comment.setReview_id(review_id);
		
		List<Comment> commentList = null;
		try {
			//hit업데이트 시키기
			review = reviewService.selectReviewById(review);
			
			int hit = review.getHit() + 1;
			
			review.setHit(hit);
			reviewService.updateReviewHit(review);
			review = reviewService.selectReviewById(review);//hit업데이트 후 다시 넣기
			//commentList = commentService.selectCommentListByReviewId(comment);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		request.setAttribute("review", review);
		request.setAttribute("commentList", commentList);
		request.setAttribute("user_id", user_id);
		
		return new ModelAndView("user/review/reviewView");
	}
}
