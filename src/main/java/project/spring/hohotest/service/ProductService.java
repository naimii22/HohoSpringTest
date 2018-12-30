package project.spring.hohotest.service;

import project.spring.hohotest.model.Product;

/** 제품 관련 기능을 제공하기 위한 Service 계층 */
public interface ProductService {
	
	/**
	 * 하나의 제품에 대한 정보를 가져온다.
	 * @param product - 가져욜 제품의 제품번호가 저장된 Beans
	 * @return Product - 가져온 제품
	 * @throws Exception
	 */
	public Product selectProduct(Product product) throws Exception;
}
