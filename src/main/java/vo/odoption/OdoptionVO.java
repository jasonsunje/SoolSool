package vo.odoption;

public class OdoptionVO {

	private int odOptionNo;
	private int productNo;
	private int odOptionCnt;
	
	
	
	public OdoptionVO() {
		super();
	}



	public OdoptionVO(int odOptionNo, int productNo, int odOptionCnt) {
		super();
		this.odOptionNo = odOptionNo;
		this.productNo = productNo;
		this.odOptionCnt = odOptionCnt;
	}



	public int getOdOptionNo() {
		return odOptionNo;
	}



	public void setOdOptionNo(int odOptionNo) {
		this.odOptionNo = odOptionNo;
	}



	public int getProductNo() {
		return productNo;
	}



	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}



	public int getOdOptionCnt() {
		return odOptionCnt;
	}



	public void setOdOptionCnt(int odOptionCnt) {
		this.odOptionCnt = odOptionCnt;
	}
		
}
