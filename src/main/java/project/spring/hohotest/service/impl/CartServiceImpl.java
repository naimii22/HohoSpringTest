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
			throw new Exception("장바구니에 담기가 실패했습니다.");
		}
	}

	@Override
	public List<Cart> selectCartList(Cart cart) throws Exception {
		List<Cart> cartList = null;
		
		return null;
	}
	
}
