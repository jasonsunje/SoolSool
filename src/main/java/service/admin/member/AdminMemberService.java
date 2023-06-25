package service.admin.member;

import java.util.List;

import dao.admin.AdminDAO;
import vo.admin.AdminVO;

public class AdminMemberService {

	private AdminDAO adminDao;
	
	public AdminMemberService(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}
	
	public int insert(AdminVO vo) {
		return adminDao.insert(vo);
	}
	
	public AdminVO selectOne(int adminNo) {
		return adminDao.selectOne(adminNo);
	}
	
	
	public int update(AdminVO vo) {
		return adminDao.update(vo);
	}
	
	public int delete(int adminNo) {
		return adminDao.delete(adminNo);
	}
	
	public boolean checkId(String adminId) {
		return adminDao.checkId(adminId) != null;
	}
}
























