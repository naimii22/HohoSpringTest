package project.spring.hohotest.controller.hohostory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HohoMapController {
	
	private static final Logger logger = LoggerFactory.getLogger(HohoMapController.class);
	
	@RequestMapping("user/hohoStory/hohoMap.do")
	public ModelAndView doRun() {
		logger.debug("hohoMap is running...");
		
		return new ModelAndView("user/hohoStory/hohoMap");
	}
}
