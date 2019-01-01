package project.spring.hohotest.controller.member;

import java.util.Locale;
import java.util.Map;

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

import project.spring.hohotest.helper.RegexHelper;
import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.service.MemberService;

@Controller
public class JoinOk {
	
	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	// --> import org.apache.ibatis.session.SqlSession;
	private static Logger logger = LoggerFactory.getLogger(JoinOk.class);
	@Autowired
	SqlSession sqlSession;
	// --> import project.spring.hohotest.helper.WebHelper;
	@Autowired
	WebHelper web;
	// --> import project.spring.hohotest.helper.RegexHelper;
	@Autowired
	RegexHelper regex;
	// --> import project.spring.hohotest.helper.UploadHelper;
	@Autowired
	UploadHelper upload;
	// --> import study.jsp.mysite.service.MemberService;
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/member/join_ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		
		web.init();
		
		/** (3) 로그인 여부 검사 */
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") != null) {
			return web.redirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
		}


		// UploadHelper에서 텍스트 형식의 파라미터를 분류한 Map을 리턴받아서 값을 추출한다.
		
				String userId = web.getString("user_id");
				String userPw = web.getString("user_pw");
				String userPwRe = web.getString("user_pw_re");
				String name = web.getString("name");
				String email = web.getString("email");
				String tel = web.getString("tel");
				String birthdate = web.getString("birthdate");
				String gender = web.getString("gender");
				String postcode = web.getString("postcode");
				String addr1 = web.getString("addr1");
				String addr2 = web.getString("addr2");

				// 전달받은 파라미터는 값의 정상여부 확인을 위해서 로그로 확인
				logger.debug("userId=" + userId);
				logger.debug("userPw=" + userPw);
				logger.debug("userPwRe=" + userPwRe);
				logger.debug("name=" + name);
				logger.debug("email=" + email);
				logger.debug("tel=" + tel);
				logger.debug("birthdate=" + birthdate);
				logger.debug("gender=" + gender);
				logger.debug("postcode=" + postcode);
				logger.debug("addr1=" + addr1);
				logger.debug("addr2=" + addr2);
		
		/** (5) 입력값의 유효성 검사 */
		// 아이디 검사
		if (!regex.isValue(userId)) {
			return web.redirect(null, "아이디를 입력하세요.");
		}

		if (!regex.isEngNum(userId)) {
			return web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
		}

		if (userId.length() > 20) {
			return web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
		}

		// 비밀번호 검사
		if (!regex.isValue(userPw)) {
			return web.redirect(null, "비밀번호를 입력하세요.");
		}

		if (!regex.isEngNum(userPw)) {
			return web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
		}

		if (userPw.length() > 20) {
			return web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
		}

		// 비밀번호 확인
		if (!userPw.equals(userPwRe)) {
			return web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
		}

		// 이름 검사
		if (!regex.isValue(name)) {
			return web.redirect(null, "이름을 입력하세요.");
		}

		if (!regex.isKor(name)) {
			return web.redirect(null, "이름은 한글만 입력 가능합니다.");
		}

		if (name.length() < 2 || name.length() > 5) {
			return web.redirect(null, "이름은 2~5글자 까지만 가능합니다.");
		}

		// 이메일 검사
		if (!regex.isValue(email)) {
			return web.redirect(null, "이메일을 입력하세요.");
		}

		if (!regex.isEmail(email)) {
			return web.redirect(null, "이메일의 형식이 잘못되었습니다.");
		}

		// 연락처 검사
		if (!regex.isValue(tel)) {
			return web.redirect(null, "연락처를 입력하세요.");
		}

		if (!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			return web.redirect(null, "연락처의 형식이 잘못되었습니다.");
		}

		// 생년월일 검사
		if (!regex.isValue(birthdate)) {
			return web.redirect(null, "생년월일을 입력하세요.");
		}

		// 성별검사
		if (!regex.isValue(gender)) {
			return web.redirect(null, "성별을 입력하세요.");
		}

		if (!gender.equals("M") && !gender.equals("F")) {
			return web.redirect(null, "성별이 잘못되었습니다.");
		}


		/** (7) 전달받은 파라미터를 Beans 객체에 담는다. */
		Member member = new Member();
		member.setUser_id(userId);
		member.setUser_pw(userPwRe);
		member.setName(name);
		member.setEmail(email);
		member.setTel(tel);
		member.setBirthdate(birthdate);
		member.setGender(gender);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);

		/** (8) Service를 통한 데이터베이스 저장 처리 */
		try {
			memberService.insertMember(member);
		} catch (Exception e) {
			// 예외가 발생한 경우이므로, 더이상 진행하지 않는다.
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** (9) 가입이 완료되었으므로 메인페이지로 이동 */
		// INSERT,UPDATE,DELETE 처리를 수행하는 action 페이지들은
		// 자체적으로 View를 갖지 않고 결과를 확인할 수 있는
		// 다른 페이지로 강제 이동시켜야 한다. (중복실행 방지)
		// 그러므로 View의 경로를 리턴하지 않는다.
		return web.redirect(web.getRootPath() + "home.do", "회원가입이 완료되었습니다. 로그인 해 주세요.");
	}

}
