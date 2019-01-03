package project.spring.hohotest.service;

import java.util.List;

import project.spring.hohotest.model.Orders;

/** 주문 관련 기능을 제공하기 위한 Service 계층 */
public interface OrderService {
	
	public void insertOrder(Orders order) throws Exception;									// 주문 추가
	public Orders selectOrder(Orders order) throws Exception;								// 하나의 주문보기
	public List<Orders> selectOrderList(Orders order) throws Exception;						// 주문 목록 조회
	public int selectOrderCount(Orders order) throws Exception;								// 전체 주문 수 조회
	public String selectUserId(Orders order) throws Exception;			// 회원 아이디 조회
}