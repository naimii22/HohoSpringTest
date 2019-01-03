package project.spring.hohotest.controller.review;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.FileInfo;
import project.spring.hohotest.helper.RegexHelper;
import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.ReviewService;

@Controller
public class ReviewUpdateOkController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	SqlSession sqlSession;
	@Autowired
	WebHelper web;
	@Autowired
	UploadHelper upload;
	@Autowired
	RegexHelper regex;
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value="/user/review/reviewUpdateOk.do", method=RequestMethod.POST)
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		//**********파일 아직안했음!!
		web.init();
		
		try {
			upload.multipartRequest();
		} catch (Exception e) {
			return web.redirect(null, "multipart 데이터가 아닙니다.");
		}
		
		Map<String, String> paramMap = upload.getParamMap();
		
		int reviewId = 0;
		try {
			reviewId = Integer.parseInt(paramMap.get("review_id"));
			System.out.println("review_id=" + reviewId);
		} catch (NumberFormatException e) {
			return web.redirect(null, "글 번호가 올바르지 않습니다.");
		}
		
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String image = paramMap.get("image");
		String userId = paramMap.get("user_id");
		
		logger.debug("title=" + title);
		logger.debug("content=" + content);
		logger.debug("image=" + image);
		
		if (!regex.isValue(title)) {
			return web.redirect(null, "제목을 입력해 주세요.");
		}
		
		if (!regex.isValue(content)) {
			return web.redirect(null, "내용을 입력해 주세요.");
		}
		
		Review review = new Review();
		review.setId(reviewId);
		review.setTitle(title);
		review.setContent(content);
		
		List<FileInfo> fileList = upload.getFileList();
		
		try {
			// 업로드 된 파일의 수 만큼 반복 처리 한다.
			for (int i = 0; i < fileList.size(); i++) {
				FileInfo info = fileList.get(i);

				System.out.println("fileInfo : " + info.toString());
				
				review.setImage(info.getFileDir() + "/"  + info.getFileName());
				
				// 저장처리
				reviewService.updateReview(review);
			}
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		String url = "%s/user/review/reviewView.do?id=%s&user_id=%s";
		url = String.format(url, web.getRootPath(), reviewId, userId);
		return web.redirect(url, null);
	}
}
