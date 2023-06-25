package vo.ppackage;

public class PpackageVO {

	private int ppackageNo;
	private String ppackageName;
	private int productNo;
	
	
	public PpackageVO() {
		super();
	}

	public PpackageVO(int ppackageNo, String ppackageName, int productNo) {
		super();
		this.ppackageNo = ppackageNo;
		this.ppackageName = ppackageName;
		this.productNo = productNo;
	}

	public int getPpackageNo() {
		return ppackageNo;
	}

	public void setPpackageNo(int ppackageNo) {
		this.ppackageNo = ppackageNo;
	}

	public String getPpackageName() {
		return ppackageName;
	}

	public void setPpackageName(String ppackageName) {
		this.ppackageName = ppackageName;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

}