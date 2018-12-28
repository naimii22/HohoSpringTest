package project.spring.hohotest.controller.hohostory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(StaffInfoController.class);
	
	@RequestMapping("user/hohoStory/staffInfo.do")
	public ModelAndView doRun(Local local, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("staffInfo is running...");
		
		return new ModelAndView("user/hohoStory/staffInfo");
	}
}
