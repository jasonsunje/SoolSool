package vo.ffilter;

public class FfilterVO {

	private int ffilterNo;
	private String ffilterName;
	private String ffilterContent;
	
	
	public FfilterVO() {
		super();
	}


	public FfilterVO(int ffilterNo, String ffilterName, String ffilterContent) {
		super();
		this.ffilterNo = ffilterNo;
		this.ffilterName = ffilterName;
		this.ffilterContent = ffilterContent;
	}


	public int getFfilterNo() {
		return ffilterNo;
	}


	public void setFfilterNo(int ffilterNo) {
		this.ffilterNo = ffilterNo;
	}


	public String getFfilterName() {
		return ffilterName;
	}


	public void setFfilterName(String ffilterName) {
		this.ffilterName = ffilterName;
	}


	public String getFfilterContent() {
		return ffilterContent;
	}


	public void setFfilterContent(String ffilterContent) {
		this.ffilterContent = ffilterContent;
	}

}