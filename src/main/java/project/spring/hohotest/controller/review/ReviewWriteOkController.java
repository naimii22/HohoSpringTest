package project.spring.hohotest.controller.review;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.controller.login.loginController;
import project.spring.hohotest.helper.FileInfo;
import project.spring.hohotest.helper.RegexHelper;
import project.spring.hohotest.helper.UploadHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Member;
import project.spring.hohotest.model.Review;
import project.spring.hohotest.service.ReviewService;


@Controller
public class ReviewWriteOkController {
	
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	WebHelper web;
	@Autowired
	UploadHelper upload;
	@Autowired
	RegexHelper regex;
	@Autowired
	ReviewService reviewService;
	
	
	@RequestMapping(value="/user/review/reviewWriteOk.do" )
	public ModelAndView doRun() {
		
		web.init();

		try {
			upload.multipartRequest();
		} catch (Exception e) {
			return web.redirect(null, "multipart 데이터가 아닙니다.");
		}

		
		/** UploadHelper에서 텍스트 형식의 값을 추출 */
		Map<String, String> paramMap = upload.getParamMap();
		
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String str_rating = paramMap.get("rating");
		String str_product_id = paramMap.get("product_id");
		
		int rating = Integer.parseInt(str_rating);
		int product_id = Integer.parseInt(str_product_id);
		
/*		Member loginInfo = (Member) web.getSession("loginInfo");
		int member_id = 0;
		if (loginInfo != null) {
			member_id = loginInfo.getId();
		}
*/
		
////샘플
int member_id = 1;		
		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("title=" + title);
		logger.debug("content=" + content);
		logger.debug("rating=" + rating);
		logger.debug("product_id=" + product_id);
		logger.debug("member_id=" + member_id);
		
		/** 입력 받은 파라미터에 대한 유효성 검사 */
		// 이름 + 비밀번호
		if (!regex.isValue(title)) {
			return web.redirect(null, "제목을 입력해주세요.");
		}

		if (!regex.isValue(content)) {
			return web.redirect(null, "내용을 입력해주세요.");
		}

		// 이메일
		if (!regex.isValue(rating)) {
			return web.redirect(null, "평점을 선택해주세요.");
		}
		
		Review review = new Review();
		
		review.setTitle(title);
		review.setContent(content);
		review.setRating(rating);
		review.setProduct_id(product_id);
		review.setMember_id(member_id);
		
		logger.debug("review >> " + review.toString());
		
////파일!!
		
		List<FileInfo> fileList = upload.getFileList();
		
		try {
			// 업로드 된 파일의 수 만큼 반복 처리 한다.
			for (int i = 0; i < fileList.size(); i++) {
				FileInfo info = fileList.get(i);

				System.out.println("fileInfo : " + info.toString());
				
				review.setImage(info.getFileDir() + "/"  + info.getFileName());
				System.out.println("image경로 및 이름=" + info.getFileDir() + "/"  + info.getFileName());
				
				// 저장처리
				reviewService.insertReview(review);
			}
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		
		/** (11) 저장 완료 후 읽기 페이지로 이동하기 */
		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/user/taste/productView.do?id=%d";
		url = String.format(url, web.getRootPath(), review.getProduct_id());
		return web.redirect(url, null);
	}
}
