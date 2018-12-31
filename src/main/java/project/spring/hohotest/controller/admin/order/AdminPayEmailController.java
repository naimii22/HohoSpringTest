package project.spring.hohotest.controller.admin.order;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPayEmailController {

	private static final Logger logger = LoggerFactory.getLogger(AdminPayEmailController.class);

	@RequestMapping("admin/order/adminPayEmail.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("adminPayEmail is running...");
		
		return new ModelAndView("admin/order/adminPayEmail");
	}
}
