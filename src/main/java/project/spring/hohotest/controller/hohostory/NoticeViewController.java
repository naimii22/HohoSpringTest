package project.spring.hohotest.controller.hohostory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeViewController.class);
	
	@RequestMapping("user/hohoStory/noticeView.do")
	public ModelAndView doRun() {
		logger.debug("noticeView is running...");
		
		return new ModelAndView("user/hohoStory/noticeView");
	}
}
