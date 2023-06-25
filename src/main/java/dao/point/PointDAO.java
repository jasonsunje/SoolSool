package dao.point;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.point.PointVO;
import vo.uuser.UuserVO;

public class PointDAO {

	private SqlSession sqlSession;
	
	public PointDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertPoint(PointVO vo) {
		return sqlSession.insert("point.insertPoint", vo);
	}
	
	public int updatePoint(PointVO vo) {
		return sqlSession.update("point.update", vo);
	}

	public List<PointVO> myPoint(UuserVO vo) {
		return sqlSession.selectList("point.mypoint", vo);
	}
}
