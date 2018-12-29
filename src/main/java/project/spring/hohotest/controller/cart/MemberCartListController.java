package project.spring.hohotest.controller.cart;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Cart;

@Controller
public class MemberCartListController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberCartListController.class);
	@Autowired
	WebHelper web;
	
	@RequestMapping(value = "/user/cart/memberCartList.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		logger.debug("memberCartList is running...");
		
		Cart cart = new Cart();
		cart.setMember_id(1); // 임시, 세션 이용
		
		List<Cart> cartList = null;
		
		model.addAttribute("cartList", cartList);
		
		return new ModelAndView("user/cart/memberCartList");
	}
	
}
