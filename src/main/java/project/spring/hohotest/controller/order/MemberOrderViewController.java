package project.spring.hohotest.controller.order;

import java.util.ArrayList;
import java.util.List;
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
import project.spring.hohotest.model.Orders;
import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.CartService;
import project.spring.hohotest.service.OrderService;
import project.spring.hohotest.service.ProductService;

@Controller
public class MemberOrderViewController {
	@Autowired
	WebHelper web;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	
	// http://localhost:8013/hohotest/user/order/memberOrderView.do?member_id=2&order_id=3
	@RequestMapping(value = "/user/order/memberOrderView.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		int member_id = web.getInt("member_id");
		int order_id = web.getInt("order_id");
		
		if(member_id == 0) {
			web.printJsonRt("회원번호가 없습니다.");
		} else if (order_id == 0) {
			web.printJsonRt("주문번호가 없습니다.");
		}
		System.out.println("<<<memberOrderView.do>>> 회원번호: " + member_id + ", 주문번호: " + order_id);
		
		List<Cart> cartList = new ArrayList<Cart>();
		Cart cart = new Cart();
		Orders order = new Orders();
		cart.setMember_id(member_id);
		cart.setOrder_id(order_id);
		order.setId(order_id);
		
		try {
			cartList = cartService.selectCartListByOrderId(cart);
			order = orderService.selectOrder(order);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());	
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
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("productList", productList);
		model.addAttribute("order", order);
		
		return new ModelAndView("user/order/memberOrderView");
	}
	
}
