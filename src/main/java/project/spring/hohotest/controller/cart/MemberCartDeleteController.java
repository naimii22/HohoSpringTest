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
		System.out.println("<<<memberCartDelete.do로 들어옴>>>");
		
		int id = web.getInt("id");
		if (id == 0) {
			web.printJsonRt("카트번호가 없습니다.");
		}
		System.out.println("갸져온 카트 아이디: " + web.getInt("id"));
		
		Cart cart = new Cart();
		cart.setId(id);
		
//		model.addAttribute("id", id);
		request.setAttribute("id", id);
		
		return new ModelAndView("/user/cart/memberCartDelete");
	}
}
