package dao.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.review.ReviewVO;


public class ReviewDAO {

	private SqlSession sqlSession;
	
	public ReviewDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> selectList(Map<String,Object> map){
		System.out.println(map.get("uuserNo")+"dao");
		return sqlSession.selectList("review.selectList" , map);
	}
	
	public ReviewVO selectOne(int reviewNo) {
		System.out.println(reviewNo+ "daonum");
		return sqlSession.selectOne("review.selectOne",reviewNo);
	}
	
	public int getTotal(Map<String,Object> map) {
		return sqlSession.selectOne("review.getTotal" , map);
	}
	
	public Map<String, Object> getContent(int reviewNo){
		return sqlSession.selectOne("review.getContent", reviewNo);
	}
	
	public int insert(ReviewVO vo) {
		return sqlSession.insert("review.insert",vo);
	}
	
	public int delete(int reviewNo) {
		return sqlSession.delete("review.delete",reviewNo);
	}
	
	public int update(ReviewVO vo) {
		return sqlSession.update("review.update",vo);
	}
	
	public int updateOrderno(ReviewVO vo) {
		return sqlSession.update("review.updateOrderno",vo);
	}
	
	public int getSeq() {
		return sqlSession.selectOne("review.getSeq");
	}
	
	
}
