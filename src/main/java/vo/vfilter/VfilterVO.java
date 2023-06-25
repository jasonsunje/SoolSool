package vo.vfilter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VfilterVO {

	@JsonProperty("transaction_time")
	private int vfilterNo;
	private String vfilterName;
	private String vfilterContent;
	
	
	public VfilterVO() {
		super();
	}

	public VfilterVO(int vfilterNo, String vfilterName, String vfilterContent) {
		super();
		this.vfilterNo = vfilterNo;
		this.vfilterName = vfilterName;
		this.vfilterContent = vfilterContent;
	}

	public int getVfilterNo() {
		return vfilterNo;
	}

	public void setVfilterNo(int vfilterNo) {
		this.vfilterNo = vfilterNo;
	}

	public String getVfilterName() {
		return vfilterName;
	}

	public void setVfilterName(String vfilterName) {
		this.vfilterName = vfilterName;
	}

	public String getVfilterContent() {
		return vfilterContent;
	}

	public void setVfilterContent(String vfilterContent) {
		this.vfilterContent = vfilterContent;
	}

}
