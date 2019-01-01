package project.spring.hohotest.controller.memberJoin;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberJoinOk {
	
	@RequestMapping("user/memberJoin/memberJoinOk.do")
	public ModelAndView doRun(Locale locale, Model model,
			@RequestParam(value="user_id", defaultValue="0") String user_id,
			@RequestParam(value="user_pw", defaultValue="0") String user_pw, 
			@RequestParam(value="user_pw_re", defaultValue="0") String user_pw_re,
			@RequestParam(value="name", defaultValue="0") String name,
			@RequestParam(value="gender", defaultValue="0") String gender,
			@RequestParam(value="birthdate", defaultValue="0") String birthdate,
			@RequestParam(value="tel", defaultValue="0") String tel,
			@RequestParam(value="postcode", defaultValue="0") String postcode,
			@RequestParam(value="addr1", defaultValue="0") String addr1,
			@RequestParam(value="addr2", defaultValue="0") String addr2,
			@RequestParam(value="email", defaultValue="0") String email)
			{
		
		model.addAttribute("user_id", user_id);
		model.addAttribute("user_pw", user_pw);
		model.addAttribute("user_pw_re", user_pw_re);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("birthdate", birthdate);
		model.addAttribute("tel", tel);
		model.addAttribute("postcode", postcode);
		model.addAttribute("addr1", addr1);
		model.addAttribute("addr2", addr2);
		model.addAttribute("email", email);
		
		return new ModelAndView("user/signUp/memberJoinOk");
	}
}
