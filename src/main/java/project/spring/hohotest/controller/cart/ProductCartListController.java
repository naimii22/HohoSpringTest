package project.spring.hohotest.controller.cart;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCartListController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductCartListController.class);
	
	@RequestMapping(value = "/user/cart/productCartList.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("productCartList is running...");
		
		return new ModelAndView("user/cart/productCartList");
	}
	
}
