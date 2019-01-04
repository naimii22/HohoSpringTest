package project.spring.hohotest.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.hohotest.model.Orders;
import project.spring.hohotest.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	/** MyBatis */
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertOrder(Orders order) throws Exception {
		try {
			int result = sqlSession.insert("OrderMapper.insertOrder", order);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("주문이 없습니다.");
			
		} catch (Exception e) {
			throw new Exception("주문에 실패했습니다.");
		}
	}

	@Override
	public Orders selectOrder(Orders order) throws Exception {
		Orders result = null;

		try {
			result = sqlSession.selectOne("OrderMapper.selectOrder", order);
			
			if ( result == null ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 주문이 없습니다.");
			
		} catch (Exception e) {
			throw new Exception("주문 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<Orders> selectOrderList(Orders order) throws Exception {
		List<Orders> result = null;

		try {
			result = sqlSession.selectList("OrderMapper.selectOrderList", order);
			
			if ( result == null ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 주문 목록이 없습니다.");
			
		} catch (Exception e) {
			throw new Exception("주문 목록 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int selectOrderCount(Orders order) throws Exception {
		int result = 0;

		try {
			// 게시물 수가 0건인 경우도 있으므로, 결과값이 0인 경우에 대한 예외를 발생시키지 않는다.
			result = sqlSession.selectOne("OrderMapper.selectOrderCount", order);
			
		} catch (Exception e) {
			throw new Exception("주문 수 조회에 실패했습니다.");
		}

		return result;
	}

}