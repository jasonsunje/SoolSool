package dao.porder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.porder.PorderVO;

public class PorderDAO {

	private SqlSession sqlSession;
	
	public PorderDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 주문 생성
	public void createOrder(PorderVO porderVO) {
		System.out.println("dao vo.product no : " + porderVO.getProductNo());
		sqlSession.insert("porder.createOrder", porderVO);
	}
	
	// 주문 조회
	public PorderVO getOrderById(int porderNo) {
		return sqlSession.selectOne("porder.getOrderById", porderNo);
	}
	
	// 주문 취소
	public void cancelOrder(int porderNo) {
		sqlSession.delete("porder.cancelOrder", porderNo);
	}
	
	// 주문 상세 조회
	public List<Map<String, Object>> listPorder(int porderNo) {
		return sqlSession.selectList("porder.listPorder", porderNo);
	}
	
	public List<Map<String, Object>> listPorderPno(int pOrderPno) {
		return sqlSession.selectList("porder.getOrderByPno", pOrderPno);
	}
	// 기타 주문과 관련된 데이터베이스 작업을 위한 메소드들 구현
	
	public int getPno() {
		return sqlSession.selectOne("porder.getPno");
	}
	
	public List<Map<String, Object>> listPorderUno(int uuserNo) {
		return sqlSession.selectList("porder.getOrderByUno", uuserNo);
	}
}


