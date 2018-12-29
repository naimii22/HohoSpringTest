package project.spring.hohotest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberViewController {
private static final Logger logger = LoggerFactory.getLogger(MemberViewController.class);
	
	@RequestMapping("user/signUp/memberView.do")
	public ModelAndView doRun() {
		logger.debug("MemberView is running...");
		
		return new ModelAndView("user/member/memberView");
	}
}
