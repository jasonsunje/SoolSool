package vo.pstock;

public class PstockVO {

	private int pstockNo;
	private int productNo;
	private int pstockCnt;
	
	
	public PstockVO() {
		super();
	}

	public PstockVO(int pstockNo, int productNo, int pstockCnt) {
		super();
		this.pstockNo = pstockNo;
		this.productNo = productNo;
		this.pstockCnt = pstockCnt;
	}

	public int getPstockNo() {
		return pstockNo;
	}

	public void setPstockNo(int pstockNo) {
		this.pstockNo = pstockNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getPstockCnt() {
		return pstockCnt;
	}

	public void setPstockCnt(int pstockCnt) {
		this.pstockCnt = pstockCnt;
	}

}