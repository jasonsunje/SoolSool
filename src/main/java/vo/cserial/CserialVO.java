package vo.cserial;

import java.sql.Date;

public class CserialVO {

	private int cserialNo;
	private int couponNo;
	private Date cserialStart;
	private Date cserialEnd;
	private String cserialId;
	private int cserialStatus;

	public CserialVO() {
	}

	public CserialVO(int couponNo, Date cserialStart, Date cserialEnd, String cserialId, int cserialStatus) {
		super();
		this.couponNo = couponNo;
		this.cserialStart = cserialStart;
		this.cserialEnd = cserialEnd;
		this.cserialId = cserialId;
		this.cserialStatus = cserialStatus;
	}

	public CserialVO(int csderialNo, int couponNo, Date cserialStart, Date cserialEnd, String cserialId,
			int cserialStatus) {
		super();
		this.cserialNo = couponNo;
		this.couponNo = couponNo;
		this.cserialStart = cserialStart;
		this.cserialEnd = cserialEnd;
		this.cserialId = cserialId;
		this.cserialStatus = cserialStatus;
	}
	
	public int getCserialNo() {
		return cserialNo;
	}

	public void setCserialNo(int cserialNo) {
		this.cserialNo = cserialNo;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public Date getCserialStart() {
		return cserialStart;
	}

	public void setCserialStart(Date cserialStart) {
		this.cserialStart = cserialStart;
	}

	public Date getCserialEnd() {
		return cserialEnd;
	}

	public void setCserialEnd(Date cserialEnd) {
		this.cserialEnd = cserialEnd;
	}

	public String getCserialId() {
		return cserialId;
	}

	public void setCserialId(String cserialId) {
		this.cserialId = cserialId;
	}

	public int getCserialStatus() {
		return cserialStatus;
	}

	public void setCserialStatus(int cserialStatus) {
		this.cserialStatus = cserialStatus;
	}

}
