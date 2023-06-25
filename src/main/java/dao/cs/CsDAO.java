package dao.cs;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.cs.CsVO;

public class CsDAO {


	private SqlSession sqlSession;
	
	public CsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> selectList(Map<String,Object> map){
		System.out.println(map.get("uuserNo")+"dao");
		return sqlSession.selectList("cs.selectList" , map);
	}
	
	public CsVO selectOne(int csNo) {
		return sqlSession.selectOne("cs.selectOne",csNo);
	}
	
	public int getTotal(Map<String,Object> map) {
		return sqlSession.selectOne("cs.getTotal" , map);
	}
	
	public int readCount(int csNo) {
		return sqlSession.update("cs.readCount",csNo);
	}
	
	public Map<String, Object> getContent(int csNo){
		return sqlSession.selectOne("cs.getContent", csNo);
	}
	
	public int insert(CsVO vo) {
		return sqlSession.insert("cs.insert",vo);
	}
	
	public int delete(int csNo) {
		return sqlSession.delete("cs.delete",csNo);
	}
	
	public int update(CsVO vo) {
		return sqlSession.update("cs.update",vo);
	}
	
	public int updateOrderno(CsVO vo) {
		return sqlSession.update("cs.updateOrderno",vo);
	}
	
	
	public int getSeq() {
		System.out.println("11111111111");
		return sqlSession.selectOne("cs.getSeq");
	}
}
