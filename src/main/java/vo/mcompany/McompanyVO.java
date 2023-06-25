package vo.mcompany;

public class McompanyVO {

	private int mcompanyNo;
	private String mcompanyNation;
	private String mcompanyPhone;
	private String mcompanyEmail;
	private String mcompanyName;
	private String mcompanyMailordernum;
	private String mcompanyAddress;
	private String mcompanyRegistrationnum;
	private String mcompanyCeoname;
	private String mcompanyStory;
	
	private int productNo;
	private int mbrandNo;
	
	
	public McompanyVO() {
		super();
	}


	public McompanyVO(int mcompanyNo, String mcompanyNation, String mcompanyPhone, String mcompanyEmail,
			String mcompanyName, String mcompanyMailordernum, String mcompanyAddress, String mcompanyRegistrationnum,
			String mcompanyCeoname, String mcompanyStory, int productNo, int mbrandNo) {
		super();
		this.mcompanyNo = mcompanyNo;
		this.mcompanyNation = mcompanyNation;
		this.mcompanyPhone = mcompanyPhone;
		this.mcompanyEmail = mcompanyEmail;
		this.mcompanyName = mcompanyName;
		this.mcompanyMailordernum = mcompanyMailordernum;
		this.mcompanyAddress = mcompanyAddress;
		this.mcompanyRegistrationnum = mcompanyRegistrationnum;
		this.mcompanyCeoname = mcompanyCeoname;
		this.mcompanyStory = mcompanyStory;
		this.productNo = productNo;
		this.mbrandNo = mbrandNo;
	}


	public int getMcompanyNo() {
		return mcompanyNo;
	}


	public void setMcompanyNo(int mcompanyNo) {
		this.mcompanyNo = mcompanyNo;
	}


	public String getMcompanyNation() {
		return mcompanyNation;
	}


	public void setMcompanyNation(String mcompanyNation) {
		this.mcompanyNation = mcompanyNation;
	}


	public String getMcompanyPhone() {
		return mcompanyPhone;
	}


	public void setMcompanyPhone(String mcompanyPhone) {
		this.mcompanyPhone = mcompanyPhone;
	}


	public String getMcompanyEmail() {
		return mcompanyEmail;
	}


	public void setMcompanyEmail(String mcompanyEmail) {
		this.mcompanyEmail = mcompanyEmail;
	}


	public String getMcompanyName() {
		return mcompanyName;
	}


	public void setMcompanyName(String mcompanyName) {
		this.mcompanyName = mcompanyName;
	}


	public String getMcompanyMailordernum() {
		return mcompanyMailordernum;
	}


	public void setMcompanyMailordernum(String mcompanyMailordernum) {
		this.mcompanyMailordernum = mcompanyMailordernum;
	}


	public String getMcompanyAddress() {
		return mcompanyAddress;
	}


	public void setMcompanyAddress(String mcompanyAddress) {
		this.mcompanyAddress = mcompanyAddress;
	}


	public String getMcompanyRegistrationnum() {
		return mcompanyRegistrationnum;
	}


	public void setMcompanyRegistrationnum(String mcompanyRegistrationnum) {
		this.mcompanyRegistrationnum = mcompanyRegistrationnum;
	}


	public String getMcompanyCeoname() {
		return mcompanyCeoname;
	}


	public void setMcompanyCeoname(String mcompanyCeoname) {
		this.mcompanyCeoname = mcompanyCeoname;
	}


	public String getMcompanyStory() {
		return mcompanyStory;
	}


	public void setMcompanyStory(String mcompanyStory) {
		this.mcompanyStory = mcompanyStory;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getMbrandNo() {
		return mbrandNo;
	}


	public void setMbrandNo(int mbrandNo) {
		this.mbrandNo = mbrandNo;
	}

}