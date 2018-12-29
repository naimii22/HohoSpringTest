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
import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.CartService;
//import project.spring.hohotest.service.ProductService;

@Controller
public class MemberCartListController {
	@Autowired
	WebHelper web;
	@Autowired
	CartService cartService;
	@Autowired
	//ProductService productService;
	
	@RequestMapping(value = "/user/cart/memberCartList.do")
	public ModelAndView doRun(/*Locale locale, Model model, HttpServletRequest request, HttpServletResponse response*/) {
		/*web.init();
		
		Cart cart = new Cart();
		cart.setMember_id(1); // 임시, 세션 이용
		
		List<Cart> cartList = null;
		try {
			cartList = cartService.selectCartList(cart);
		} catch(Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		List<Product> productList = null;
		Product product = new Product();
		
		if(cartList != null) {
			for(Cart c : cartList) {
				product.setId(c.getProduct_id());
				
				try {
					product = productService.selectProduct(product);
					productList.add(product);
				} catch (Exception e) {
					return web.redirect(null, e.getLocalizedMessage());
				}
			}
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("productList", productList);*/
		
		return new ModelAndView("user/cart/memberCartList");
	}
	
}
