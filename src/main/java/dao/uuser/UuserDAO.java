package dao.uuser;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.coupon.CouponVO;
import vo.uuser.UuserVO;
import vo.withdrawal.WithdrawalVO;

public class UuserDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlsession) {
		this.sqlSession = sqlsession;
	}

	// 로그인

	public int checkLogin(UuserVO vo) {

		int no = 0;

		try {
			no = sqlSession.selectOne("uuser.checkLogin", vo);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return no;
	}

	// 회원상태 가져오기
	public int checkStatus(UuserVO vo) {
		System.out.println(vo + "!!!!!!!!!!!!!!!!!!!!!!");
		return sqlSession.selectOne("uuser.checkStatus", vo);
	}

	// 아이디 찾기
	public String findId(UuserVO vo) {
		return sqlSession.selectOne("uuser.findId", vo);
	}

	// 비밀번호 찾기
	public String findPw(UuserVO vo) {
		return sqlSession.selectOne("uuser.findPw", vo);
	}

	// 비밀번호 재설정
	public int updatePw(UuserVO vo) {
		return sqlSession.update("uuser.updatePw", vo);
	}

	// 유저 번호 찾기
	public UuserVO findNo(UuserVO vo) {
		return sqlSession.selectOne("uuser.findNo", vo);
	}

	// 회원가입
	public int insert(UuserVO vo) {
		return sqlSession.insert("uuser.insert", vo);
	}

	// 아이디 중복 검사
	public String checkId(String id) {
		return sqlSession.selectOne("uuser.checkId", id);
	}

	// 회원 정보 검색( 마이페이지 )
	public UuserVO selectOne(int uuserNo) {
		return sqlSession.selectOne("uuser.selectOne", uuserNo);
	}

	// 회원 정보 수정
	public int update(UuserVO vo) {
		return sqlSession.update("uuser.update", vo);
	}

	// 회원 탈퇴
	public int withdrawal(int uuserNo) {
		return sqlSession.update("uuser.withdrawal", uuserNo);
	}

	// 탈퇴회원 추가
	public int insertWith(WithdrawalVO vo) {
		return sqlSession.insert("withdrawal.insertWith", vo);
	}

	// salt
	public String getSaltById(String uuserId) {
		return sqlSession.selectOne("uuser.salt", uuserId);
	}

	// salt no로 가져오기
	public String getSaltByNo(int no) {
		return sqlSession.selectOne("uuser.saltNo", no);
	}

	public UuserVO selectNo(int uuserNo) {
		return sqlSession.selectOne("uuser.selectNo", uuserNo);
	}

	// coupon
	public List<CouponVO> coupons(int uuserNo) {
		return sqlSession.selectList("uuser.coupons", uuserNo);
	}

	public int couponCount(int uuserNo) {
		return sqlSession.selectOne("coupon.countcoupon", uuserNo); 
	}
	
	// admin 회원 정보 조회
	public List<UuserVO> uuserList() {
		return sqlSession.selectList("uuser.selectAdminUser");
	}
	
	public UuserVO getUuser(UuserVO vo) {
		return sqlSession.selectOne("uuser.getUuser", vo);
	}

}
