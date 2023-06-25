package vo.catedetail;

public class CatedetailVO {


	private int catedetailNo;
	private String catedetailSection;
	private String catedetailName;
	
	
	public CatedetailVO() {
		super();
	}


	public CatedetailVO(int catedetailNo, String catedetailSection, String catedetailName) {
		super();
		this.catedetailNo = catedetailNo;
		this.catedetailSection = catedetailSection;
		this.catedetailName = catedetailName;
	}


	public int getCatedetailNo() {
		return catedetailNo;
	}


	public void setCatedetailNo(int catedetailNo) {
		this.catedetailNo = catedetailNo;
	}


	public String getCatedetailSection() {
		return catedetailSection;
	}


	public void setCatedetailSection(String catedetailSection) {
		this.catedetailSection = catedetailSection;
	}


	public String getCatedetailName() {
		return catedetailName;
	}


	public void setCatedetailName(String catedetailName) {
		this.catedetailName = catedetailName;
	}


}