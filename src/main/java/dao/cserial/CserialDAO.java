package dao.cserial;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.cserial.CserialVO;

public class CserialDAO {

	private SqlSession sqlSession;

	public CserialDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<CserialVO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("cserial.selectList", map);
	}

	public CserialVO selectOne(int cserialNo) {
		return sqlSession.selectOne("cserial.selectOne", cserialNo);
	}

	public int getCserialNo() {
		return sqlSession.selectOne("cserial.getCserialNo");
	}

	public int insert(CserialVO vo) {
		return sqlSession.insert("cserial.insert", vo);
	}

	public int delete(int cserialNo) {
		return sqlSession.delete("cserial.delete", cserialNo);
	}

	public int update(CserialVO vo) {
		return sqlSession.update("cserial.update", vo);
	}

	public int updateCserialNo(CserialVO vo) {
		return sqlSession.selectOne("cserial.getCserialNo");
	}
}
