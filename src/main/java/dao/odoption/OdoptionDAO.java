package dao.odoption;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.odoption.OdoptionVO;

public class OdoptionDAO {

	private SqlSession sqlSession;

	public OdoptionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<OdoptionVO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("odoption.selectList", map);
	}

	public OdoptionVO selectOne(int odoptionNo) {
		return sqlSession.selectOne("odoption.selectOne", odoptionNo);
	}

	public int insert(OdoptionVO vo) {
		return sqlSession.insert("Odoption.insert", vo);
	}

	public int delete(int odoptionNo) {
		return sqlSession.delete("odoption.delete", odoptionNo);
	}

	public int update(OdoptionVO vo) {
		return sqlSession.update("odoption.update", vo);
	}

	public int updateOdoptionNo(OdoptionVO vo) {
		return sqlSession.selectOne("odoption.getOdoptinNo");
	}

}
