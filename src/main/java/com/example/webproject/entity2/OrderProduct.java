package com.example.webproject.entity2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.webproject.entity.OrderEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class OrderProduct {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
 
	private Integer productId;
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
	
	
	public OrderProduct(Integer productId, String productName, int productQuantity, double productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
		
	}
	@Override
	public String toString() {
		return "OrderProduct [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productCost=" + productCost + "]";
	}
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
