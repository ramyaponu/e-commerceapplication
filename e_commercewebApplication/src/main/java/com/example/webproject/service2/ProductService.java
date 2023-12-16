package com.example.webproject.service2;

import org.springframework.http.ResponseEntity;

import com.example.webproject.Exception.OrderException;
import com.example.webproject.dto2.OrderProductDto;
import com.example.webproject.entity2.OrderProduct;

public interface ProductService {
	
	public String addProducts(OrderProductDto dto)throws Exception;
	
	public OrderProductDto viewProducts(Integer productId) throws OrderException ;
	
	public OrderProduct getProduct(String productName)throws OrderException;
}
