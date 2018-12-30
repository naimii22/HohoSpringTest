package project.spring.hohotest.controller.taste;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.model.Product;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.MemberService;
import project.spring.hohotest.service.ProductService;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ProductViewController {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	ProductService productService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	MemberService memberService;
	//product, review,member service선언
	
	@RequestMapping(value= "user/taste/productView.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="id", defaultValue="0") int product_id,
			HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		if(product_id == 0) {
			web.redirect(null, "해당 제품을 찾아볼 수 없습니다.");
		}
		
		Product product = new Product();
		Review review = new Review();
		product.setId(product_id);
		review.setProduct_id(product_id);
		
		List<Review> reviewList = null;
		try {
			product = productService.selectProduct(product);
			reviewList = reviewService.selectReviewListByProductId(review);
		} catch(Exception e) {
			return web.redirect(null,e.getLocalizedMessage());
		}
		
		List<Member> memberList = null;
		for(Review reviews : reviewList) {
			Member member = new Member();
			int member_id = reviews.getMember_id();
			
			member.setId(member_id);
			
			try {
				member = memberService.selectMember(member);
			} catch (Exception e) {
				return web.redirect(null, e.getLocalizedMessage());
			}
			
			memberList.add(member);
		}//for
		
		request.setAttribute("product", product);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("memberList", memberList);
		
		return new ModelAndView("user/taste/productView");
	}
}
