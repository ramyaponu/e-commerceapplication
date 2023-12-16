package com.example.webproject.dto;

import java.time.LocalDateTime;

public class OrderDto {
  
	Integer orderId;
	String orderStatus;
	LocalDateTime orderDate;
	private List<OrderProduct> orderProduct;
	
	
}
