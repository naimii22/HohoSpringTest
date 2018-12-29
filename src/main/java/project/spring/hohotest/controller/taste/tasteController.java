package project.spring.hohotest.controller.taste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;

@Controller
public class tasteController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	
	@RequestMapping("user/taste/taste.do")
	public ModelAndView doRun() {
		logger.debug("ProductList is running...");

		return new ModelAndView("user/taste/taste");
	}

}
