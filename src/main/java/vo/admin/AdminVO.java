package vo.admin;

public class AdminVO {

	private String adminNo;
	private String adminId;
	private String adminPw;
	private String adminEmail;
	private String adminPhone;
	private String adminName;
	private String adminTeam;
	private String adminPosition;
	
	
	public AdminVO() {
		super();
	}

	
	
	public AdminVO(String adminNo, String adminId, String adminPw) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPw = adminPw;
	}


	public AdminVO(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	

	public AdminVO(String adminNo, String adminId, String adminPw, String adminEmail, String adminPhone, String adminName, String adminTeam, String adminPosition) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
		this.adminName = adminName;
		this.adminTeam = adminTeam;
		this.adminPosition = adminPosition;
	}



	public String getAdminNo() {
		return adminNo;
	}



	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



	public String getAdminPw() {
		return adminPw;
	}



	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}



	public String getAdminEmail() {
		return adminEmail;
	}



	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	public String getAdminPhone() {
		return adminPhone;
	}



	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}



	public String getAdminName() {
		return adminName;
	}



	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}



	public String getAdminTeam() {
		return adminTeam;
	}



	public void setAdminTeam(String adminTeam) {
		this.adminTeam = adminTeam;
	}



	public String getAdminPosition() {
		return adminPosition;
	}



	public void setAdminPosition(String adminPosition) {
		this.adminPosition = adminPosition;
	}
}



	