package com.example.webproject.dto2;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class OrderProductDto {
   
	private Integer productId;
	@NotNull(message = "plese provide the prodName")
	@Pattern(regexp = "[a-zA-Z]+", message = "{orderproductdto.productname.invalid}")
	private String productName;
	private int productQuantity;
	private double productCost;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	
	
}
