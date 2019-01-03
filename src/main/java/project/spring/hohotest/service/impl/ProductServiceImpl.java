package project.spring.hohotest.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertProduct(Product product) throws Exception {
		try {
			int result = sqlSession.insert("ProductMapper.insertProduct", product);
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("저장된 제품이 없습니다.");
			
		} catch (Exception e) {
			throw new Exception("제품 추가에 실패했습니다.");
		}
	}
	
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
	
	@Override
	public List<Product> selectProductList(Product product) throws Exception {
		List<Product> result = null;

		try {
			result = sqlSession.selectList("ProductMapper.selectProductList", product);
			if ( result == null ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 제품 목록이 없습니다.");
			
		} catch (Exception e) {
			throw new Exception("제품 목록 조회에 실패했습니다.");
		}

		return result;
	}
	
	@Override
	public List<Product> selectProductListByType(Product product) throws Exception {
		List<Product> result = null;
		
		try {
			result = sqlSession.selectList("ProductMapper.selectProductListByType", product);
			if (result == null) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("조회된 제품 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("제품 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectProductCount(Product product) throws Exception {
		int result = 0;

		try {
			// 게시물 수가 0건인 경우도 있으므로, 결과값이 0인 경우에 대한 예외를 발생시키지 않는다.
			result = sqlSession.selectOne("ProductMapper.selectProductCount", product);
			
		} catch (Exception e) {
			throw new Exception("제품 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		try {
			int result = sqlSession.delete("ProductMapper.deleteProduct", product);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("존재하지 않는 제품에 대한 요청입니다.");
			
		} catch (Exception e) {
			throw new Exception("제품 삭제에 실패했습니다.");
		}
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		try {
			int result = sqlSession.update("ProductMapper.updateProduct", product);
			
			if ( result == 0 ) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException e) {
			throw new Exception("존재하지 않는 제품에 대한 요청입니다.");
			
		} catch (Exception e) {
			throw new Exception("제품 수정에 실패했습니다.");
		}
	}

}
