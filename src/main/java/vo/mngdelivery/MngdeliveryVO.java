package vo.mngdelivery;

public class MngdeliveryVO {

	private int mngdeliveryNo;
	private String mngdeliveryAddress;
	private String mngdeliveryDetail;
	private String mngdeliveryMemo;
	private int mngdeliveryBasic;
	private String mngdeliveryDname;
	private String mngdeliveryPname;
	private int uuserNo;
	private String mngdeliveryZipcode;

	public MngdeliveryVO() {
	}

	public MngdeliveryVO(String mngdeliveryAddrdss, String mngdelivertDetail, String mngdeliveryMemo,
			int mngdeliveryBasic, String mngdeliveryDname, String mngdeliveryPname, int uuserNo,String mngdeliveryZipcode) {
		super();
		this.mngdeliveryAddress = mngdeliveryAddrdss;
		this.mngdeliveryDetail = mngdelivertDetail;
		this.mngdeliveryMemo = mngdeliveryMemo;
		this.mngdeliveryBasic = mngdeliveryBasic;
		this.mngdeliveryDname = mngdeliveryDname;
		this.mngdeliveryPname = mngdeliveryPname;
		this.uuserNo = uuserNo;
		this.mngdeliveryZipcode=mngdeliveryZipcode;
	}

	public MngdeliveryVO(int mngdeliveryNo, String mngdeliveryAddrdss, String mngdelivertDetail, String mngdeliveryMemo,
			int mngdeliveryBasic, String mngdeliveryDname, String mngdeliveryPname, int uuserNo, String mngdeliveryZipcode) {
		super();
		this.mngdeliveryNo = mngdeliveryNo;
		this.mngdeliveryAddress = mngdeliveryAddrdss;
		this.mngdeliveryDetail = mngdelivertDetail;
		this.mngdeliveryMemo = mngdeliveryMemo;
		this.mngdeliveryBasic = mngdeliveryBasic;
		this.mngdeliveryDname = mngdeliveryDname;
		this.mngdeliveryPname = mngdeliveryPname;
		this.uuserNo = uuserNo;
		this.mngdeliveryZipcode = mngdeliveryZipcode;
	}

	public String getMngdeliveryZipcode() {
		return mngdeliveryZipcode;
	}

	public void setMngdeliveryZipcode(String mngdeliveryZipcode) {
		this.mngdeliveryZipcode = mngdeliveryZipcode;
	}

	public int getMngdeliveryNo() {
		return mngdeliveryNo;
	}

	public void setMngdeliveryNo(int mngdeliveryNo) {
		this.mngdeliveryNo = mngdeliveryNo;
	}

	public String getMngdeliveryAddress() {
		return mngdeliveryAddress;
	}

	public void setMngdeliveryAddress(String mngdeliveryAddress) {
		this.mngdeliveryAddress = mngdeliveryAddress;
	}

	public String getMngdeliveryDetail() {
		return mngdeliveryDetail;
	}

	public void setMngdeliveryDetail(String mngdeliveryDetail) {
		this.mngdeliveryDetail = mngdeliveryDetail;
	}

	public String getMngdeliveryMemo() {
		return mngdeliveryMemo;
	}

	public void setMngdeliveryMemo(String mngdeliveryMemo) {
		this.mngdeliveryMemo = mngdeliveryMemo;
	}

	public int getMngdeliveryBasic() {
		return mngdeliveryBasic;
	}

	public void setMngdeliveryBasic(int mngdeliveryBasic) {
		this.mngdeliveryBasic = mngdeliveryBasic;
	}

	public String getMngdeliveryDname() {
		return mngdeliveryDname;
	}

	public void setMngdeliveryDname(String mngdeliveryDname) {
		this.mngdeliveryDname = mngdeliveryDname;
	}

	public String getMngdeliveryPname() {
		return mngdeliveryPname;
	}

	public void setMngdeliveryPname(String mngdeliveryPname) {
		this.mngdeliveryPname = mngdeliveryPname;
	}

	public int getUuserNo() {
		return uuserNo;
	}

	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}

}
