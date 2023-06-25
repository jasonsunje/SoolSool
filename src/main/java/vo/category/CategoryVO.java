package vo.category;

public class CategoryVO {


	private int categoryNo;
	private int categoryProducttype;
	private int catedetailNo;
	private int sooltypeNo;
	
	
	public CategoryVO() {
		super();
	}


	public CategoryVO(int categoryNo, int categoryProducttype, int catedetailNo, int sooltypeNo) {
		super();
		this.categoryNo = categoryNo;
		this.categoryProducttype = categoryProducttype;
		this.catedetailNo = catedetailNo;
		this.sooltypeNo = sooltypeNo;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public int getCategoryProducttype() {
		return categoryProducttype;
	}


	public void setCategoryProducttype(int categoryProducttype) {
		this.categoryProducttype = categoryProducttype;
	}


	public int getCatedetailNo() {
		return catedetailNo;
	}


	public void setCatedetailNo(int catedetailNo) {
		this.catedetailNo = catedetailNo;
	}


	public int getSooltypeNo() {
		return sooltypeNo;
	}


	public void setSooltypeNo(int sooltypeNo) {
		this.sooltypeNo = sooltypeNo;
	}

	
}