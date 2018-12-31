package project.spring.hohotest.service;

import java.util.List;

import project.spring.hohotest.model.Review;


/**
 * 게시물 관련 기능을 제공하기 위한 Service 계층
 */
public interface ReviewService {
	/**
	 * 게시물을 저장한다.
	 * 
	 * @param review
	 *            - 게시물 데이터
	 * @throws Exception
	 */
	public void insertReview(Review review) throws Exception;

	/**
	 * 하나의 게시물을 읽어들인다.
	 * 
	 * @param review
	 *            - 읽어들일 게시물 일련번호가 저장된 Beans
	 * @return Review - 읽어들인 게시물 내용
	 * @throws Exception
	 */
	public Review selectReviewById(Review review) throws Exception;

	/**
	 * 현재글을 기준으로 이전글을 읽어들인다.
	 * 
	 * @param review
	 *            - 현재글에 대한 게시물 번호가 저장된 Beans
	 * @return Review - 읽어들인 게시물 내용 (없을 경우 null)
	 * @throws Exception
	 */
	public Review selectPrevReview(Review review) throws Exception;

	/**
	 * 현재글을 기준으로 다음글을 읽어들인다.
	 * 
	 * @param review
	 *            - 현재글에 대한 게시물 번호가 저장된 Beans
	 * @return Review - 읽어들인 게시물 내용 (없을 경우 null)
	 * @throws Exception
	 */
	public Review selectNextReview(Review review) throws Exception;

	/**
	 * 조회수를 1 증가시킨다.
	 * 
	 * @param review
	 *            - 현재글에 대한 게시물 번호가 저장된 Beans
	 * @throws Exception
	 */
	public void updateReviewHit(Review review) throws Exception;

	/**
	 * 게시글 목록 조회
	 * 
	 * @param review
	 *            - 카테고리 정보가 저장된 Beans
	 * @return List - 게시물 목록
	 * @throws Exception
	 */
	public List<Review> selectReviewList(Review review) throws Exception;

	/**
	 * 전체 게시물 수 조회
	 * 
	 * @param review
	 * @return int
	 * @throws Exception
	 */
	public int selectReviewCount(Review review) throws Exception;

	/**
	 * 자신의 게시물인지 검사한다.
	 * 
	 * @param review
	 * @return int
	 * @throws Exception
	 */
	public int selectReviewCountByMemberId(Review review) throws Exception;

	/**
	 * 비밀번호를 검사한다.
	 * 
	 * @param review
	 * @return int
	 * @throws Exception
	 */
	public int selectReviewCountByPw(Review review) throws Exception;

	/**
	 * 게시물을 삭제한다.
	 * 
	 * @param review
	 * @throws Exception
	 */
	public void deleteReview(Review review) throws Exception;
	
	/**
	 * 게시물을 수정한다.
	 * @param review - 게시물 데이터
	 * @throws Exception
	 */
	public void updateReview(Review review) throws Exception;
	
	/**
	 * 회원과 게시물의 참조관계를 해제한다.
	 * @param review - 게시물 데이터
	 * @throws Exception
	 */
	public void updateReviewMemberOut(Review review) throws Exception;
	
	//product_id에 해당하는 review만 뽑기 위한 메소드
	public List<Review> selectReviewListByProductId(Review review) throws Exception;
	
}
