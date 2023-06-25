package vo.minfo;

import java.sql.Date;

public class MinfoVO {

	private int minfoNo;
	private int productNo;
	private String minfoTexture;
	private String minfoComponent;
	private String minfoSize;
	private Date minfoReleasedate;
	private int mcompanyNo;
	private String minfoMadeNation;
	private String minfoImportdeclaration;
	private String minfoQualityAssuranceCriteria;
	
	
	public MinfoVO() {
		super();
	}


	public MinfoVO(int minfoNo, int productNo, String minfoTexture, String minfoComponent, String minfoSize,
			Date minfoReleasedate, int mcompanyNo, String minfoMadeNation, String minfoImportdeclaration,
			String minfoQualityAssuranceCriteria) {
		super();
		this.minfoNo = minfoNo;
		this.productNo = productNo;
		this.minfoTexture = minfoTexture;
		this.minfoComponent = minfoComponent;
		this.minfoSize = minfoSize;
		this.minfoReleasedate = minfoReleasedate;
		this.mcompanyNo = mcompanyNo;
		this.minfoMadeNation = minfoMadeNation;
		this.minfoImportdeclaration = minfoImportdeclaration;
		this.minfoQualityAssuranceCriteria = minfoQualityAssuranceCriteria;
	}


	public int getMinfoNo() {
		return minfoNo;
	}


	public void setMinfoNo(int minfoNo) {
		this.minfoNo = minfoNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getMinfoTexture() {
		return minfoTexture;
	}


	public void setMinfoTexture(String minfoTexture) {
		this.minfoTexture = minfoTexture;
	}


	public String getMinfoComponent() {
		return minfoComponent;
	}


	public void setMinfoComponent(String minfoComponent) {
		this.minfoComponent = minfoComponent;
	}


	public String getMinfoSize() {
		return minfoSize;
	}


	public void setMinfoSize(String minfoSize) {
		this.minfoSize = minfoSize;
	}


	public Date getMinfoReleasedate() {
		return minfoReleasedate;
	}


	public void setMinfoReleasedate(Date minfoReleasedate) {
		this.minfoReleasedate = minfoReleasedate;
	}


	public int getMcompanyNo() {
		return mcompanyNo;
	}


	public void setMcompanyNo(int mcompanyNo) {
		this.mcompanyNo = mcompanyNo;
	}


	public String getMinfoMadeNation() {
		return minfoMadeNation;
	}


	public void setMinfoMadeNation(String minfoMadeNation) {
		this.minfoMadeNation = minfoMadeNation;
	}


	public String getMinfoImportdeclaration() {
		return minfoImportdeclaration;
	}


	public void setMinfoImportdeclaration(String minfoImportdeclaration) {
		this.minfoImportdeclaration = minfoImportdeclaration;
	}


	public String getMinfoQualityAssuranceCriteria() {
		return minfoQualityAssuranceCriteria;
	}


	public void setMinfoQualityAssuranceCriteria(String minfoQualityAssuranceCriteria) {
		this.minfoQualityAssuranceCriteria = minfoQualityAssuranceCriteria;
	}

}