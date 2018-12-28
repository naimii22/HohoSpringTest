package project.spring.hohotest.controller.hohostory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@RequestMapping("user/hohoStory/notice.do")
	public ModelAndView doRun() {
		logger.debug("notice is running...");
		
		return new ModelAndView("user/hohoStory/notice");
	}
}