package project.spring.hohotest.controller.taste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TasteController {

	@RequestMapping(value = "user/taste/taste.do")
	public ModelAndView doRun() {
		
		return new ModelAndView("user/taste/taste");
	}
}
