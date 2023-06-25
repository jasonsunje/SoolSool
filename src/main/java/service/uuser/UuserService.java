package service.uuser;

import java.util.List;
import java.util.Map;

import common.Encry;
import dao.porder.PorderDAO;
import dao.uuser.UuserDAO;
import vo.uuser.UuserVO;
import vo.withdrawal.WithdrawalVO;


public class UuserService {

private UuserDAO uuserDao;
private PorderDAO porderDAO;
	
	public UuserService(UuserDAO uuserDao) {
		this.uuserDao = uuserDao;
	}
	
	
	
	public PorderDAO getPorderDAO() {
		return porderDAO;
	}



	public void setPorderDAO(PorderDAO porderDAO) {
		this.porderDAO = porderDAO;
	}



	public UuserVO selectOne(int uuserNo){
		return uuserDao.selectOne(uuserNo);
	}
	
	public int insert(UuserVO vo) {
		String salt = Encry.getSalt();
		vo.setUuserSalt(salt);
		
		String password = vo.getUuserPassword();
		password = Encry.encry(password, salt);
		
		vo.setUuserPassword(password);
		
		return uuserDao.insert(vo);
	}

	
	public int update(UuserVO vo) {
		String salt = uuserDao.getSaltByNo(vo.getUuserNo());
		String password = vo.getUuserPassword();
		password = Encry.encry(password, salt);
		vo.setUuserPassword(password);
		return uuserDao.update(vo);
	}
	
	
	public boolean checkId(String id) {
		return uuserDao.checkId(id) != null;
	}
	
	public int withdrawal(int uuserNo) {
		return uuserDao.withdrawal(uuserNo);
	}
	

	
	public int insertWith(WithdrawalVO vo) {
		return uuserDao.insertWith(vo);
	}
	
	public int couponCount(int uuserNo) {
		return uuserDao.couponCount(uuserNo);
	}
	
	public List<Map<String, Object>> listPorderUno(int uuserNo) {
		return porderDAO.listPorderUno(uuserNo);
	}
	
}
