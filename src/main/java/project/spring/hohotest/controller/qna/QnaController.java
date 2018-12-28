package project.spring.hohotest.controller.qna;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QnaController {
	
	/*private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@RequestMapping(value = "/user/qna/qna.do", method = RequestMethod.GET)
	public String Home(Locale locale, Model model) {
		logger.debug("qna is running...");
		return "user/qna/qna";
	}*/
	
	@RequestMapping(value = "/user/qna/qna.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("user/qna/qna");
	}
	
}
