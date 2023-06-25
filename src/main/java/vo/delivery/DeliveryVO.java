package vo.delivery;

public class DeliveryVO {

	private int deliveryNo;
	private int deliveryCharge;
	private int porderNO;
	private int uuserNo;
	private int mngdeliveryNo;
	
	public DeliveryVO() {
	}

	public DeliveryVO(int deliveryCharge, int porderNo, int uuserNo, int mngdeliveryNo) {
		super();
		this.deliveryCharge = deliveryCharge;
		this.porderNO = porderNo;
		this.uuserNo = uuserNo;
		this.mngdeliveryNo = mngdeliveryNo;
	}

	public DeliveryVO(int deleveryNo, int deliveryCharge, int porderNo, int uuserNo, int mngdeliveryNo) {
		super();
		this.deliveryNo = deleveryNo;
		this.deliveryCharge = deliveryCharge;
		this.porderNO = porderNo;
		this.uuserNo = uuserNo;
		this.mngdeliveryNo = mngdeliveryNo;
	}

	public int getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public int getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public int getPorderNO() {
		return porderNO;
	}

	public void setPorderNO(int porderNO) {
		this.porderNO = porderNO;
	}

	public int getUuserNo() {
		return uuserNo;
	}

	public void setUuserNo(int uuserNo) {
		this.uuserNo = uuserNo;
	}

	public int getMngdeliveryNo() {
		return mngdeliveryNo;
	}

	public void setMngdeliveryNo(int mngdeliveryNo) {
		this.mngdeliveryNo = mngdeliveryNo;
	}
	
	
}
