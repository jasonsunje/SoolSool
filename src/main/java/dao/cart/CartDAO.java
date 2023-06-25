package dao.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.cart.CartVO;
import vo.product.ProductVO;

public class CartDAO {

	private SqlSession sqlSession;
	
	public CartDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//장바구니 추가
	public void insertCart(CartVO vo) {
		sqlSession.insert("cart.insertCart",vo);
	}
	
	
	//장바구니 목록
	public List<Map<String, Object>> listCart(int uuserNo) {
		return sqlSession.selectList("cart.listCart", uuserNo);
	}
	
	//장바구니 삭제
	public void deleteCart(int cartNo) {
		sqlSession.delete("cart.deleteCart",cartNo);
	}
	
	//장바구니 수정
	public void updateCart(CartVO vo) {
		sqlSession.update("cart.CheckUpdateCart",vo);
	}
	
	//장바구니 금액 합계
	public int sumMoney(int uuserNo) {
		return sqlSession.selectOne("cart.sumMoney",uuserNo);
	}
	
	//장바구니 동일한 상품 레코드 확인
	public int checkCart(int productNo, int uuserNo) {
		Map<String, Object> map = new HashMap<String,Object> ();
		map.put("productNo",productNo);
		map.put("uuserNo",uuserNo);
		return sqlSession.selectOne("cart.checkCart",map);
	}

	//장바구니 상품 수량 변경
	public void checkUpdateCart(CartVO vo) {
		sqlSession.selectOne("cart.CheckUpdateCart",vo);
	}
	
	
}
