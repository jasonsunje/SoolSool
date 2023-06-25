package dao.gift;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.gift.GiftVO;

public class GiftDAO {

	private SqlSession sqlSession;

	public GiftDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<GiftVO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("gift.selectList", map);
	}

	public GiftVO selectOne(int giftNo) {
		return sqlSession.selectOne("gift.selectOne", giftNo);
	}

	public int getGiftNo() {
		return sqlSession.selectOne("gift.getGiftNo");
	}

	public int insert(GiftVO vo) {
		return sqlSession.insert("gift.insert", vo);
	}

	public int delete(int giftNo) {
		return sqlSession.delete("gift.delete", giftNo);
	}

	public int update(GiftVO vo) {
		return sqlSession.update("gift.update", vo);
	}

	public int updateGiftNo(GiftVO vo) {
		return sqlSession.selectOne("gift.getGiftNo");
	}
}
