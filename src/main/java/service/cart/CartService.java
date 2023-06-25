package service.cart;

import java.util.List;
import java.util.Map;

import dao.cart.CartDAO;
import vo.cart.CartVO;
import vo.product.ProductVO;


public class CartService {

	static CartDAO cartDao;
	
	public CartService(CartDAO cartDao) {
		this.cartDao = cartDao;
	}
	
	public void insertCart(CartVO vo) {
		cartDao.insertCart(vo);
	}
	
	public List<Map<String, Object>> listCart(int uuserNO) {
		return cartDao.listCart(uuserNO);
	}

	public void updateCart(CartVO vo) {
		cartDao.updateCart(vo);
	}
	
	
	public int sumMoney(int uuserNO) {
		return cartDao.sumMoney(uuserNO);
	}
	
	
	
	public int checkCart(int ProductNo,int uuserNo) {
		return cartDao.checkCart(ProductNo, uuserNo);
	}
	
	
	
	public void checkUpdateCart(CartVO vo) {
		cartDao.updateCart(vo);
	}
	
	public static void deleteCart(int CartNo) {
		cartDao.deleteCart(CartNo);
	}

	
}

