package project.spring.hohotest.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class loginController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	
	@RequestMapping("user/login/login.do")
	public ModelAndView doRun() {
		logger.debug("login is running...");
		
		return new ModelAndView("user/login/login");
	}
}
