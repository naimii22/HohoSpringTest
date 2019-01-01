package project.spring.hohotest.controller.admin.member;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Comment;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.CommentService;
import project.spring.hohotest.service.MemberService;
import project.spring.hohotest.service.ReviewService;

@Controller
public class AdminMemberDeleteOk {
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	private static Logger logger = LoggerFactory.getLogger(AdminMemberDeleteOk.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	MemberService memberService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "admin/member/adminMemberDelete_ok.do")
	public ModelAndView doRun(Locale locale, Model model, 
			@RequestParam(value="member_id", defaultValue="0") int member_id,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		web.init();

	/*	*//** (3) 파라미터 받기 *//*
		int memberId = web.getInt("member_id");
		logger.debug("memberId=" + memberId);

		if (memberId == 0) {
			web.printJsonRt("회원번호가 없습니다.");
		}*/

		/** (5) 서비스에 전달하기 위하여 파라미터를 Beans로 묶는다. */
		// 회원번호는 세션을 통해서 획득한 로그인 정보에서 취득.
		Member member = new Member();
		member.setId(member_id);

		// 게시판과의 참조 관계 해제를 위한 조건값 설정
		Review review = new Review();
		review.setMember_id(member_id);

		// 덧글과의 참조 관계 해제를 위한 조건값 설정
		Comment comment = new Comment();
		comment.setMember_id(member_id);

		/** (6) Service를 통한 탈퇴 시도 */
		try {
			// 참조관계 해제
			reviewService.updateReviewMemberOut(review);
			commentService.updateCommentMemberOut(comment);
			// 탈퇴처리
			memberService.deleteMember(member);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** (7) 정상적으로 탈퇴된 경우 페이지 이동 */
		String url = "%s/admin/member/adminMemberOk.do";
		url = String.format(url, web.getRootPath());
		return web.redirect(url, null);
	}
}
