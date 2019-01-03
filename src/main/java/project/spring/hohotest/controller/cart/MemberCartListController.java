package project.spring.hohotest.controller.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Cart;
import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.CartService;
import project.spring.hohotest.service.ProductService;

@Controller
public class MemberCartListController {
	@Autowired
	WebHelper web;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	
	@ResponseBody
	@RequestMapping(value = "/user/cart/memberCartList.do")
	public void doRun(Locale locale, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="data", defaultValue="2") int member_id) {
		
		response.setContentType("application/json");
		web.init();
		System.out.println("<<<memberCartList.do>>>");
		
		Cart cart = new Cart();
		cart.setMember_id(member_id); // 나중에는 세션 이용
		
		List<Cart> cartList = new ArrayList<Cart>();
		try {
			cartList = cartService.selectCartList(cart);
		} catch(Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		if(cartList != null) {
			for(Cart c : cartList) {
				product.setId(c.getProduct_id());
				
				try {
					product = productService.selectProduct(product);
				} catch (Exception e) {
					web.printJsonRt(e.getLocalizedMessage());
				}
				
				productList.add(product);
			}
		}
		
		/* 줄바꿈이나 HTML특수문자에 대한 처리
		for (Product p : productList) {
			p.setName(web.convertHtmlTag(product.getName()));
			p.setImage(web.convertHtmlTag(product.getImage()));
			p.setInfo(web.convertHtmlTag(product.getInfo()));
		}*/
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("productList", productList);
		data.put("cartList", cartList);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());	
		}
	}
	
}
