package project.spring.hohotest.controller.review;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;

@Controller
public class ReviewWriteController {
	
	@Autowired
	WebHelper web;
	
	@RequestMapping("/user/review/reviewWrite.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="product_id", defaultValue="0") int product_id) {
		
/*		Member loginInfo = (Member) web.getSession("loginInfo");
		if (loginInfo != null) {
*/
			model.addAttribute("product_id", product_id);
			return new ModelAndView("/user/review/reviewWrite");
/*		}*/
		
		
		//로그인 안햇을 경우 상품상세페이지로 돌아가기 왜 안돼
		/*String url = "%s/user/taste/productView.do?id=%d";
		url = String.format(url, web.getRootPath(), product_id);
		return web.redirect(url, "로그인 후 이용가능합니다.");*/
	}
}
