package vo.sooltype;

public class SooltypeVO {

	private int sooltypeNo;
	private String sooltypeName;
	
	
	public SooltypeVO() {
		super();
	}

	
	
	public SooltypeVO(int sooltypeNo, String sooltypeName) {
		super();
		this.sooltypeNo = sooltypeNo;
		this.sooltypeName = sooltypeName;
	}



	public int getSooltypeNo() {
		return sooltypeNo;
	}


	public void setSooltypeNo(int sooltypeNo) {
		this.sooltypeNo = sooltypeNo;
	}


	public String getSooltypeName() {
		return sooltypeName;
	}


	public void setSooltypeName(String sooltypeName) {
		this.sooltypeName = sooltypeName;
	}

	
}
