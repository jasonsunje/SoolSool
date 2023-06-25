package vo.bottle;

public class BottleVO {

	private int bottleNo;
	private int bottleAmount;
	private int bottleUnit;
	private int productNo;


	
	
	public BottleVO() {
		super();
	}


	public BottleVO(int bottleNo, int bottleAmount, int bottleUnit, int productNo) {
		super();
		this.bottleNo = bottleNo;
		this.bottleAmount = bottleAmount;
		this.bottleUnit = bottleUnit;
		this.productNo = productNo;
	}


	public int getBottleNo() {
		return bottleNo;
	}


	public void setBottleNo(int bottleNo) {
		this.bottleNo = bottleNo;
	}


	public int getBottleAmount() {
		return bottleAmount;
	}


	public void setBottleAmount(int bottleAmount) {
		this.bottleAmount = bottleAmount;
	}


	public int getBottleUnit() {
		return bottleUnit;
	}


	public void setBottleUnit(int bottleUnit) {
		this.bottleUnit = bottleUnit;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

}
	
	