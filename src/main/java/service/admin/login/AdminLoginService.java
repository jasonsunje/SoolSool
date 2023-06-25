package service.admin.login;

import dao.admin.AdminDAO;
import vo.admin.AdminVO;

public class AdminLoginService {

	private AdminDAO adminDao;
	
	public AdminLoginService(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}
	
	public int checkLogin(AdminVO vo) {
		return adminDao.checkLogin(vo);
	}
}