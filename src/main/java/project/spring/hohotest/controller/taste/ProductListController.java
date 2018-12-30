package project.spring.hohotest.controller.taste;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Product;

@Controller
public class ProductListController {

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	//@Autowired
	//ProductService productService;

	@RequestMapping(value = "user/taste/productList.do")
	public void doRun(Locale locale, 
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="type", defaultValue="1") int type) {
		response.setContentType("application/json");
		
		web.init();
		
		logger.debug("type : " + type);
		
		//sqlsession = type에 해당하는 productList들을 다 가져옴.
		Product product = new Product();
		product.setType(type);
		
		List<Product> productList = null;
		try {
			//productList = productService.selectProductListByType(product);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "ok");
		//data.put("productList", productList);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());	
		}
		
	}
}
