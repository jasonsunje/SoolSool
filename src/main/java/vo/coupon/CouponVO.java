package vo.coupon;

public class CouponVO {

	private int couponNo;
	private String couponName;
	private int couponEdate;
	private int couponBenefit;
	private int productNo;

	public CouponVO() {
	}

	public CouponVO(String couponName, int couponEdate, int couponBenefit, int productNo) {
		super();
		this.couponName = couponName;
		this.couponEdate = couponEdate;
		this.couponBenefit = couponBenefit;
		this.productNo = productNo;
	}

	public CouponVO(int couponNo, String couponName, int couponEdate, int couponBenefit, int productNo) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.couponEdate = couponEdate;
		this.couponBenefit = couponBenefit;
		this.productNo = productNo;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getCouponEdate() {
		return couponEdate;
	}

	public void setCouponEdate(int couponEdate) {
		this.couponEdate = couponEdate;
	}

	public int getCouponBenefit() {
		return couponBenefit;
	}

	public void setCouponBenefit(int couponBenefit) {
		this.couponBenefit = couponBenefit;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

}
