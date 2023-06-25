package vo.review;

public class ReviewVO {

	private int reviewNo;
	private int uuserNo;
	private int productNo;
	private int reviewStar;	//별점
	private String reviewPhoto;
	private String reviewContent;
	private String reviewDate;// 작성날짜
	private int reviewPcheck; // 사진 여부
	
	
	// 테이블에도 컬럼을 추가???????????????
	
	private int groupno; //글의 그룹을 정하는 숫자 보통 원글의 시퀀스
	private int orderno; //출력 순서
	private int depth; // 깊이
	
	
	private String uuserId;
	private String uuserNickname;
	
	
	public ReviewVO() {

	}
	
	
	public ReviewVO(int reviewNo, int uuserNo, int productNo, int reviewStar, String reviewPhoto, String reviewContent,
			String reviewDate, int reviewPcheck) {
		super();
		this.reviewNo = reviewNo;
		this.uuserNo = uuserNo;
		this.productNo = productNo;
		this.reviewStar = reviewStar;
		this.reviewPhoto = reviewPhoto;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewPcheck = reviewPcheck;
	}


	
	public ReviewVO(int reviewNo, int uuserNo, int productNo, int reviewStar, String reviewPhoto, String reviewContent,
			String reviewDate, int reviewPcheck, String uuserId, String uuserNickname) {
		super();
		this.reviewNo = reviewNo;
		this.uuserNo = uuserNo;
		this.productNo = productNo;
		this.reviewStar = reviewStar;
		this.reviewPhoto = reviewPhoto;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewPcheck = reviewPcheck;
		this.uuserId = uuserId;
		this.uuserNickname = uuserNickname;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getUuserNo() {
		return uuserNo;
	}


	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getReviewStar() {
		return reviewStar;
	}


	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}


	public String getReviewPhoto() {
		return reviewPhoto;
	}


	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public String getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	public int getReviewPcheck() {
		return reviewPcheck;
	}


	public void setReviewPcheck(int reviewPcheck) {
		this.reviewPcheck = reviewPcheck;
	}


	public String getUuserId() {
		return uuserId;
	}


	public void setUuserId(String uuserId) {
		this.uuserId = uuserId;
	}


	public String getUuserNickname() {
		return uuserNickname;
	}


	public void setUuserNickname(String uuserNickname) {
		this.uuserNickname = uuserNickname;
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
	
	
	
	
	
	
	
}
