package vo.ingredient;

public class IngredientVO {

	private String ingredientNo;
	private String ingredientName;
	private int productNo;
	private int ingredientAmount;
	private String ingredientUnit;
	
	
	public IngredientVO() {
		super();
	}


	public IngredientVO(String ingredientNo, String ingredientName, int productNo, int ingredientAmount,
			String ingredientUnit) {
		super();
		this.ingredientNo = ingredientNo;
		this.ingredientName = ingredientName;
		this.productNo = productNo;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
	}


	public String getIngredientNo() {
		return ingredientNo;
	}


	public void setIngredientNo(String ingredientNo) {
		this.ingredientNo = ingredientNo;
	}


	public String getIngredientName() {
		return ingredientName;
	}


	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getIngredientAmount() {
		return ingredientAmount;
	}


	public void setIngredientAmount(int ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}


	public String getIngredientUnit() {
		return ingredientUnit;
	}


	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}


}