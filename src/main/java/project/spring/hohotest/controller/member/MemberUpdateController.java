package project.spring.hohotest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberUpdateController {
private static final Logger logger = LoggerFactory.getLogger(MemberUpdateController.class);
	
	@RequestMapping("user/signUp/memberUpdate.do")
	public ModelAndView doRun() {
		logger.debug("MemberUpdate is running...");
		
		return new ModelAndView("user/member/memberUpdate");
	}
}

