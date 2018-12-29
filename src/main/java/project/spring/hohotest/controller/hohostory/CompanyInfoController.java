package project.spring.hohotest.controller.hohostory;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HohoMapController.class);

	@RequestMapping("user/hohoStory/companyInfo.do")
	public String doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("companyInfo is running...");
		
		return "user/hohoStory/companyInfo";
	}
}