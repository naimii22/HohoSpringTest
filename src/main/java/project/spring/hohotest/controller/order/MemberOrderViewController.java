package project.spring.hohotest.controller.order;

import java.util.ArrayList;
import java.util.List;
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
import project.spring.hohotest.model.Orders;
import project.spring.hohotest.service.OrderService;

@Controller
public class MemberOrderViewController {
	@Autowired
	WebHelper web;
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/user/order/memberOrderView.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		int order_id = web.getInt("order_id");
		if (order_id == 0) {
			web.printJsonRt("제품번호가 없습니다.");
		}
		System.out.println("<<<memberOrderView.do>>> 보러갈 주문번호: " + order_id);

		Orders order = new Orders();
		order.setId(order_id);
		
		List<Cart> cartList = new ArrayList<Cart>();
		
		try {
			order = orderService.selectOrder(order);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());	
		}
		
		model.addAttribute("order", order);
		
		return new ModelAndView("user/order/memberOrderView");
	}
	
}
