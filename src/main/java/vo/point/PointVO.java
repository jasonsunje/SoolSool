package vo.point;

import java.sql.Date;

public class PointVO {

	private int pointNo;
	private int pointMy;
	private int pointAble;
	private int pointExtionction;
	private String pointReason;
	private Date pointEnd;
	private int pdetailNo;
	private int uuserNo;
	private Date pointStart;

	public PointVO() {
		super();
	}

	public PointVO(int pointNo, int pointMy, int pointAble, int pointExtionction, String pointReason, Date pointEnd, int pdetailNo,
			Date pointStart, int uuserNo) {
		super();
		this.pointNo = pointNo;
		this.pointMy = pointMy;
		this.pointAble = pointAble;
		this.pointExtionction = pointExtionction;
		this.pointReason = pointReason;
		this.pointEnd = pointEnd;
		this.pointStart = pointStart;
		this.pdetailNo = pdetailNo;
		this.uuserNo = uuserNo;
	}

	public Date getPointStart() {
		return pointStart;
	}

	public void setPointStart(Date pointStart) {
		this.pointStart = pointStart;
	}

	public int getPointNo() {
		return pointNo;
	}

	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}

	public int getPointMy() {
		return pointMy;
	}

	public void setPointMy(int pointMy) {
		this.pointMy = pointMy;
	}

	public int getPointAble() {
		return pointAble;
	}

	public void setPointAble(int pointAble) {
		this.pointAble = pointAble;
	}

	public int getPointExtionction() {
		return pointExtionction;
	}

	public void setPointExtionction(int pointExtionction) {
		this.pointExtionction = pointExtionction;
	}

	public String getPointReason() {
		return pointReason;
	}

	public void setPointReason(String pointReason) {
		this.pointReason = pointReason;
	}

	public Date getPointEnd() {
		return pointEnd;
	}

	public void setPointEnd(Date pointEnd) {
		this.pointEnd = pointEnd;
	}

	public int getPdetailNo() {
		return pdetailNo;
	}

	public void setPdetailNo(int pdetailNo) {
		this.pdetailNo = pdetailNo;
	}

	public int getUuserNo() {
		return uuserNo;
	}

	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}

}
