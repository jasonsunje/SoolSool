package dao.mngdelivery;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.mngdelivery.MngdeliveryVO;

public class MngdeliveryDAO {

	private SqlSession sqlSession;

	public MngdeliveryDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insertMngdelivery(MngdeliveryVO vo) {
		return sqlSession.insert("mngdelivery.insertMngdelivery", vo);
	}

	public int deleteMngdelivery(int mngdeliveryNo) {
		return sqlSession.delete("mngdelivery.deleteMngdelivery", mngdeliveryNo);
	}

	public int update(MngdeliveryVO vo) {
		return sqlSession.update("mngdelivery.update", vo);
	}

	public int updateDeliveryNo(MngdeliveryVO vo) {
		return sqlSession.update("mngdelivery.update", vo);
	}
	
	public MngdeliveryVO getMngdeliveryById(int mngdeliveryNo) {
		return sqlSession.selectOne("mngdelivery.getMngdeliveryById",mngdeliveryNo);
	}
	
	public MngdeliveryVO selectMngdelivery(int mngdeliveyNo) {
		return sqlSession.selectOne("mngdelivery.selectMngdelivery", mngdeliveyNo);
	}

	public List<MngdeliveryVO> getAllMngdelivery() {
		return sqlSession.selectList("mngdelivery.getAllMngdelivery");
	}
	
	public int basicUpdate() {
		return sqlSession.update("mngdelivery.basicUpdate");
	}
	
	public List<MngdeliveryVO> getNoMngdelivery(int uuserNo) {
		return sqlSession.selectList("mngdelivery.getNoMngdelivery", uuserNo);
	}

}
