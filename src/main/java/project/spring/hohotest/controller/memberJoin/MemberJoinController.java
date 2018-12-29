package project.spring.hohotest.controller.memberJoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;

@Controller
public class MemberJoinController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	
	@RequestMapping("user/signUp/memberJoin.do")
	public ModelAndView doRun() {
		logger.debug("MemberJoin is running...");
		
		return new ModelAndView("user/signUp/memberJoin");
	}
}
