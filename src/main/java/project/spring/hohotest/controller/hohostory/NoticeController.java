package project.spring.hohotest.controller.hohostory;

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
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
/*	@Autowired
	WebHelper web;
	@Autowired
	Notice notice;
	@Resource(name="noticeService")
	NoticeService noticeService;
	@Autowired
	PageHelper pageHelper;*/

	@RequestMapping("user/hohoStory/notice.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("notice is running...");
/*		web.init();

		// 현재 페이지 수 --> 기본값은 1페이지로 설정함
		int page = web.getInt("page", 1);
		*//** 게시글 목록 조회 *//*
		int totalCount = 0;
		List<Notice> noticeList = null;
		
		try {
			// 전체 게시물 수
			totalCount = noticeService.selectNoticeCount(notice);
			
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 12, 5);

			// 페이지 번호 계산 결과에서 Limit절에 필요한 값을 Beans에 추가
			notice.setLimitStart(pageHelper.getLimitStart());
			notice.setListCount(pageHelper.getListCount());
			
			noticeList = noticeService.selectNoticeList(notice);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		*//** 조회 결과를 View에 전달 *//*
		model.addAttribute("noticeList", noticeList);
		// 페이지 번호 계산 결과를 View에 전달
		model.addAttribute("pageHelper", pageHelper);
		
		// 현재 페이지의 가장 큰 번호 구하기
		// --> 전체갯수 - (페이지번호-1) * 한페이지에 표시할 갯수
		int maxPageNo = pageHelper.getTotalCount() - (pageHelper.getPage() - 1)
				* pageHelper.getListCount();
		// 구해진 최대 수치를 View에 전달하기 (이 값을 1씩 감소시키면서 출력한다.)
		model.addAttribute("maxPageNo", maxPageNo);

		// noticeList, pageHelper, maxPageNo addAttribute함
*/		return new ModelAndView("user/hohoStory/notice");
	}
}