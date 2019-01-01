package project.spring.hohotest.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewWriteController {
	
	@RequestMapping("/user/review/reviewWrite.do")
	public ModelAndView doRun() {
		
		return new ModelAndView("/user/review/reviewWrite");
	}
}
