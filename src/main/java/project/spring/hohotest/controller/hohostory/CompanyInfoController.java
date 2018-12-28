package project.spring.hohotest.controller.hohostory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HohoMapController.class);

	@RequestMapping("user/hohoStory/companyInfo.do")
	public String doRun() {
		logger.debug("companyInfo is running...");
		
		return "user/hohoStory/companyInfo";
	}
}