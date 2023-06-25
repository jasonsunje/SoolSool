package service.admin.uuser;

import java.util.List;

import dao.uuser.UuserDAO;
import vo.uuser.UuserVO;

public class AdminUuserService {

	private static UuserDAO uuserDao;
	
	public AdminUuserService(UuserDAO uuserDao) {
		AdminUuserService.uuserDao = uuserDao;
	}
	
	public static List<UuserVO> uuserList() {
		System.out.println("AdminUuswerService");
		return uuserDao.uuserList();
	}
	
}
