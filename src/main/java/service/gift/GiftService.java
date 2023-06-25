package service.gift;

import java.util.List;
import java.util.Map;

import dao.gift.GiftDAO;
import vo.gift.GiftVO;

public class GiftService {

	private GiftDAO giftDao;

	public GiftService(GiftDAO giftDao) {
		this.giftDao = giftDao;
	}

	public List<GiftVO> selectList(Map<String, Object> map) {

		List<GiftVO> list = giftDao.selectList(map);

		if (list.isEmpty()) {
			list = null;
		}
		return list;
	}

	public GiftVO selectOne(int giftNo) {
		return giftDao.selectOne(giftNo);
	}

	public int insert(GiftVO vo) {
		return giftDao.insert(vo);
	}

	public int delete(int giftNo) {
		return giftDao.delete(giftNo);
	}

	public int update(GiftVO vo) {
		return giftDao.update(vo);
	}
}
