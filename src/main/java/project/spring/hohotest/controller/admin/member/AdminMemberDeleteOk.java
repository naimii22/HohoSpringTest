package project.spring.hohotest.controller.admin.member;

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

import project.spring.hohotest.controller.member.OutOk;
import project.spring.hohotest.helper.UploadHelper;
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
	UploadHelper upload;
	@Autowired
	MemberService memberService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "admin/member/adminMemberDelete_Ok.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		web.init();

		/** (3) 파라미터 받기 */
		int memberId = web.getInt("member_id");
		logger.debug("memberId=" + memberId);

		if (memberId == 0) {
			web.printJsonRt("회원번호가 없습니다.");
		}

		/** (5) 서비스에 전달하기 위하여 파라미터를 Beans로 묶는다. */
		// 회원번호는 세션을 통해서 획득한 로그인 정보에서 취득.
		Member member = new Member();
		member.setId(memberId);

		// 게시판과의 참조 관계 해제를 위한 조건값 설정
		Review review = new Review();
		review.setMember_id(memberId);

		// 덧글과의 참조 관계 해제를 위한 조건값 설정
		Comment comment = new Comment();
		comment.setMember_id(memberId);

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

		/** (7) 정상적으로 탈퇴된 경우 강제 로그아웃 및 페이지 이동 */
		return web.redirect(web.getRootPath() + "admin/member/adminMember_ok.do", "탈퇴되었습니다.");
	}
}
