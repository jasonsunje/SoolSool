package vo.admin.member;

public class AdminMemberVO {

	private int no;
	private String id;
	private String password;
	private String email;
	private String phone;
	private String team;
	private String grade;
	private String status;
	
	
	public AdminMemberVO() {
		
	}
	
	
	public AdminMemberVO(int no, String id, String password, String email, String phone, String team, String grade,
			String status) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.team = team;
		this.grade = grade;
		this.status = status;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
