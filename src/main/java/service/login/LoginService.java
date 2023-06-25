package service.login;

import common.Encry;
import dao.uuser.UuserDAO;
import vo.uuser.UuserVO;

public class LoginService {

	private UuserDAO uuserDao;
	
	public void setUuserDao(UuserDAO uuserDao) {
		this.uuserDao = uuserDao;
	}
	
	// 로그인
	public int checkLogin(UuserVO vo) {
		return uuserDao.checkLogin(vo);
	}
	
	// 회원 상태
	public int checkStatus(UuserVO vo) {
		return uuserDao.checkStatus(vo);
	}
	
	
	// 아이디 찾기
	public String findId(UuserVO vo) {
		return uuserDao.findId(vo);
	}
	
	// 비밀번호 찾기
	public String findPw(UuserVO vo) {
		return uuserDao.findPw(vo);
	}
	
	// 비밀번호 재설정
	public int updatePw(UuserVO vo) {
		
		return uuserDao.updatePw(vo);
	}
	
	// 유저 번호 찾기
	public UuserVO findNo(UuserVO vo) {
		return uuserDao.findNo(vo);
	}
	
	public String getSaltById(String uuserId) {
		return uuserDao.getSaltById(uuserId);
	}
	
	public UuserVO getUuser(UuserVO vo) {
		return uuserDao.getUuser(vo);
	}
}
