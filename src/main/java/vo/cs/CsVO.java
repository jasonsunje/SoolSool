package vo.cs;

public class CsVO {

	private int csNo; // seq
	private int uuserNo;
	private String csTitle;
	private String csContent;
	private String csDate;
	private int csHit;
	
	
	private int groupno; //글의 그룹을 정하는 숫자 보통 원글의 시퀀스
	private int orderno; //출력 순서
	private int depth; // 깊이

	// 필요한 다른 테이블의 컬럼을 여기에 추가하여 사용하기도 한다.
	private String csFileTitle;

	
	
	public CsVO() {

	}

	public CsVO(int csNo, int uuserNo, String csTitle, String csContent, String csDate) {
		super();
		this.csNo = csNo;
		this.uuserNo = uuserNo;
		this.csTitle = csTitle;
		this.csContent = csContent;
		this.csDate = csDate;
	}
	
	

	public CsVO(int csNo, int uuserNo, String csTitle, String csContent, String csDate, int csHit
			) {
		super();
		this.csNo = csNo;
		this.uuserNo = uuserNo;
		this.csTitle = csTitle;
		this.csContent = csContent;
		this.csDate = csDate;
		this.csHit = csHit;
	}
	
	

	public CsVO(int csNo, int uuserNo, String csTitle, String csContent, String csDate, int csHit, String csFileTitle
			) {
		super();
		this.csNo = csNo;
		this.uuserNo = uuserNo;
		this.csTitle = csTitle;
		this.csContent = csContent;
		this.csDate = csDate;
		this.csHit = csHit;
		this.csFileTitle = csFileTitle;
	}

	public int getCsNo() {
		return csNo;
	}

	public void setCsNo(int csNo) {
		this.csNo = csNo;
	}

	public int getUuserNo() {
		return uuserNo;
	}

	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}

	
	public String getCsTitle() {
		return csTitle;
	}

	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}

	public String getCsContent() {
		return csContent;
	}

	public void setCsContent(String csContent) {
		this.csContent = csContent;
	}

	public String getCsDate() {
		return csDate;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}

	public int getCsHit() {
		return csHit;
	}

	public void setCsHit(int csHit) {
		this.csHit = csHit;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}


	public String getCsFileTitle() {
		return csFileTitle;
	}

	public void setCsFileTitle(String csFileTitle) {
		this.csFileTitle = csFileTitle;
	}


	
	
	
}
