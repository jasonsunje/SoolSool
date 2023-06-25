package vo.withdrawal;

public class WithdrawalVO {

	private int withdrawalNo;
	private int uuserNo;
	private String withdrawalReason;
	private String withdrawalDate;
	
	
	public WithdrawalVO() {

	}
	
	public WithdrawalVO(int withdrawalNo, int uuserNo, String withdrawalReason, String withdrawalDate) {
		super();
		this.withdrawalNo = withdrawalNo;
		this.uuserNo = uuserNo;
		this.withdrawalReason = withdrawalReason;
		this.withdrawalDate = withdrawalDate;
	}
	
	public int getWithdrawalNo() {
		return withdrawalNo;
	}
	public void setWithdrawalNo(int withdrawalNo) {
		this.withdrawalNo = withdrawalNo;
	}
	public int getUuserNo() {
		return uuserNo;
	}
	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}
	public String getWithdrawalReason() {
		return withdrawalReason;
	}
	public void setWithdrawalReason(String withdrawalReason) {
		this.withdrawalReason = withdrawalReason;
	}
	public String getWithdrawalDate() {
		return withdrawalDate;
	}
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}
	
	
	
	
}
