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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value= "/user/cart/memberCartDeleteOk.do")
	public void doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		web.init();
		
		int product_id = web.getInt("product_id");
		if (product_id == 0) {
			web.printJsonRt("제품번호가 없습니다.");
		}
		System.out.println("<<<memberCartDeleteOk.do>>> 가져온 삭제할 제품 아이디: " + product_id);
		
		Cart cart = new Cart();
		cart.setProduct_id(product_id);
		
		try {
			cartService.deleteCart(cart);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("product_id", product_id);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());	
		}
	}
}
