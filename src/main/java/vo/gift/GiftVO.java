package vo.gift;

public class GiftVO {

	private int giftNo;
	private String giftMeno;
	private String giftPname;
	private int giftPphone;
	private int porderNo;
	private int uuserNo;
	
	public GiftVO() {
	}

	public GiftVO(String giftMemo, String giftPname, int giftPphone, int porderNo, int uuserNo) {
		super();
		this.giftMeno=giftMemo;
		this.giftPname = giftPname;
		this.giftPphone = giftPphone;
		this.porderNo = porderNo;
		this.uuserNo=uuserNo;
	}
	
	public GiftVO(int giftNo, String giftMemo, String giftPname, int giftPphone, int porderNo, int uuserNo) {
		super();
		this.giftNo = giftNo;
		this.giftMeno=giftMemo;
		this.giftPname = giftPname;
		this.giftPphone = giftPphone;
		this.porderNo = porderNo;
		this.uuserNo=uuserNo;
	}

	public int getGiftNo() {
		return giftNo;
	}

	public void setGiftNo(int giftNo) {
		this.giftNo = giftNo;
	}

	public String getGiftMeno() {
		return giftMeno;
	}

	public void setGiftMeno(String giftMeno) {
		this.giftMeno = giftMeno;
	}

	public String getGiftPname() {
		return giftPname;
	}

	public void setGiftPname(String giftPname) {
		this.giftPname = giftPname;
	}

	public int getGiftPphone() {
		return giftPphone;
	}

	public void setGiftPphone(int giftPphone) {
		this.giftPphone = giftPphone;
	}

	public int getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(int porderNo) {
		this.porderNo = porderNo;
	}

	public int getUuserNo() {
		return uuserNo;
	}

	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}
	
	
}
