package project.spring.hohotest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberDeleteController {
private static final Logger logger = LoggerFactory.getLogger(MemberDeleteController.class);
	
	@RequestMapping("user/member/memberDelete.do")
	public ModelAndView doRun() {
		logger.debug("MemberDelete is running...");
		
		return new ModelAndView("user/member/memberDelete");
	}
}
