package project.spring.hohotest.service;

import java.util.List;
import project.spring.hohotest.model.Product;

/** 제품 관련 기능을 제공하기 위한 Service 계층 */
public interface ProductService {
	
	public void insertProduct(Product product) throws Exception;							// 제품 추가
	public Product selectProduct(Product product) throws Exception;							// 하나의 제품 가져옴
	public List<Product> selectProductList(Product product) throws Exception;				// 제품 목록 조회
	public List<Product> selectProductListByType(Product product) throws Exception;			// 같은 타입의 제품 가져옴
	public int selectProductCount(Product product) throws Exception;						// 전체 제품 수 조회
	public void deleteProduct(Product product) throws Exception;							// 제품 삭제
	public void updateProduct(Product product) throws Exception;							// 제품 수정
}
