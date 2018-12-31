package project.spring.hohotest.controller.cart;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Cart;
import project.spring.hohotest.service.CartService;

@Controller
public class MemberCartDeleteController {
	@Autowired
	WebHelper web;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/user/cart/memberCartDelete.do")
	public void doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		System.out.println("<<<카트딜리트로 들어옴>>>");
		
		int cartId = web.getInt("cartId");
		if (cartId == 0) {
			web.printJsonRt("카트번호가 없습니다.");
		}
		System.out.println("갸져온 카트 아이디: " + web.getInt("id"));
		
		Cart cart = new Cart();
		cart.setId(web.getInt("id"));
		
		try {
			cartService.deleteCart(cart);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		System.out.println("<<<카트 딜리트함>>>");
		
//		return new ModelAndView("/user/cart/memberCartDelete");
	}
}
