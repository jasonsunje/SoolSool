package service.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.review.ReviewDAO;
import dao.uuser.UuserDAO;
import vo.review.ReviewVO;
import vo.uuser.UuserVO;

public class ReviewService {

	private ReviewDAO reviewDao;
	private UuserDAO uuserDAO;
	
	public ReviewService(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}
	

	public List<Map<String,Object>> selectList(Map<String, Object> map){
		
		List<Map<String,Object>> list = reviewDao.selectList(map);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public ReviewVO selectOne(int no) {
		return reviewDao.selectOne(no);
	}
	
	public int getTotal(Map<String, Object> map) {
		return reviewDao.getTotal(map);
	}
	
	public Map<String, Object> getContent(int reviewNo){
		
		Map<String, Object> map = reviewDao.getContent(reviewNo);
		for(var key : map.keySet()) {
			System.out.println(key);
		}
		
		String str = "";
		
		StringBuffer buf = new StringBuffer();
		
		Clob clob = (Clob)map.get("CONTENT");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(clob.getCharacterStream());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			while((str = br.readLine()) != null) {
				buf.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		map.put("CONTENT", buf.toString());
		
		return map;
	}
	
	public int insert(ReviewVO vo) {
		int reviewNo = reviewDao.getSeq();
		
		if(vo.getReviewNo() !=0) { // 댓글
			ReviewVO ref = reviewDao.selectOne(vo.getReviewNo());
			
			vo.setGroupno(ref.getGroupno());
			vo.setOrderno(ref.getOrderno() + 1);
			vo.setDepth(ref.getDepth() + 1);
			
			reviewDao.updateOrderno(vo);
		}else {
			vo.setGroupno(reviewNo); // 새글
		}
		
		vo.setReviewNo(reviewNo);
		return reviewDao.insert(vo);
	}
	
	public int delete(int reviewNo) {
		return reviewDao.delete(reviewNo);
	}
	
	public int update(ReviewVO vo) {
		return reviewDao.update(vo);
	}
	
	public int updateOrderno(ReviewVO vo) {
		return reviewDao.updateOrderno(vo);
	}
	
	public int getSeq() {
		return reviewDao.getSeq();
	}
	
	public UuserVO selectNo(int uuserNo) {
		return uuserDAO.selectNo(uuserNo);
	}
	
	
	public UuserDAO getUuserDAO() {
		return uuserDAO;
	}

	public void setUuserDAO(UuserDAO uuserDAO) {
		this.uuserDAO = uuserDAO;
	}
	
}
