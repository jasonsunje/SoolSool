package vo.poption;

public class PoptionVO {
	
	private int poptionNo;
	private int productNo;
	private int poptionContents;
	private int poptionCnt;
	
	
	public PoptionVO() {
		super();
	}

	public PoptionVO(int poptionNo, int productNo, int poptionContents, int poptionCnt) {
		super();
		this.poptionNo = poptionNo;
		this.productNo = productNo;
		this.poptionContents = poptionContents;
		this.poptionCnt = poptionCnt;
	}

	public int getPoptionNo() {
		return poptionNo;
	}

	public void setPoptionNo(int poptionNo) {
		this.poptionNo = poptionNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getPoptionContents() {
		return poptionContents;
	}

	public void setPoptionContents(int poptionContents) {
		this.poptionContents = poptionContents;
	}

	public int getPoptionCnt() {
		return poptionCnt;
	}

	public void setPoptionCnt(int poptionCnt) {
		this.poptionCnt = poptionCnt;
	}

}

