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
import project.spring.hohotest.model.Product;
import project.spring.hohotest.model.Review;

@Controller
public class ProductViewController {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	//product, review service선언
	
	@RequestMapping(value= "user/taste/productView.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="id", defaultValue="0") int product_id,
			HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		/*if(product_id == 0) {
			web.redirect(null, "해당 제품을 찾아볼 수 없습니다.");
		}*/
		
		Product product = new Product();
		Review review = new Review();
		product.setId(product_id);
		review.setProduct_id(product_id);
		
		List<Review> reviewList = null;
		try {
			//product = productService.selectProductById(product);
			//reviewList = reviewService.selectReviewListByProductId(review);
		} catch(Exception e) {
			return web.redirect(null,e.getLocalizedMessage());
		}
		
		request.setAttribute("product", product);
		request.setAttribute("reviewList", reviewList);
		
		return new ModelAndView("user/taste/productView");
	}
}
