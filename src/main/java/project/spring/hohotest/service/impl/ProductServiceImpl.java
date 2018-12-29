/*package project.spring.hohotest.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public Product selectProduct(Product product) throws Exception {
		Product result = null;
		
		try {
			result = sqlSession.selectOne("ProductMapper.selectProduct", product);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("가져올 제품 정보가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("제품 정보를 가져오기에 실패했습니다.");
		}

		return result;
	}

}
*/