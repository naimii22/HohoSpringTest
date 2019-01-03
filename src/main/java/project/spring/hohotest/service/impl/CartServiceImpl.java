package project.spring.hohotest.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.hohotest.model.Cart;
import project.spring.hohotest.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	private static Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertCart(Cart cart) throws Exception {
		try {
			int result = sqlSession.insert("CartMapper.insertCart", cart);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("장바구니에 담길 상품이 없습니다.");
		} catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("장바구니 담기에 실패했습니다.");
		}
	}

	@Override
	public List<Cart> selectCartList(Cart cart) throws Exception {
		List<Cart> result = null;
		
		try {
			result = sqlSession.selectList("CartMapper.selectCartList", cart);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("조회된 장바구니가 없습니다.");
		} catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("장바구니 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void deleteCart(Cart cart) throws Exception {
		try {
			int result = sqlSession.delete("CartMapper.deleteCart", cart);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("존재하지 않는 장바구니에 대한 요청입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("장바구니 삭제에 실패했습니다.");
		}
	}

	@Override
	public void updateCartOrderId(Cart cart) throws Exception {
		try {
			int result = sqlSession.update("CartMapper.updateCartOrderId", cart);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("존재하지 않는 장바구니에 대한 요청입니다.");
		} catch (Exception e) {
			throw new Exception("장바구니 주문번호 변경에 실패했습니다.");
		}
	}
	
}
