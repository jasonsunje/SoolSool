package vo.selldate;

import java.sql.Date;

public class SelldateVO {

	private String selldateNo;
	private Date selldateDate;
	private int productNo;
	
	
	public SelldateVO() {
		super();
	}

	public SelldateVO(String selldateNo, Date selldateDate, int productNo) {
		super();
		this.selldateNo = selldateNo;
		this.selldateDate = selldateDate;
		this.productNo = productNo;
	}

	public String getSelldateNo() {
		return selldateNo;
	}

	public void setSelldateNo(String selldateNo) {
		this.selldateNo = selldateNo;
	}

	public Date getSelldateDate() {
		return selldateDate;
	}

	public void setSelldateDate(Date selldateDate) {
		this.selldateDate = selldateDate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
}