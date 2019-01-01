package project.spring.hohotest.controller.cart;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Cart;
import project.spring.hohotest.service.CartService;

@Controller
public class MemberCartDeleteOkController {
	
	@Autowired
	WebHelper web;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	CartService cartService;
	
	@RequestMapping(value= "/user/cart/memberCartDeleteOk.do")
	public void doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		web.init();
		System.out.println("<<<memberCartDeleteOk.do로 들어옴>>>");
		
		int id = web.getInt("id");
		if (id == 0) {
			web.printJsonRt("카트번호가 없습니다.");
		}
		
		Cart cart = new Cart();
		cart.setId(id);
		
		try {
			cartService.deleteCart(cart);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("id", id);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());	
		}
	}
}
