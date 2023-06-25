package vo.product;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	
	private int productSeq;
	private int productNo;
	private String productName;
	private String productImg;
	private String productTag1;
	private String productTag2;
	private int productStar;
	private int productRcnt;
	private int productDiscount;
	private String productIntro;
	private int productAlcohol;
	private String productUpdate;
	private int productPrice;
	private int productWish;
	private int categoryNo;
	private int packageNo;
	
	
	//이미지
	private MultipartFile productPhoto;
	
	public ProductVO() {
		super();
	}


	public ProductVO(int productSeq, int productNo, String productName, String productImg, String productTag1,
			String productTag2, int productStar, int productRcnt, int productDiscount, String productIntro,
			int productAlcohol, String productUpdate, int productPrice, int productWish, int categoryNo, int packageNo) {
		super();
		this.productSeq = productSeq;
		this.productNo = productNo;
		this.productName = productName;
		this.productImg = productImg;
		this.productTag1 = productTag1;
		this.productTag2 = productTag2;
		this.productStar = productStar;
		this.productRcnt = productRcnt;
		this.productDiscount = productDiscount;
		this.productIntro = productIntro;
		this.productAlcohol = productAlcohol;
		this.productUpdate = productUpdate;
		this.productPrice = productPrice;
		this.productWish = productWish;
		this.categoryNo = categoryNo;
		this.packageNo = packageNo;
	}


	public int getProductSeq() {
		return productSeq;
	}


	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductImg() {
		return productImg;
	}


	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}


	public String getProductTag1() {
		return productTag1;
	}


	public void setProductTag1(String productTag1) {
		this.productTag1 = productTag1;
	}


	public String getProductTag2() {
		return productTag2;
	}


	public void setProductTag2(String productTag2) {
		this.productTag2 = productTag2;
	}


	public int getProductStar() {
		return productStar;
	}


	public void setProductStar(int productStar) {
		this.productStar = productStar;
	}


	public int getProductRcnt() {
		return productRcnt;
	}


	public void setProductRcnt(int productRcnt) {
		this.productRcnt = productRcnt;
	}


	public int getProductDiscount() {
		return productDiscount;
	}


	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}


	public String getProductIntro() {
		return productIntro;
	}


	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}


	public int getProductAlcohol() {
		return productAlcohol;
	}


	public void setProductAlcohol(int productAlcohol) {
		this.productAlcohol = productAlcohol;
	}


	public String getProductUpdate() {
		return productUpdate;
	}


	public void setProductUpdate(String productUpdate) {
		this.productUpdate = productUpdate;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductWish() {
		return productWish;
	}


	public void setProductWish(int productWish) {
		this.productWish = productWish;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public int getPackageNo() {
		return packageNo;
	}


	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

}
