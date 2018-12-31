package project.spring.hohotest.service;

import java.util.List;

import project.spring.hohotest.model.Cart;

/** 장바구니 관련 기능을 제공하기 위한 Service 계층 */
public interface CartService {
	/**
	 * 상품을 장바구니에 담는다.
	 * @param cart - 장바구니 데이터
	 * @throws Exception
	 */
	public void insertCart(Cart cart) throws Exception;
	
	/**
	 * 특정 회원에 대한 장바구니 목록을 가져온다.
	 * @param cart - 회원번호 정보가 저장된 Beans
	 * @return List - 장바구니 목록
	 * @throws Exception
	 */
	public List<Cart> selectCartList(Cart cart) throws Exception;
	
	/**
	 * 특정 제품을 장바구니에서 삭제한다.
	 * @param cart - 삭제할 제품 정보가 저장된 Beans
	 * @throws Exception
	 */
	public void deleteCart(Cart cart) throws Exception;
}
