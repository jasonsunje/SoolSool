package vo.porder;

import java.sql.Date;
import java.util.List;

public class PorderVO {

	private int pOrderNo;
	private String pOrderPdate;
	private int pOrderPtotal;
	private int pOrderPno;
	private String pOrderCcheck;
	private String pOrderPcheck;
	private int pOrderPused;
	private int pOrderDtotal;
	private String pOrderPstatus;
	private int pOrderPay;
	private int pOrderGcheck;
	
	
	private int productNo;
	private int couponNo;
	private int pStockNo;
	private int odOptionNo;
	private int uuserNo;
	
	
	private int productPrice;
	private int productDiscount;
	private int productCnt;
	
	
	private List<PorderVO> order;
	
	
	public PorderVO() {
		super();
	}


	public PorderVO(int pOrderNo, String pOrderPdate, int pOrderPtotal, int pOrderPno, String pOrderCcheck,
			String pOrderPcheck, int pOrderPused, int pOrderDtotal, String pOrderPstatus, int pOrderPay,
			int pOrderGcheck, int productNo, int couponNo, int pStockNo, int odOptionNo, int uuserNo, int productPrice,
			int productDiscount, int productCnt, List<PorderVO> order) {
		super();
		this.pOrderNo = pOrderNo;
		this.pOrderPdate = pOrderPdate;
		this.pOrderPtotal = pOrderPtotal;
		this.pOrderPno = pOrderPno;
		this.pOrderCcheck = pOrderCcheck;
		this.pOrderPcheck = pOrderPcheck;
		this.pOrderPused = pOrderPused;
		this.pOrderDtotal = pOrderDtotal;
		this.pOrderPstatus = pOrderPstatus;
		this.pOrderPay = pOrderPay;
		this.pOrderGcheck = pOrderGcheck;
		this.productNo = productNo;
		this.couponNo = couponNo;
		this.pStockNo = pStockNo;
		this.odOptionNo = odOptionNo;
		this.uuserNo = uuserNo;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCnt = productCnt;
		this.order = order;
	}


	public int getpOrderNo() {
		return pOrderNo;
	}


	public void setpOrderNo(int pOrderNo) {
		this.pOrderNo = pOrderNo;
	}


	public String getpOrderPdate() {
		return pOrderPdate;
	}


	public void setpOrderPdate(String pOrderPdate) {
		this.pOrderPdate = pOrderPdate;
	}


	public int getpOrderPtotal() {
		return pOrderPtotal;
	}


	public void setpOrderPtotal(int pOrderPtotal) {
		this.pOrderPtotal = pOrderPtotal;
	}


	public int getpOrderPno() {
		return pOrderPno;
	}


	public void setpOrderPno(int pOrderPno) {
		this.pOrderPno = pOrderPno;
	}


	public String getpOrderCcheck() {
		return pOrderCcheck;
	}


	public void setpOrderCcheck(String pOrderCcheck) {
		this.pOrderCcheck = pOrderCcheck;
	}


	public String getpOrderPcheck() {
		return pOrderPcheck;
	}


	public void setpOrderPcheck(String pOrderPcheck) {
		this.pOrderPcheck = pOrderPcheck;
	}


	public int getpOrderPused() {
		return pOrderPused;
	}


	public void setpOrderPused(int pOrderPused) {
		this.pOrderPused = pOrderPused;
	}


	public int getpOrderDtotal() {
		return pOrderDtotal;
	}


	public void setpOrderDtotal(int pOrderDtotal) {
		this.pOrderDtotal = pOrderDtotal;
	}


	public String getpOrderPstatus() {
		return pOrderPstatus;
	}


	public void setpOrderPstatus(String pOrderPstatus) {
		this.pOrderPstatus = pOrderPstatus;
	}


	public int getpOrderPay() {
		return pOrderPay;
	}


	public void setpOrderPay(int pOrderPay) {
		this.pOrderPay = pOrderPay;
	}


	public int getpOrderGcheck() {
		return pOrderGcheck;
	}


	public void setpOrderGcheck(int pOrderGcheck) {
		this.pOrderGcheck = pOrderGcheck;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getCouponNo() {
		return couponNo;
	}


	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}


	public int getpStockNo() {
		return pStockNo;
	}


	public void setpStockNo(int pStockNo) {
		this.pStockNo = pStockNo;
	}



	public int getOdOptionNo() {
		return odOptionNo;
	}


	public void setOdOptionNo(int odOptionNo) {
		this.odOptionNo = odOptionNo;
	}


	public int getUuserNo() {
		return uuserNo;
	}


	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductDiscount() {
		return productDiscount;
	}


	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}


	public int getProductCnt() {
		return productCnt;
	}


	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}


	public List<PorderVO> getOrder() {
		return order;
	}

	public void setOrder(List<PorderVO> porder) {
		this.order = porder;
	}

	
}
	