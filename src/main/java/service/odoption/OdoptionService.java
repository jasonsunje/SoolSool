package service.odoption;

import java.util.List;
import java.util.Map;

import dao.odoption.OdoptionDAO;
import vo.odoption.OdoptionVO;

public class OdoptionService {

	private OdoptionDAO odoptionDao;

	public OdoptionService(OdoptionDAO odoptionDao) {
		this.odoptionDao = odoptionDao;
	}

	public List<OdoptionVO> selectList(Map<String, Object> map) {

		List<OdoptionVO> list = odoptionDao.selectList(map);

		if (list.isEmpty()) {
			list = null;
		}
		return list;
	}

	public OdoptionVO selectOne(int odoptionNo) {
		return odoptionDao.selectOne(odoptionNo);
	}

	public int insert(OdoptionVO vo) {
		return odoptionDao.insert(vo);
	}

	public int delete(int odoptionNo) {
		return odoptionDao.delete(odoptionNo);
	}

	public int update(OdoptionVO vo) {
		return odoptionDao.update(vo);
	}

}
