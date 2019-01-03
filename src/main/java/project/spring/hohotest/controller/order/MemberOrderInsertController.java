package project.spring.hohotest.controller.order;

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
import project.spring.hohotest.service.CartService;
import project.spring.hohotest.service.OrderService;

@Controller
public class MemberOrderInsertController {
	@Autowired
	WebHelper web;
	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/user/order/memberOrderInsert.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		int member_id = web.getInt("member_id");
		int total = web.getInt("total");
		
		Orders order = new Orders();
		order.setMember_id(member_id);
		order.setTotal(total);
		
		try {
			orderService.insertOrder(order);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		int order_id = order.getId();
		Cart cart = new Cart();
		cart.setMember_id(member_id);
		cart.setOrder_id(order_id);
		
		try {
			cartService.updateCartOrderId(cart);
		} catch(Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		System.out.println("<<<memberOrderInsert.do>>> 결제된 주문번호: " + order_id);
		
		String url = "%s/user/order/memberOrderView.do?member_id=%d&order_id=%d";
		url = String.format(url, web.getRootPath(), member_id, order_id);
		return web.redirect(url, null);
		
		/*request.setAttribute("order_id", order_id);
		return new ModelAndView("/user/order/memberOrderInsert");*/
	}
}
