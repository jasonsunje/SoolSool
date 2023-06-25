package service.mngdelivery;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dao.mngdelivery.MngdeliveryDAO;
import vo.mngdelivery.MngdeliveryVO;

public class MngdeliveryService {

	private MngdeliveryDAO mngdeliveryDao;

	public MngdeliveryService(MngdeliveryDAO mngdeliveryDao) {
		this.mngdeliveryDao = mngdeliveryDao;
	}

	public int updateMngdelivery(MngdeliveryVO vo) {
		return mngdeliveryDao.updateDeliveryNo(vo);
	}

	public int deleteMngdelivery(int mngdeliveryNo) {
		return mngdeliveryDao.deleteMngdelivery(mngdeliveryNo);
	}

	public MngdeliveryVO getMngdeliveryById(int mngdeliveryNo) {
		return mngdeliveryDao.getMngdeliveryById(mngdeliveryNo);
	}

	public List<MngdeliveryVO> getAllMngdelivery() {
		return mngdeliveryDao.getAllMngdelivery();
	}

	public int insertMngdelivery(MngdeliveryVO vo) {
		return mngdeliveryDao.insertMngdelivery(vo);

	}
	
	public MngdeliveryVO selectMngdelivery(int mngdeliveryNo) {
		return mngdeliveryDao.selectMngdelivery (mngdeliveryNo);
	}
	
	public int basicUpdate() {
		return mngdeliveryDao.basicUpdate();
	}
	
	public List<MngdeliveryVO> getNoMngdelivery(int uuserNo) {
		return mngdeliveryDao.getNoMngdelivery(uuserNo);
	}
}
