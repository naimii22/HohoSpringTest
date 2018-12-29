package project.spring.hohotest.controller.taste;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.WebHelper;

@Controller
public class ProductListController {

	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	

	@RequestMapping("user/taste/productList.do")
	public void doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		web.init();
		
		int type = web.getInt("data", 1); //1케이크,2빵,3음료
		logger.debug("type : " + type);
		
		//sqlsession = type에 해당하는 productList들을 다 가져옴.
		
		// 줄바꿈이나 HTML특수문자에 대한 처리
		/*for (int i=0; i<item.size(); i++) {
			BbsComment temp = item.get(i);
			temp.setWriterName(web.convertHtmlTag(temp.getWriterName()));
			temp.setEmail(web.convertHtmlTag(temp.getEmail()));
			temp.setContent(web.convertHtmlTag(temp.getContent()));
		}*/
		
		Map<String, Object> data = new HashMap<String, Object>();
		//data.put("rt", "ok");
		//data.put("productList", productList);
		
		/*ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());	
		}*/
		
	}
}
