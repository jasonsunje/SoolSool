package service.porder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.cart.CartDAO;
import dao.porder.PorderDAO;
import vo.porder.PorderVO;

	
@Service
public class PorderService {
	    
    @Autowired
    private PorderDAO porderDao;
    
	public PorderService(PorderDAO porderDao) {
		this.porderDao = porderDao;
	}
	    
    public void createOrder(PorderVO porderVO) {
        // 주문 생성 로직 구현
    	porderDao.createOrder(porderVO);
    }
	    
    public PorderVO getOrderById(int porderNo) {
        // 주문 조회 로직 구현
        return porderDao.getOrderById(porderNo);
    }
	    
    public void cancelOrder(int porderNo) {
        // 주문 취소 로직 구현
    	porderDao.cancelOrder(porderNo);
    }
	    
    
	public List<Map<String, Object>> listPorder(int porderNo) {
		return porderDao.listPorder(porderNo);
	}
	
	public List<Map<String, Object>> listPorderPno(int pOrderPno) {
		return porderDao.listPorderPno(pOrderPno);
	}
	
	public int getPno() {
		return porderDao.getPno();
	}
}

	
	

