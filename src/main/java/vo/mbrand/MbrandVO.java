package vo.mbrand;

public class MbrandVO {

	private int mbrandNo;
	private int mcompanyNo;
	private String mbrandName;
	
	
	public MbrandVO() {
		super();
	}


	public MbrandVO(int mbrandNo, int mcompanyNo, String mbrandName) {
		super();
		this.mbrandNo = mbrandNo;
		this.mcompanyNo = mcompanyNo;
		this.mbrandName = mbrandName;
	}


	public int getMbrandNo() {
		return mbrandNo;
	}


	public void setMbrandNo(int mbrandNo) {
		this.mbrandNo = mbrandNo;
	}


	public int getMcompanyNo() {
		return mcompanyNo;
	}


	public void setMcompanyNo(int mcompanyNo) {
		this.mcompanyNo = mcompanyNo;
	}


	public String getMbrandName() {
		return mbrandName;
	}


	public void setMbrandName(String mbrandName) {
		this.mbrandName = mbrandName;
	}


}