package project.spring.hohotest.controller.review;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewDeleteController {
	
	@RequestMapping(value="/user/review/reviewDelete.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="id", defaultValue="0") int review_id,
			@RequestParam(value="user_id", defaultValue="0") String user_id) {
		
		model.addAttribute("review_id", review_id);
		model.addAttribute("user_id", user_id);
		return new ModelAndView("user/review/reviewDelete");
	}
}
