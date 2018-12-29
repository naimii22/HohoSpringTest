package project.spring.hohotest.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.hohotest.model.Notice;
import project.spring.hohotest.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	/** 처리 결과를 기록할 Log4J 객체 생성 */
	private static Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	/** MyBatis */
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertNotice(Notice notice) throws Exception {
		try {
			int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("저장된 게시물이 없습니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 등록에 실패했습니다.");
		}
	}

	@Override
	public Notice selectNotice(Notice notice) throws Exception {
		Notice result = null;

		try {
			result = sqlSession.selectOne("NoticeMapper.selectNotice", notice);
			
			if (result == null) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 게시물이 없습니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public Notice selectPrevNotice(Notice notice) throws Exception {
		Notice result = null;

		try {
			// 이전글이 없는 경우도 있으므로, 리턴값이 null인 경우 예외를 발생하지 않는다.
			result = sqlSession.selectOne("NoticeMapper.selectPrevNotice", notice);
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이전글 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public Notice selectNextNotice(Notice notice) throws Exception {
		Notice result = null;

		try {
			// 다음글이 없는 경우도 있으므로, 리턴값이 null인 경우 예외를 발생하지 않는다.
			result = sqlSession.selectOne("NoticeMapper.selectNextNotice", notice);
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("다음글 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void updateNoticeHit(Notice notice) throws Exception {
		try {
			int result = sqlSession.update("NoticeMapper.updateNoticeHit", notice);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("조회수 갱신에 실패했습니다.");
		}
	}

	@Override
	public List<Notice> selectNoticeList(Notice notice) throws Exception {
		List<Notice> result = null;

		try {
			result = sqlSession.selectList("NoticeMapper.selectNoticeList", notice);
			
			if ( result == null ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int selectNoticeCount(Notice notice) throws Exception {
		int result = 0;

		try {
			// 게시물 수가 0건인 경우도 있으므로, 결과값이 0인 경우에 대한 예외를 발생시키지 않는다.
			result = sqlSession.selectOne("NoticeMapper.selectNoticeCount", notice);
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void deleteNotice(Notice notice) throws Exception {
		try {
			int result = sqlSession.delete("NoticeMapper.deleteNotice", notice);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 삭제에 실패했습니다.");
		}
	}

	@Override
	public void updateNotice(Notice notice) throws Exception {
		try {
			int result = sqlSession.update("NoticeMapper.updateNotice", notice);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수정에 실패했습니다.");
		}
	}

}
