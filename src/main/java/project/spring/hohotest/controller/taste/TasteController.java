package project.spring.hohotest.controller.taste;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.ProductService;

@Controller
public class TasteController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	ProductService productService;
	
/*	@RequestMapping(value = "user/taste/taste.do")
	public ModelAndView doRun(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		Product product = new Product();
		product.setType(1);
		
		List<Product> productList = null;
		try {
			productList = productService.selectProductListByType(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
		}
		
		request.setAttribute("productList", productList);

		return new ModelAndView("user/taste/taste");
	}*/

	///ajax.......
	@RequestMapping(value = "user/taste/taste.do")
	public ModelAndView doRun(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		

		return new ModelAndView("user/taste/tasteAjax");
	}
}
