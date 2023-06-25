package vo.cart;

import java.sql.Date;

public class CartVO {

	private int cartNo;
	private int uuserNo;
	private int productNo;
	private int cartCnt;
	private int cartStock;
	private Date cartDate;
	
	
	
	
	public CartVO(int cartNo) {
		super();
		this.cartNo = cartNo;
	}


	public CartVO(int cartNo, int uuserNo, int productNo, int cartCnt, int cartStock, Date cartDate) {
		super();
		this.cartNo = cartNo;
		this.uuserNo = uuserNo;
		this.productNo = productNo;
		this.cartCnt = cartCnt;
		this.cartStock = cartStock;
		this.cartDate = cartDate;
	}


	public CartVO() {
		// TODO Auto-generated constructor stub
	}


	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}


	public int getUuserNo() {
		return uuserNo;
	}


	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getCartCnt() {
		return cartCnt;
	}


	public void setCartCnt(int cartCnt) {
		this.cartCnt = cartCnt;
	}


	public int getCartStock() {
		return cartStock;
	}


	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}


	public Date getCartDate() {
		return cartDate;
	}


	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}
	
	
	
}
