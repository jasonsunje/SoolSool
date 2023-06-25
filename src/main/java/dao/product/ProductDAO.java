package dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.admin.AdminVO;
import vo.product.ProductVO;

public class ProductDAO {

	private SqlSession sqlSession;
	
	public ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*
	 * public List<BoardVO> selectList(Map<String, Object> map){ return
	 * sqlSession.selectList("board.selectList",map); }
	 */
	
	public ProductVO selectOne(int no) {
		return sqlSession.selectOne("product.selectOne",no);
	}
	
	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("product.getTotal",map);
	}
	
	public int readCount(int productNo) {
		return sqlSession.update("product.readCount",productNo);
	}
	
	public Map<String, Object> getContent(int productNo){
		return sqlSession.selectOne("product.getContent", productNo);
	}
	
	public int insertProduct(ProductVO vo) {
		return sqlSession.insert("product.insertProduct",vo);
	}
	
	public int deleteProduct(int productNo) {
		return sqlSession.delete("product.deleteProduct",productNo);
	}
	
	public int updateProduct(ProductVO vo) {
		return sqlSession.update("product.updateProduct",vo);
	}
	
	public String getProductFile(int productNo) {
		return sqlSession.selectOne("product.getProductFile",productNo);
	}
	
	public int getSeq() {
		return sqlSession.selectOne("product.getSeq");
	}
	
	public List<ProductVO> listProduct() {
		return sqlSession.selectList("product.listProduct");
	}
	
	public ProductVO productDetail(int productNo) {
		return sqlSession.selectOne("product.productDetail", productNo);
	}
	
}

