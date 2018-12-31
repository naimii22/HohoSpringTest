package project.spring.hohotest.controller.admin.member;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.service.MemberService;

@Controller
public class AdminMemberOk {
	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	private static Logger logger = LoggerFactory.getLogger(AdminMemberOk.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	UploadHelper upload;
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/admin/member/adminMember_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		web.init();

		/** (3) 회원정보 여부 검사 */
		// 회원정보가 없다면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("memberList") != null) {
			return web.redirect(web.getRootPath() + "/adminPage.do", "회원정보가 없습니다.");
		}

		/** (4) Member 객체 선언 */
		Member member = new Member();

		/** (6) Service를 통한 회원 인증 */
		List<Member> memberList = null;

		try {
			// 회원 정보 전체 저장
			memberList = memberService.selectAllMember(member);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** (7) 조회된 회원 정보를 모델에 저장 */
		// 
		// 리퀘스트에 보관하는 과정을 말한다.
		model.addAttribute("memberList",memberList);
	
		/** (9) 페이지 이동 */
		return new ModelAndView("admin/member/adminMemberList");
	}
}
