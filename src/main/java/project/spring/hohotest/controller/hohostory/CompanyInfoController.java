package project.spring.hohotest.controller.hohostory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;

@Controller
public class CompanyInfoController {

	@Autowired
	WebHelper web;
	
	Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);
	
	@RequestMapping(value = "/user/hohoStory/companyInfo.do", method = RequestMethod.GET)
	public ModelAndView doRun(Local local, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("companyInfo is running...");
		web.init();
		
		return new ModelAndView("user/hohoStory/companyInfo");
	}
}