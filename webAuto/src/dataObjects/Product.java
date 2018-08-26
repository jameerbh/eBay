package dataObjects;

public class Product {
	
	public String name;
	public String cost;
	public String productID;
	public String productDesc;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Product(String name, String cost, String productID, String productDesc) {
		super();
		this.name = name;
		this.cost = cost;
		this.productID = productID;
		this.productDesc = productDesc;
	}

	
}
