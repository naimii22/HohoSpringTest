package project.spring.hohotest.service;

import java.util.List;

import project.spring.hohotest.model.Notice;

/**
 * 공지사항 게시물 관련 기능을 제공하기 위한 Service 계층
 */
public interface NoticeService {
	
	public void insertNotice(Notice notice) throws Exception;				// 게시글 저장
	public Notice selectNotice(Notice notice) throws Exception;				// 하나의 게시글 읽음
	public Notice selectPrevNotice(Notice notice) throws Exception;			// 현재글을 기준으로 이전글 읽음
	public Notice selectNextNotice(Notice notice) throws Exception;			// 현재글을 기준으로 다음글 읽음
	public void updateNoticeHit(Notice notice) throws Exception;			// 조회수 1 증가
	public List<Notice> selectNoticeList(Notice notice) throws Exception;	// 게시글 목록 조회
	public int selectNoticeCount(Notice notice) throws Exception;			// 전체 게시글 수 조회
	public void deleteNotice(Notice notice) throws Exception;				// 게시글 삭제
	public void updateNotice(Notice notice) throws Exception;				// 게시글 업데이트

}