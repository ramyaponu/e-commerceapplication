package com.example.webproject.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.webproject.entity2.OrderProduct;

public class OrderDto {
  
	Integer orderId;
	String orderStatus;
	LocalDateTime orderDate;
	private List<OrderProduct> orderProduct;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public OrderDto(Integer orderId, String orderStatus, LocalDateTime orderDate, List<OrderProduct> orderProduct) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderProduct = orderProduct;
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", orderProduct=" + orderProduct + "]";
	}
	
	
}
