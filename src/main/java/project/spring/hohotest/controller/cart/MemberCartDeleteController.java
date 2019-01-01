package project.spring.hohotest.controller.cart;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Cart;

@Controller
public class MemberCartDeleteController {
	@Autowired
	WebHelper web;
	
	@RequestMapping(value = "/user/cart/memberCartDelete.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		int product_id = web.getInt("product_id");
		if (product_id == 0) {
			web.printJsonRt("제품번호가 없습니다.");
		}
		
		System.out.println("<<<memberCartDelete.do>>> 가져온 삭제할 제품 아이디: " + product_id);
		request.setAttribute("product_id", product_id);
		
		return new ModelAndView("/user/cart/memberCartDelete");
	}
}
