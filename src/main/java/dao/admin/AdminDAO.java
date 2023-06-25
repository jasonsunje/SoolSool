package dao.admin;

import org.apache.ibatis.session.SqlSession;

import vo.admin.AdminVO;

public class AdminDAO {

	private SqlSession sqlSession;
	
	public AdminDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int checkLogin(AdminVO vo) {
		
		int no = 0;
		
		try {
			no = sqlSession.selectOne("admin.checkLogin",vo);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return no;
	}
	
	public int insert(AdminVO vo) {
		return sqlSession.insert("admin.insert",vo);
	}
	
	public AdminVO selectOne(int adminNo) {
		return sqlSession.selectOne("admin.selectOne", adminNo);
	}
	
	public int update(AdminVO vo) {
		return sqlSession.update("admin.update",vo);
	}
	
	public int delete(int adminNo) {
		return sqlSession.delete("admin.delete",adminNo);
	}
	
	public String checkId(String adminId) {
		return sqlSession.selectOne("admin.checkId", adminId);
	}
}



























