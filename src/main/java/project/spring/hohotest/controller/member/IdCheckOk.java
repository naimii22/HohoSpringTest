package project.spring.hohotest.controller.member;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.service.MemberService;

@Controller
public class IdCheckOk {
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import project.spring.hohotest.helper.WebHelper;
	@Autowired
	WebHelper web;
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value="/member/idCheck_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		web.init();
		
		/** (3) 파라미터 생성 */
		String userId = web.getString("user_id");
		String result = "OK";
		
		Member member = new Member();
		member.setUser_id(userId);
		
		/** (4) 아이디 중복체크*/
		try {
			memberService.selectUserIdCount(member);
		}catch(NullPointerException e){
			result = "FAIL";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("result", result);
		
		String url = "%s/user/signUp/memberJoin.do?result=%s";
		url = String.format(url, web.getRootPath(), result);
		
		return web.redirect(url, "중복체크 되었습니다.");
	}
}
