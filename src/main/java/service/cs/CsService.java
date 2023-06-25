package service.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.cs.CsDAO;
import dao.uuser.UuserDAO;
import vo.cs.CsVO;
import vo.uuser.UuserVO;

public class CsService {

	private CsDAO csDao;
	private UuserDAO uuserDAO;

	public CsService(CsDAO csDao) {
		this.csDao = csDao;
	}

	public List<Map<String,Object>> selectList(Map<String, Object> map) {

		List<Map<String,Object>> list = csDao.selectList(map);

		if (list.isEmpty()) {
			list = null;
		}

		return list;
	}

	public CsVO selectOne(int csNo) {
		return csDao.selectOne(csNo);
	}

	public int getTotal(Map<String, Object> map) {
		return csDao.getTotal(map);
	}

	public Map<String, Object> getContent(int csNo) {
		csDao.readCount(csNo); // 조회수

		Map<String, Object> map = csDao.getContent(csNo);
		for (var key : map.keySet()) {
			System.out.println(key);
		}

		String str = "";

		StringBuffer buf = new StringBuffer();

		Clob clob = (Clob) map.get("CS_CONTENT");

		BufferedReader br = null;
		try {
			br = new BufferedReader(clob.getCharacterStream());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			while ((str = br.readLine()) != null) {
				buf.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		map.put("CONTENT", buf.toString());

		return map;
	}

	public int insert(CsVO vo) {
		int csNo = csDao.getSeq();
		if (vo.getCsNo() != 0) { // 댓글
			CsVO ref = csDao.selectOne(vo.getCsNo());

			vo.setGroupno(ref.getGroupno());
			vo.setOrderno(ref.getOrderno() + 1);
			vo.setDepth(ref.getDepth() + 1);

			csDao.updateOrderno(vo);
		} else {
			vo.setGroupno(csNo); // 새글
		}

		vo.setCsNo(csNo);
		return csDao.insert(vo);
	}

	public int delete(int csNo) {
		return csDao.delete(csNo);
	}

	public int update(CsVO vo) {
		return csDao.update(vo);
	}

	public int updateOrderno(CsVO vo) {
		return csDao.updateOrderno(vo);
	}

	public int getSeq() {
		return csDao.getSeq();
	}
	
	//----- uuser
	public UuserVO selectNo(int uuserNo) {
		System.out.println(uuserNo+"service유저번호!!");
		return uuserDAO.selectNo(uuserNo);
	}

	public UuserDAO getUuserDAO() {
		return uuserDAO;
	}

	public void setUuserDAO(UuserDAO uuserDAO) {
		this.uuserDAO = uuserDAO;
	}
	
	
}
